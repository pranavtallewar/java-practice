import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // Reading input from STDIN
		String[] input_arr = input.split(" ");
		int number_of_rows = Integer.parseInt(input_arr[1]);
		int row_capacity = Integer.parseInt(input_arr[2]);

		int[] number_of_rows_counter = new int[number_of_rows + 1];
		for (int i = 1; i <= number_of_rows; i++) {
			number_of_rows_counter[i] = row_capacity;
		}

		String arrStr = br.readLine();
		int[] ints = toIntArray(arrStr.split(" "));
		int result = 0;
		for (int i = 0; i < ints.length; i++) {
			int row_val = ints[i];
			if (number_of_rows_counter[row_val] == 0) {
				result++;
			} else {
				number_of_rows_counter[row_val] -= 1;
			}
		}
		System.out.println(result);
	}

	private static int[] toIntArray(String[] arr) {
		int[] ints = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			ints[i] = Integer.parseInt(arr[i]);
		}
		return ints;
	}
}
