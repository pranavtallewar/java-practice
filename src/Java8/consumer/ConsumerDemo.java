package Java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1, 2, 3, 4);
		l.forEach(t -> System.out.println(t));

		List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

		Consumer<List<String>> upperCaseConsumer = list -> {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};
		Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

		upperCaseConsumer.andThen(printConsumer).accept(cities);
	}

}
