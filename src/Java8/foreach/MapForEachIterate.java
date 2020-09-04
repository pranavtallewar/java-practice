package Java8.foreach;

import java.util.HashMap;
import java.util.Map;

public class MapForEachIterate {

	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<>();
		hmap.put(1, "Monkey");
		hmap.put(2, "Dog");
		hmap.put(3, "Cat");
		hmap.put(4, "Lion");
		hmap.put(5, "Tiger");
		hmap.put(6, "Bear");
		/*
		 * forEach to iterate and display each key and value pair of HashMap.
		 */
		System.out.println("===== forEach to iterate and display each key and value pair of HashMap =====");
		hmap.forEach((key, value) -> System.out.println(key + "-" + value));

		/*
		 * forEach to iterate a Map and display the value of a particular key
		 */
		System.out.println("===== forEach to iterate a Map and display the value of a particular key =====");
		hmap.forEach((key, value) -> {
			if (key == 4)
				System.out.println("Value associated with 4 is:" + value);
		});
		System.out.println();
		/*
		 * forEach to iterate a Map and display the key associated with a particular
		 * value
		 */
		System.out.println("===== forEach to iterate a Map and display the key associated with a particular =====");
		hmap.forEach((key, value) -> {
			if ("Cat".equalsIgnoreCase(value)) {
				System.out.println("Key associated with Cat is:" + key);
			}
		});
	}

}
