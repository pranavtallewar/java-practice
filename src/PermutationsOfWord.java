import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfWord {
	static Set<String> words = new HashSet<>();

	static String swap(String str, int i, int j) {
		char ch;
		char[] array = str.toCharArray();
		ch = array[i];
		array[i] = array[j];
		array[j] = ch;
		return String.valueOf(array);
	}

	// Function to print all the permutations of the string
	static void permute(String str, int low, int high) {
		if (low == high) {
			if (!(str.startsWith("A") || str.startsWith("a") || str.startsWith("E") || str.startsWith("e")
					|| str.startsWith("I") || str.startsWith("i") || str.startsWith("O") || str.startsWith("o")
					|| str.startsWith("U") || str.startsWith("u"))) {
				words.add(str);
			}
		}

		int i;
		for (i = low; i <= high; i++) {
			str = swap(str, low, i);
			permute(str, low + 1, high);
			str = swap(str, low, i);
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
		} catch (Exception e) {
			System.out.println("Error while reading line," + e.getMessage());
			return;
		}
		permute(str, 0, str.length() - 1);
		System.out.print(words.size());
	}

}
