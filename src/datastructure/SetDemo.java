package datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> fruitsStore = new HashSet<>();
		for (String fruit : Arrays.asList("mango", "apple", "banana", "kiwi")) {
			fruitsStore.add(fruit);
		}
		// no ordering in HashSet – elements stored in random order
		System.out.println("Ordering in HashSet :" + fruitsStore);
		Iterator<String> itr = fruitsStore.iterator();
		while (itr.hasNext()) {
			if (itr.next().equals("apple"))
				fruitsStore.remove("banana");
		}
		System.out.println("Ordering in HashSet :" + fruitsStore);
	}

}
