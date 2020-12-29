package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

	public static void main(String[] args) throws InterruptedException {
		Atomicity atomic = new Atomicity();
		
		Thread t1 = new Thread(atomic);
		t1.start();
		Thread t2 = new Thread(atomic);
		t2.start();
		Thread t3 = new Thread(atomic);
		t3.start();
		Thread t4 = new Thread(atomic);
		t4.start();
		Thread t5 = new Thread(atomic);
		t5.start();
		
		t1.join();
		
		  t2.join(); t3.join(); t4.join(); t5.join();
		 
		System.out.println(atomic.i);
	}

}

class Atomicity implements Runnable {
	AtomicInteger i = new AtomicInteger();

	@Override
	public void run() {
		i.incrementAndGet();
	}
	
}
