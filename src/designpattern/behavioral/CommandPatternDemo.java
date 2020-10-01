package designpattern.behavioral;

public class CommandPatternDemo {

	public static void main(String[] args) {

		Light light = new Light();
		
		HomeAutomationRemote remote = new HomeAutomationRemote();
		remote.setCommand(new LightTurnOnCommand(light));
		
		remote.press();

	}

}

@FunctionalInterface
interface Command {
	public void execute();
}

class HomeAutomationRemote {
	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}
	public void press() {
		command.execute();
	}
}

class Light {
	public void turnOn() {
		System.out.println("Light is on.");
	}

	public void turnOff() {
		System.out.println("Ligh is off.");
	}
}

class LightTurnOnCommand implements Command {
	Light light;

	public LightTurnOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		System.out.println("Turning on light");
		light.turnOn();
	}

}

class LightTurnOffCommand implements Command {
	Light light;

	public LightTurnOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		System.out.println("Turning off light");
		light.turnOff();
	}
}

class Fan {
	public void start() {
		System.out.println("Fan is started.");
	}

	public void stop() {
		System.out.println("Fan is stopped.");
	}
}

class StartFanCommand implements Command {

	Fan fan;

	public StartFanCommand(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		System.out.println("starting fan..");
		fan.start();
	}
}

class StopFanCommand implements Command {
	Fan fan;

	public StopFanCommand(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		System.out.println("stopping fan..");
		fan.stop();
	}
}