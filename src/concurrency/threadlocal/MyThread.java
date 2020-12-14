package concurrency.threadlocal;

public class MyThread extends Thread {

	public static int i = 0;

	public void run() {
		i = i + 1;
	}

	public static void main(String[] args) {
		
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		
		m1.start();
		m2.start();
		
		System.out.println(MyThread.i);
	}
}
