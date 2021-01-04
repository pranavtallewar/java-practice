package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class PatternCompiler {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("([A-Z])(.+)");
		list.add("[AZ[a-z](a-z)");
		list.add("batcatpat(nat");
		String A = "java";
		String B = "hello";
		int size = A.length() + B.length();
		System.out.println(size);
		if (A.compareTo(B) > 0)
			System.out.println("Yes");
		else
			System.out.println("No");

		A = A.substring(0, 1).toUpperCase().concat(A.substring(1));
		B = B.substring(0, 1).toUpperCase().concat(B.substring(1));
		System.out.println(A + " " + B);
		System.out.println();
		list.forEach(p -> {
			try {
				Pattern.compile(p);
				System.out.println("Valid");
			} catch (PatternSyntaxException e) {
				System.out.println("Invalid");
			}

		});
	}
}
