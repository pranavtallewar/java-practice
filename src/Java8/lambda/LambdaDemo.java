package Java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * A lambda expression is an anonymous function. A function that doesn’t have a
 * name and doesn’t belong to any class
 */
public class LambdaDemo {

	public static void main(String[] args) {
		// input parameters on the left side of the lambda operator
		// ->, and place block of statements on the right side of
		// lambda operator
		MyFunctionalInterface incrementedNum = (n, m) -> n + m;
		System.out.println(incrementedNum.incrementNumber(10, 5));

		StringConcat s = (str1, str2) -> str1 + str2;
		System.out.println("Result: " + s.sconcat("Hello ", "World"));

		List<String> list = new ArrayList<String>();
		list.add("Rick");
		list.add("Negan");
		list.add("Daryl");
		list.add("Glenn");
		list.add("Carl");
		System.out.println("\nIterate Maps and other collection classes using lambda expression:");
		list.forEach(
				// lambda expression
				(names) -> System.out.println(names));
	}

}

interface MyFunctionalInterface {
	public Integer incrementNumber(int n, int m);
	
}

interface StringConcat {

	public String sconcat(String a, String b);
}
