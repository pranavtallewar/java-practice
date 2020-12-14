package Java8.function;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(incrementByOne(n));
		System.out.println(incrementByOneFunction.apply(2));

		// System.out.println(incrementByOneFunction.andThen(multiplyBy10Function).apply(4));
		Function<Integer, Integer> incrementBy1AndThenMultipleBy10Function = incrementByOneFunction
				.andThen(multiplyBy10Function);
		System.out.println(incrementBy1AndThenMultipleBy10Function.apply(4));
	}

	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
	static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	static int incrementByOne(int i) {
		return i + 1;
	}

}
