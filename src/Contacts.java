import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Contacts {

	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * Complete the contacts function below.
	 */
	static int findContacts(Set<String> addSet, String input) {
		int count = 0;
		for (String addStr : addSet) {
			if (addStr.startsWith(input)) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) throws IOException {

		int operations = Integer.parseInt(scanner.nextLine().trim());
		int i = 0;
		Tree tree = new Tree();
		while (i < operations) {
			String str = scanner.nextLine();

			String operation = str.split(" ")[0];
			String data = str.split(" ")[1];
			if (operation.equals("add")) {
				tree.add(data);
			}

			if (operation.equals("find")) {
				System.out.println(tree.find(data));
			}
			i++;
		}
		scanner.close();
	}

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * int operations = Integer.parseInt(scanner.nextLine().trim()); int i = 0;
	 * Set<String> addList = new HashSet<>(); int[] findList; while (i < operations)
	 * { String str = scanner.nextLine();
	 * 
	 * String operation = str.split(" ")[0]; String data = str.split(" ")[1]; if
	 * (operation.equals("add")) { addList.add(data); } if
	 * (operation.equals("find")) { System.out.println(findContacts(addList, data));
	 * } i++; } scanner.close(); }
	 */

}

class Tree {

	TreeNode root = new TreeNode();

	public void add(String input) {
		TreeNode current = root;
		for (char ch : input.toCharArray()) {
			current.putChildIfAbsent(ch);
			current = current.getChild(ch);
			current.size++;
		}
	}

	public int find(String prefix) {
		TreeNode current = root;
		for (char ch : prefix.toCharArray()) {
			current = current.getChild(ch);
			if (current == null)
				return 0;
		}
		return current.size;
	}

}

class TreeNode {
	Map<Character, TreeNode> children = new LinkedHashMap<>();
	int size = 0;

	public void putChildIfAbsent(char ch) {
		children.putIfAbsent(ch, new TreeNode());
	}

	public TreeNode getChild(char ch) {
		return children.get(ch);
	}
}
