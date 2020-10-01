package designpattern.creational;

public class ChoclateFactorySingletonDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				ChocolateBoiler cb = ChocolateBoiler.getInstance();
				System.out.println("Thread T1=" + cb);
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				ChocolateBoiler cb = ChocolateBoiler.getInstance();
				System.out.println("Thread T2= " + cb);

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				ChocolateBoiler cb = ChocolateBoiler.getInstance();
				System.out.println("Thread T3= " + cb);

			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

}

class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;

	private static ChocolateBoiler chocolateBoiler = null;

	// code gets started when boiler is empty
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (chocolateBoiler == null) {
			synchronized (ChocolateBoiler.class) {
				if (chocolateBoiler == null) {
					chocolateBoiler = new ChocolateBoiler();
				}
			}
		}
		return chocolateBoiler;
	}

	// To fill the boiler, it must be empty and, once its full, we set empty and
	// boiled flags to false
	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	// To drain the boiled, it must be full and boiled.
	// Once its drained, we set empty flag back to true.
	public void drain() {
		if (!isEmpty() && !isBoiled()) {
			empty = true;
		}
	}

	// To boil the mixture, boiler has to be full and not already boiled
	// Once its boiled, we set boiler flag to true
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}
}
