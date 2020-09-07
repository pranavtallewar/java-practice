package strings;

public class StringReverseDemo {

	public static void main(String[] args) {
		// original string
		String str = "Sony is going to introduce Internet TV soon";
		System.out.println("Original String: " + str);
		// reversed string using Stringbuffer
		long start = System.currentTimeMillis();
		String reverseStr = new StringBuffer(str).reverse().toString();
		long end = System.currentTimeMillis();
		System.out.println("\nReverse String in Java using StringBuffer: " + reverseStr);
		System.out.println("Completed in " + (end - start) + " ms.");

	}

	public String reverse(String input) {
		StringBuilder reversed = new StringBuilder();
		char[] inputArray = input.toCharArray();
		for (int i = inputArray.length - 1; i >= 0; i--) {
			reversed.append(inputArray[i]);
		}
		return reversed.toString();
	}

	public String reverseRecursively(String input) {
		if (input.length() < 2) {
			return input;
		}
		return reverseRecursively(input.substring(1)) + input.charAt(0);
	}
}
