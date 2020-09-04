package Java8.foreachOrdered;

import java.util.ArrayList;
import java.util.List;

public class ForEachOrderedDemo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Maggie");
		names.add("Michonne");
		names.add("Rick");
		names.add("Merle");
		names.add("Governor");

		// forEach - the output would be in any order
		// Performs the given action for each entry in this map until all entries have
		// been processed or the action throws an exception
		
		System.out.println("Print using forEach");
		names.stream().filter(f -> f.startsWith("M")).parallel().forEach(n -> System.out.println(n));

		/*
		 * forEachOrdered - the output would always be in this order: Maggie, Michonne,
		 * Merle
		 */
		System.out.println("Print using forEachOrdered");
		names.stream().filter(f -> f.startsWith("M")).parallel().forEachOrdered(n -> System.out.println(n));
	}

}
