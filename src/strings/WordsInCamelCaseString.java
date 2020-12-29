package strings;

/**
 * number of words in the sequence will be one more than the number of upper case letters
 *
 */
public class WordsInCamelCaseString {

	public static void main(String[] args) {
		String s = "geeksForGeeks";
		System.out.println("Words in " + s + " is:" + camelcase(s));
	}

	static int camelcase(String s) {
		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				count++;
			}
		}

		return count;
	}
	
}
