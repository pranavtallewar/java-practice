package strings;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BalancedBracketsDemo {

	public static void main(String[] args) {
		String[] expressions = new String[] { "()", "[()]", "{[()]}", "abc[](){}", "{[)])}" };
		long start = System.currentTimeMillis();
		Arrays.stream(expressions).map(s -> isBalanced1(s)).forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		/*
		 * for (String s : expressions) { System.out.println(isBalanced1(s)); }
		 */
	}

	public static boolean isBalanced(String str) {
		if (null == str || ((str.length() % 2) != 0)) {
			return false;
		} else {
			char[] ch = str.toCharArray();
			for (char c : ch) {
				if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isBalanced1(String str) {
		// check balanced parenthesis,brackets, braces
		while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
			// replace if brackets found.
			str = str.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
		}
		return (str.length() == 0);
	}

	static boolean isBalanced2(String str) {
		Deque<Character> deque = new LinkedList<>();
		for (char ch : str.toCharArray()) {
			// check if opening bracket
			if (ch == '{' || ch == '[' || ch == '(') {
				// add as first element in queue
				deque.addFirst(ch);
			} else {
				// check if list is not empty and check last in character with its respective
				// closing bracket
				if (!deque.isEmpty() && ((deque.peekFirst() == '{' && ch == '}')
						|| (deque.peekFirst() == '[' && ch == ']') || (deque.peekFirst() == '(' && ch == ')'))) {
					// remove top-most character from queue.
					deque.removeFirst();
				} else {
					return false;
				}
			}
		}
		// when all characters are balanced checks.
		return true;
	}

}
