import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import interfaces.TestInterface;

class TestClass1 implements TestInterface {
	public static void main(String[] args) {
		System.out.println("Test");

		Set<String> set = new TreeSet<>();
		// set.add(null); //run time exception while adding null to TreeSet
		set.add("Test");
		set.forEach(System.out::println);

		Map<String, Integer> map = new HashMap<>();
		map.put("test", 1);
		map.putIfAbsent("test", 2); // will only add if value is not present for the given key
		
		System.out.println("Map printing");
		map.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("Set printing");

		int v1 = 5, v2 = 6;
		if ((v2 = 1) == v1)
			System.out.println(v2);
		else
			System.out.println(++v2);
	}

	@Override
	public void test() {
		System.out.println("Test method implemented");
	}
}