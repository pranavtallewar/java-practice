package designpattern.structural;

/**
 * @author Pranav
 * An Adapter pattern acts as a connector between two incompatible interfaces
 * An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface
 *
 */
public class AdapterPatterDemo {

	public static void main(String[] args) {
		Movable bugattiVeyron = new BugattiVeyron();
		MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
		System.out.println("Bugatti Veyron Super Sport's top speed is " + bugattiVeyronAdapter.getSpeed() + " km/h");

		Movable astonMartin = new AstonMartin();
		MovableAdapter astonMartinAdapter = new MovableAdapterImpl(astonMartin);
		System.out.println("Aston Martin's top speed is " + astonMartinAdapter.getSpeed() + " km/h");

		Movable mcLaren = new McLaren();
		MovableAdapter mcLarenAdapter = new MovableAdapterImpl(mcLaren);
		System.out.println("McLaren's top speed is " + mcLarenAdapter.getSpeed() + " km/h");

	}

}

interface Movable {
	public double getSpeed();
}

class BugattiVeyron implements Movable {

	@Override
	public double getSpeed() {
		return 268;
	}

}

class AstonMartin implements Movable {

	@Override
	public double getSpeed() {
		return 220;
	}
}

class McLaren implements Movable {

	@Override
	public double getSpeed() {
		return 241;
	}
}

interface MovableAdapter {
	public double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {
	private Movable movable;

	public MovableAdapterImpl(Movable movable) {
		this.movable = movable;
	}

	@Override
	public double getSpeed() {
		return convertMphToKmph(movable.getSpeed());
	}

	private double convertMphToKmph(double speed) {
		return speed * 1.60934;
	}
}