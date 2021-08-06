package Java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static void main(String[] args) {

		/*
		 * int limit = 100; long start = System.currentTimeMillis(); IntStream.range(1,
		 * limit).forEach(System.out::print); long end = System.currentTimeMillis();
		 * System.out.println("\nSequential time=" + (end - start)); start =
		 * System.currentTimeMillis(); IntStream.range(1,
		 * limit).parallel().forEachOrdered(System.out::print); end =
		 * System.currentTimeMillis(); System.out.println("\nParallel time=" + (end -
		 * start));
		 */

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread->" + Thread.currentThread().getName() + " " + x);
		});

		IntStream.range(1, 10).parallel().forEachOrdered(x -> {
			System.out.println("Parallel Thread->" + Thread.currentThread().getName() + " " + x);
		});
		System.out
				.println("Array:\n" + Arrays.asList(3, 4, 10, 9, 5, 6).stream().sorted().collect(Collectors.toList()));
		System.out.println("Reverse Array:\n" + Arrays.asList(3, 4, 10, 9, 5, 6).stream()
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

	}

}
