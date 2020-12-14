package designpattern.creational;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrototypeDesignPatternDemo {

	public static void main(String[] args) {
		if (args.length > 0) {
			initializePrototypes();
			List<Prototype> prototypes = new ArrayList<>();
			// 6. Client does not use "new"
			for (String protoName : args) {
				Prototype prototype = PrototypeModule.createPrototype(protoName);
				if (prototype != null) {
					prototypes.add(prototype);
				}
			}
			for (Prototype p : prototypes) {
				p.execute();
			}
		} else {
			System.out.println("Run again with arguments of command string ");
		}
	}

	public static void initializePrototypes() {
		PrototypeModule.addPrototype(new PrototypeAlpha());
		PrototypeModule.addPrototype(new PrototypeBeta());
		PrototypeModule.addPrototype(new ReleasePrototype());
	}

}

interface Prototype {
	Prototype clone();

	String getName();

	void execute();
}

class PrototypeModule {
	private static List<Prototype> prototypes = new ArrayList<>();

	public static void addPrototype(Prototype prototype) {
		prototypes.add(prototype);
	}

	public static Prototype createPrototype(String name) {
		Optional<Prototype> prototype = prototypes.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
		if (prototype.isPresent())
			return prototype.get().clone();
		else
			System.out.println(name + ": doesn't exist");

		return null;
	}
}

class PrototypeAlpha implements Prototype {

	private String name = "Alpha";

	@Override
	public Prototype clone() {
		// TODO Auto-generated method stub
		return new PrototypeAlpha();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void execute() {
		System.out.println(name + " does some work");

	}
}

class PrototypeBeta implements Prototype {
	private String name = "BetaVersion";

	@Override
	public Prototype clone() {
		return new PrototypeBeta();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		System.out.println(name + ": does something");
	}
}

class ReleasePrototype implements Prototype {
	private String name = "ReleaseCandidate";

	@Override
	public Prototype clone() {
		return new ReleasePrototype();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		System.out.println(name + ": does real work");
	}
}
