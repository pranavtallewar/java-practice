import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Palindromes {

	public static void main(String[] args) {
		String input = "madamciviclevel";

		System.out.println(threePalindromicSubstrings(input));
		System.out.println("\n" + minPartitions(Arrays.asList(1, 2, 3), Arrays.asList(3, 3, 3)));
	}

	// print all unique palindromic substrings

	public static List<String> threePalindromicSubstrings(String word) {
		int wordLength = word.length();
		List<String> resultList = new ArrayList<>();
		int dp[] = new int[wordLength];

		boolean isPalindrome[][] = new boolean[wordLength][wordLength];

		for (int i = 0; i < wordLength; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (word.charAt(j) == word.charAt(i) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
					isPalindrome[j][i] = true;
					min = Math.min(min, j == 0 ? 0 : dp[j - 1] + 1);
				}

			}
			dp[i] = min;

		}
		List<Integer> last = new ArrayList<>();
		for (int i = 0; i < wordLength; i++) {
			if (isPalindrome[i][wordLength - 1] == true)
				last.add(i);
		}

		for (int l : last) {
			for (int i = 0; i < l; i++) {
				if (isPalindrome[0][i] && isPalindrome[i + 1][l - 1]) {
					resultList.add(word.substring(0, i + 1));
					resultList.add(word.substring(i + 1, l));
					resultList.add(word.substring(l));
					return resultList;
				}
			}
		}

		resultList.add("Impossible");
		return resultList;

	}


	public static int minPartitions(List<Integer> used, List<Integer> totalCapacity) {

		int minPartition = 0;

		List<Integer> sortedTotal = totalCapacity.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		int totalNumber = 0;
		for (int i : used) {
			totalNumber += i;
		}

		int counterTotal = 0;
		int currTotal;
		while (totalNumber > 0) {
			currTotal = sortedTotal.get(counterTotal);
			totalNumber = totalNumber - currTotal;

			if (totalNumber > 0) { // e.q +5 when 10-5 , used = 10, total = 5
				minPartition++;
				counterTotal++;
				continue;
			}

			minPartition++;
		}
		return minPartition;
	}
}
