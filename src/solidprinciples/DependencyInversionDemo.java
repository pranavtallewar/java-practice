package solidprinciples;

public class DependencyInversionDemo {

	public static void main(String[] args) {

		Machine machine = new Machine("Windows 7", new LEDMonitor("Samsung LED"), new WirelessKeyboard("TVS Wireless Keyboard"));
		System.out.println(machine);
	}

}

class Machine {

	final String name;
	final Monitor monitor;
	final Keyboard keyboard;

	public Machine(String name, Monitor monitor, Keyboard keyboard) {
		this.name = name;
		this.monitor = monitor;
		this.keyboard = keyboard;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	@Override
	public String toString() {
		return "Machine [name=" + name + ", monitor=" + monitor + ", keyboard=" + keyboard + "]";
	}

}

abstract class Monitor {
	String name;

	Monitor(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

class CRTMonitor extends Monitor {

	CRTMonitor(String name) {
		super(name);
	}

}

class LEDMonitor extends Monitor {

	LEDMonitor(String name) {
		super(name);
	}

}

abstract class Keyboard {
	String name;

	public Keyboard(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class WiredKeyboard extends Keyboard {

	public WiredKeyboard(String name) {
		super(name);
	}

}

class WirelessKeyboard extends Keyboard {

	public WirelessKeyboard(String name) {
		super(name);
	}

}
