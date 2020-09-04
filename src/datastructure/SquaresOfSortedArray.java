package datastructure;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] { -4, -1, 0, 3, 10 };
		int[] sorted = squaresOfSortedArray(nums);
		System.out.println("\nAfter sorting:");
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}

	}

	static int[] squaresOfSortedArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		int temp = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		return nums;
	}
}
