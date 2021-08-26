
public class UserMainCode {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };
		int sum_counter = 0, sum_values = 0;
		for (int i = 0; i < nums.length; i++) {
			sum_counter += i;
			sum_values += nums[i];
		}
		System.out.println(sum_values - sum_counter);
	}

}
