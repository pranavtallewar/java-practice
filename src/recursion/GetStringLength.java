package recursion;

/**
 * @author tallewar_p
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */
public class GetStringLength {

	public static void main(String[] args) {

		System.out.println(strLength("Pranav"));
	}

	static int strLength(String input) {

		if (input.equals(""))
			return 0;

		return 1 + strLength(input.substring(1));
	}
}
