package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Apple apple1 = new Apple("green", "S");
		Apple apple2 = new Apple("red", "M");
		System.out.println(apple2.hashCode());
		Map<Apple, Integer> map = new HashMap<>();
		map.put(apple1, 10);
		map.put(apple2, 20);
		Apple apple3 = new Apple("red", "M");
		System.out.println(apple3.hashCode());
		System.out.println(map.get(apple3));

		// create map to store
		Map<String, List<String>> testMap = new HashMap<String, List<String>>();
		// create list one and store values
		List<String> valSetOne = new ArrayList<String>();
		valSetOne.add("Apple");
		valSetOne.add("Aeroplane");
		// create list two and store values
		List<String> valSetTwo = new ArrayList<String>();
		valSetTwo.add("Bat");
		valSetTwo.add("Banana");
		// create list three and store values
		List<String> valSetThree = new ArrayList<String>();
		valSetThree.add("Cat");
		valSetThree.add("Car");
		// put values into map
		testMap.put("A", valSetOne);
		testMap.put("B", valSetTwo);
		testMap.put("C", valSetThree);
		// iterate and display values
		System.out.println("Fetching Keys and corresponding [Multiple] Values n");
		for (Map.Entry<String, List<String>> entry : testMap.entrySet()) {
			String key = entry.getKey();
			List<String> values = entry.getValue();
			System.out.println("Key = " + key);
			System.out.println("Values = " + values + "n");
		}

		Map<Apple, Apple> appleMap = new HashMap<>();
		appleMap.put(apple1, apple1);
		appleMap.forEach((k, v) -> System.out.println(k + " -> " + v));
		
	}

}

final class Apple {
	private final String color;
	private final String size;

	public Apple(String color, String size) {
		this.color = color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public String getSize() {
		return size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", size=" + size + "]";
	}

}
