package Java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 6, 7, 10, 8);
		int sum = 0;
		long start = System.currentTimeMillis();
		for (int n : numbers)
			sum += n;
		long end = System.currentTimeMillis();
		System.out.println("Calculated Sum :" + sum + " in: " + String.valueOf(end - start));
		start = System.currentTimeMillis();
		int sum1 = numbers.stream().mapToInt(i -> i).sum();
		end = System.currentTimeMillis();
		System.out.println("Calculated Sum :" + sum1 + " in: " + String.valueOf(end - start));

		start = System.currentTimeMillis();
		int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
		end = System.currentTimeMillis();
		System.out.println("Calculated Sum :" + sum2 + " in: " + String.valueOf(end - start));
		start = System.currentTimeMillis();
		Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
		end = System.currentTimeMillis();
		System.out.println("Calculated Sum :" + sum3.get() + " in: " + String.valueOf(end - start));

		Integer maxNoFromArray = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(maxNoFromArray);

		List<String> words = Arrays.asList("pranav", "java", "tallewar");
		String longestWord = words.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();
		System.out.println("Longest word from Array:	" + longestWord);
	}

}
