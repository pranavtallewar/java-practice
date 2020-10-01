package Java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
		Predicate<String> nameStartsWithS = str -> str.startsWith("S");
		names.stream().filter(nameStartsWithS).forEach(System.out::println);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream().filter(n -> n % 2 == 0).forEach(System.out::println);	
	}

}
