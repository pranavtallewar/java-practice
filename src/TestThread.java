
public class TestThread {

	public static void main(String[] args) {
		SampleDemo s1 = new SampleDemo("A");
		SampleDemo s2 = new SampleDemo("B");

		s2.start();
		s1.start();
	}

}

class SampleDemo implements Runnable {
	private Thread t;
	private String threadName;

	SampleDemo(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		while (true)
			System.out.println(threadName);

	}

	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
}
