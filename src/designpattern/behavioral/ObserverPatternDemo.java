package designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		SachinCenturyNotifier notifier = new SachinCenturyNotifier();
		notifier.register(new SachinFan("A"));
		notifier.register(new SachinFan("B"));
		notifier.register(new SachinFan("C"));
		notifier.sachinScoredSanctury();
	}
}

class SachinCenturyNotifier {

	private List<SachinFan> fans = new ArrayList<>();

	void register(SachinFan fan) {
		fans.add(fan);
	}

	void sachinScoredSanctury() {
		System.out.println("Sachin scored sanctury...Woohooo!");
		fans.forEach(fan -> fan.announce());
	}
}

class SachinFan {
	private String name;

	public SachinFan(String name) {
		this.name = name;
	}

	void announce() {
		System.out.println(name + " notified");
	}
}