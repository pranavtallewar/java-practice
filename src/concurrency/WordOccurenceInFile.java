package concurrency;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WordOccurenceInFile implements Runnable {

	private FileChannel _channel;
	private long _startLocation;
	private int _size;
	AtomicInteger _sequence_number;

	public WordOccurenceInFile(long loc, int size, FileChannel chnl, AtomicInteger sequence) {
		_startLocation = loc;
		_size = size;
		_channel = chnl;
		_sequence_number = sequence;
	}

	@Override
	public void run() {
		try {
			System.out.println("Reading the channel: " + _startLocation + ":" + _size);

			// allocate memory
			ByteBuffer buff = ByteBuffer.allocate(_size);

			// Read file chunk to RAM
			_channel.read(buff, _startLocation);

			// chunk to String
			String string_chunk = new String(buff.array(), Charset.forName("UTF-8"));

			System.out.println("Done Reading the channel: " + _startLocation + ":" + _size);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// args[0] is path to read file
	// args[1] is the size of thread pool; Need to try different values to fing
	// sweet spot
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(args[0]);
		FileChannel channel = fileInputStream.getChannel();
		long remaining_size = channel.size(); // get the total number of bytes in the file
		long chunk_size = remaining_size / Integer.parseInt(args[1]); // file_size/threads

		// Max allocation size allowed is ~2GB
		if (chunk_size > (Integer.MAX_VALUE - 5)) {
			chunk_size = (Integer.MAX_VALUE - 5);
		}

		// thread pool
		ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(args[1]));

		long start_loc = 0;// file pointer
		AtomicInteger i = new AtomicInteger(0); // loop counter
		while (remaining_size >= chunk_size) {
			// launches a new thread
			executor.execute(new WordOccurenceInFile(start_loc, new Long(chunk_size).intValue(), channel, i));
			remaining_size = remaining_size - chunk_size;
			start_loc = start_loc + chunk_size;
			i.incrementAndGet();
		}

		// load the last remaining piece
		executor.execute(new WordOccurenceInFile(start_loc, new Long(remaining_size).intValue(), channel, i));

		// Tear Down
		executor.shutdown();

		// Wait for all threads to finish
		while (!executor.isTerminated()) {
			// wait for infinity time
		}
		System.out.println("Finished all threads");
		fileInputStream.close();
	}

}