package Java8.exceptionhandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HandleRuntimeException {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("10", "20", "IamnotNumber", null);
		System.out.println("EH -> Approach - 1");
		list.forEach(s -> printValues(s));

		System.out.println("\nEH -> Approach - 2");
		list.forEach(handleExceptionConsumer(s -> System.out.println(Integer.parseInt(s))));

		System.out.println("\nEH -> Approach - 3");
		list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));

		System.out.println("\nEH -> Devide by zero::");
		List<Integer> listInt = Arrays.asList(10, 0);
		listInt.forEach(handleGenericException(i -> System.out.println(10 / i), ArithmeticException.class));

		// List<Integer> list1 = list.stream().map(s ->
		// Integer.parseInt(s)).collect(Collectors.toList());

	}

	private static void printValues(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
		}
	}

	private static Consumer<String> handleExceptionConsumer(Consumer<String> payload) {
		return obj -> {
			try {
				payload.accept(obj);
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
			}
		};
	}

	private static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(
			Consumer<Target> targetConsumer, Class<ExObj> exObjClass) {
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch (Exception e) {
				try {
					ExObj exObj = exObjClass.cast(e);
					exObj.printStackTrace();
				} catch (ClassCastException ex) {
					throw ex;
				}
			}
		};
	}

}
