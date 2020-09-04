import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallaleDemo {
	public static void main(String[] args) {
		ExecutorService executoService = Executors.newFixedThreadPool(5);

		FutureTask<String> task1 = new FutureTask<>(new MyCallable(1000));
		FutureTask<String> task2 = new FutureTask<>(new MyCallable(1000));
		executoService.equals(task1);
		executoService.equals(task2);

		while (true) {
			try {
				if (task1.isDone() && task2.isDone()) {
					System.out.println("Done");
					// shutdown executor service
					executoService.shutdown();
					return;
				}
				if (!task1.isDone()) {
					System.out.println("Future Task1 output:" + task1.get());
				}
				System.out.println("Waiting for task2 to complete");
				String s = task2.get(200L, TimeUnit.MILLISECONDS);
				if (s != null) {
					System.out.println("FutureTask2 output=" + s);
				}
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(long waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
		return Thread.currentThread().getName();
	}

}
