import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactorialDemo {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Factorial of " + n + " with recursion is:" + fact(n));
		System.out.println("Factorial of " + n + " Without Recursion:" + withoutRecursion(n));
		System.out.println("Factorial of " + n + " Java 8 way:" + factorial(n));
		IntStream.rangeClosed(1, 10).forEach(System.out::print);

		List<String> list = Arrays.asList("Miten", "Pooja", "Pranav", "Jay", "Chandrakant", "Shobhna");
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());

		System.out.println("\n" + sortedList);
	}

	private static int withoutRecursion(int n) {
		int res = 1;
		while (n >= 1) {
			res *= n;
			n--;
		}
		return res;
	}

	private static int fact(int n) {
		return (n >= 1) ? n * fact(n - 1) : 1;
	}

	private static Integer factorial(int n) {
		return IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
	}
}
