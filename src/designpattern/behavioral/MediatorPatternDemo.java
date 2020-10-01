package designpattern.behavioral;

public class MediatorPatternDemo {

	public static void main(String[] args) {
		Button button = new Button();
		AC ac = new AC();
		PowerSupplier powerSupplier = new PowerSupplier();
		Mediator mediator = new Mediator();
		mediator.setButton(button);
		mediator.setAc(ac);
		mediator.setPowerSupplier(powerSupplier);
		ac.isOn();
		button.press();
		button.press();
	}

}

class Button {

	private Mediator mediator;

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void press() {
		this.mediator.press();
	}
}

class AC {
	private Mediator mediator;
	public boolean isOn = false;

	public boolean isOn() {
		return isOn;
	}

	public void turnOn() {
		this.mediator.start();
		isOn = true;
	}

	public void turnOff() {
		isOn = false;
		this.mediator.stop();
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}

class Mediator {
	private Button button;
	private AC ac;
	private PowerSupplier powerSupplier;

	public void setButton(Button button) {
		this.button = button;
		this.button.setMediator(this);
	}

	public void stop() {
		powerSupplier.turnOn();

	}

	public void start() {
		powerSupplier.turnOff();
	}

	public void press() {
		if (ac.isOn)
			ac.turnOff();
		else
			ac.turnOn();
	}

	public void setAc(AC ac) {
		this.ac = ac;
		this.ac.setMediator(this);
	}

	public void setPowerSupplier(PowerSupplier powerSupplier) {
		this.powerSupplier = powerSupplier;
	}

}

class PowerSupplier {
	void turnOn() {
		System.out.println("Power supply is ON");
	}

	void turnOff() {
		System.out.println("Power Supply is OFF");
	}
}