import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comb {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 2, 3, 1 };
		// List<Integer> superSet =
		// Arrays.stream(arr).boxed().collect(Collectors.toList());
		int n = arr.length;
		int k = 3;
		printCombination(arr, n, k);

	}

	static void printCombination(int[] arr, int n, int k) {
		int[] data = new int[k];

		List<Integer> list = new ArrayList<>();
		combinationUtil(arr, data, 0, n - 1, 0, k, list);

		int sum = list.stream().reduce(0, (n1, n2) -> n1 + n2);

		System.out.println("Sum is:" + sum);
	}

	static void combinationUtil(int[] arr, int[] data, int start, int end, int index, int r, List<Integer> list) {

		if (index == r) {
			for (int j = 0; j < r; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println();

			list.add(Arrays.stream(data).max().getAsInt());
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r, list);
		}
	}

}
