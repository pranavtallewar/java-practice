package designpattern.behavioral;

public class StatePatternDemo {

	public static void main(String[] args) {
		FanWallControl fanControl = new FanWallControl();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
	}

}

class FanWallControl {
	private SpeedLevel current;

	public FanWallControl() {
		current = new Off();
	}

	public void set_state(SpeedLevel state) {
		this.current = state;
	}

	public void rotate() {
		current.rotate(this);
	}

	@Override
	public String toString() {
		return "FanWallControl [current=" + current + "]";
	}

}

interface SpeedLevel {
	public void rotate(FanWallControl control);
}

class Off implements SpeedLevel {

	private static final String name = "OFF";

	@Override
	public void rotate(FanWallControl control) {
		control.set_state(new SpeedLevel1());
	}

	@Override
	public String toString() {
		return name;
	}
}

class SpeedLevel1 implements SpeedLevel {

	private static final String name = "Level1";

	@Override
	public void rotate(FanWallControl control) {
		control.set_state(new SpeedLevel2());
	}

	@Override
	public String toString() {
		return name;
	}
}

class SpeedLevel2 implements SpeedLevel {
	private static final String name = "Level2";

	@Override
	public void rotate(FanWallControl control) {
		control.set_state(new SpeedLevel3());
	}

	@Override
	public String toString() {
		return name;
	}

}

class SpeedLevel3 implements SpeedLevel {

	private static final String name = "Level3";

	@Override
	public void rotate(FanWallControl control) {
		control.set_state(new Off());
	}

	@Override
	public String toString() {
		return name;
	}
}