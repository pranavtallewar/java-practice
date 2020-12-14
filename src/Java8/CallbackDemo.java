package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CallbackDemo {

	public static void main(String[] args) {
		// hello("Pranav", null, (n) -> System.out.println("Last Name not provided for "
		// + n));
		// hello2("Miten", null, () -> System.out.println("Last name not present"));

		maxMin(Arrays.asList("push", "push", "push", "pop"), Arrays.asList(1, 2, 3, 1));
	}

	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (null != lastName) {
			System.out.println(lastName);
		} else {
			callback.accept(firstName);
		}
	}

	static void hello2(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if (null != lastName) {
			System.out.println(lastName);
		} else {
			callback.run();
		}
	}

	public static List<Long> maxMin(List<String> operations, List<Integer> x) {

		List<Long> returnedList = new ArrayList<>();
		List<Long> list = new ArrayList<>();
		int i =0;
		for(String operation : operations) {
			if("push".equalsIgnoreCase(operation)) {
				list.add((long)x.get(i));
				i++;
			} else if("pop".equalsIgnoreCase(operation)) {
				list.remove(0);
			}
			Long max = list.stream().max(Comparator.comparing(Long::valueOf)).get();
			Long min = list.stream().min(Comparator.comparing(Long::valueOf)).get();
			returnedList.add((long) (max * min));
		}
		System.out.println(returnedList);
		return returnedList;
	}
}
