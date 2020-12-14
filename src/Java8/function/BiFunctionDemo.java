package Java8.function;

import java.util.function.BiFunction;

public class BiFunctionDemo {

	public static void main(String[] args) {

		// Bin Function example
		System.out.println("BiFunction Example output:" + incrementBy1AndMultiply.apply(2, 10));
		System.out.println("Addition of two number using BiFunction:" + Calculator.addTwoNumbers.apply(20, 20));
		System.out.println(
				"Multiplication of two number using BiFunction:" + Calculator.multiplyTwoNumbers.apply(20, 20));
	}

	static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiply = (n, muliplyWith) -> (n + 1) * muliplyWith;

	static int incrementByOneAndMultipy(int i, int n) {
		return (i + 1) * n;
	}

}

class Calculator {
	static BiFunction<Integer, Integer, Integer> addTwoNumbers = (n1, n2) -> n1 + n2;
	static BiFunction<Integer, Integer, Integer> multiplyTwoNumbers = (n1, n2) -> n1 * n2;
}
