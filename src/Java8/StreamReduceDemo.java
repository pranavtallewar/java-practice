package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamReduceDemo {

	public static void main(String[] args) {
		// creating a list of Strings
		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

		// Reverse Sorting
		List<String> reverserSortedWords = words.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		System.out.println(reverserSortedWords);
		
		Optional<String> longestString = words.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2);
		longestString.ifPresent(System.out::print);

		System.out.println();

		List<Integer> intList = Arrays.asList(-2, 1, 5, 6, 7, 9);

		// sum of array elements
		Optional<Integer> sum = intList.stream().reduce((n1, n2) -> n1 + n2);
		int summ = intList.stream().reduce(0, (n1, n2) -> n1 + n2);

		System.out.println("Sum of array integer is:" + summ);
		sum.ifPresent(System.out::print);
		

	}

}
