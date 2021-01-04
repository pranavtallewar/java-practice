package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("<h1>Nayeem loves counseling</h1>");
		list.add("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");
		list.add("<Amee>safat codes like a ninja</amee>");
		list.add("<SA premium>Imtiaz has a secret crush</SA premium>");

		for (String line : list) {
			Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
			Matcher m = r.matcher(line);
			int count = 0;
			while (m.find()) {
				if (m.group(2).length() != 0) {
					System.out.println(m.group(2));
					count++;
				}
			}
			if (count == 0)
				System.out.println("None");
		}

		String A = "madam";
		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(A);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		if (A.equals(input1.toString()))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
