package strings;

import java.util.ArrayList;
import java.util.List;

public class IPRegExMatcher {

	public static void main(String[] args) {

		/*
		 * Scanner in = new Scanner(System.in); while (in.hasNext()) { String IP =
		 * in.next(); System.out.println(IP.matches(new MyRegex().pattern)); }
		 */

		List<String> list = new ArrayList<>();
		list.add("000.12.12.034");
		list.add("121.234.12.12");
		list.add("23.45.12.56");
		list.add("00.12.123.123123.123");
		list.add("122.23");
		list.add("Hello.IP");
		String patternStr = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		list.forEach(l -> {
			System.out.println(l.matches(patternStr));
		});
	}
}

class MyRegex {
	String pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}