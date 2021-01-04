package strings;

public class CommonInTwoStrings {

	public static void main(String[] args) {
		String s1 = "Hi";
		String s2 = "World";
		System.out.println(twoStrings(s1, s2));
	}

	static String twoStrings(String s1, String s2) {
		String result = "NO";
		for (int i = 0; i < s1.length() - 1; i++) {
			if (s2.indexOf(s1.charAt(i)) != -1) {
				result = "YES";
			}
		}
		return result;
	}
}
