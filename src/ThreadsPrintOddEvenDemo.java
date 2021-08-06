
public class ThreadsPrintOddEvenDemo {

	public static void main(String[] args) {
		OddEvenPrint threadObj = new OddEvenPrint();
		threadObj.odd = true;

		Thread t1 = new Thread(() -> threadObj.printEven());
		Thread t2 = new Thread(() -> threadObj.printOdd());

		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("in uncaught exception handler");

			}
		};

		t1.setUncaughtExceptionHandler(handler);

		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class OddEvenPrint {
	boolean odd;
	int count = 1;
	int MAX = 20;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				System.out.println("Checking odd loop");
				while (!odd) {
					try {
						System.out.println("Odd waiting : " + count);
						wait();
						System.out.println("Notified odd :" + count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(count);
				count++;
				odd = false;
				notify();
			}

		}
	}

	public void printEven() {

		synchronized (this) {
			while (count < MAX) {

				System.out.println("Checking even loop");
				while (odd) {
					try {
						System.out.println("Even waiting: " + count);
						wait();
						System.out.println("Notified even:" + count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(count);
				count++;
				odd = true;
				notify();
			}
		}
	}
}