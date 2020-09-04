package datastructure;

public class MoveZerosAtEnd {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 0, 4, 0, 12 };
		moveZerosAtEnd(nums);
		for (int c = 0; c < nums.length; c++) {
			System.out.print(nums[c] + " ");
		}

	}

	/**
	 * O/P: 0 0 0 0 1 4 12
	 */
	static void moveZerosAtStart(int[] nums) {
		int temp = 0;
		for (int i = nums.length - 1, j = nums.length - 1; i > 0; i--) {
			if (nums[i] != 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j--] = temp;
			}
		}
	}

	/**
	 * O/P: 1 3 4 12 0 0 0 0
	 */
	static void moveZerosAtEnd(int[] nums) {
		int temp = 0;
		for (int i = 0, j = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}
		}
	}
}
