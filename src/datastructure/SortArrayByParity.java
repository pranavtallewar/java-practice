package datastructure;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 6, 5, 8, 2, 4 };

		moveEvensAtStart(nums);
		System.out.println("Moving Evens at start[3, 1, 6, 5, 8, 2, 4]:");
		for (int c = 0; c < nums.length; c++) {
			System.out.print(nums[c] + ", ");
		}

		System.out.println("\nMoving Evens at end[8, 2, 6, 4, 3, 1, 5]:");
		int[] nums1 = new int[] { 8, 2, 6, 4, 3, 1, 5 };
		moveEvensAtEnd(nums1);
		for (int c = 0; c < nums1.length; c++) {
			System.out.print(nums1[c] + ", ");
		}

		int[] nums2 = new int[] { 1, 2, 7, 4, 3, 6, 5 };
		System.out.println("\nMoving odds at end[1, 2, 7, 4, 3, 6, 5]:");
		moveOddsAtEnd(nums2);
		for (int c = 0; c < nums2.length; c++) {
			System.out.print(nums2[c] + ", ");
		}

		System.out.println("\nMoving odds at start[1, 2, 7, 4, 3, 6, 5]:");
		int[] nums3 = new int[] { 1, 2, 7, 4, 3, 6, 5 };
		moveOddsAtStart(nums3);
		for (int c = 0; c < nums3.length; c++) {
			System.out.print(nums3[c] + ", ");
		}

	}

	/**
	 * O/P:8 2 6 4 3 1 5
	 */
	static void moveEvensAtStart(int[] nums) {
		int temp = 0;
		for (int i = nums.length - 1, j = nums.length - 1; i >= 0; i--) {
			if (nums[i] % 2 != 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j--] = temp;
			}
		}
	}

	/**
	 * O/P:3 1 5 6 8 2 4
	 */
	static void moveEvensAtEnd(int[] nums) {
		int temp = 0;
		for (int i = 0, j = 0; i <= nums.length - 1; i++) {
			if (nums[i] % 2 != 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}
		}
	}

	/**
	 * O/P: 6 8 2 4 3 1 5
	 */
	static void moveOddsAtEnd(int[] nums) {
		int temp = 0;
		for (int i = 0, j = 0; i <= nums.length - 1; i++) {
			if (nums[i] % 2 == 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j++] = temp;
			}
		}
	}

	/**
	 * O/P: 6 8 2 4 3 1 5
	 */
	static void moveOddsAtStart(int[] nums) {
		int temp = 0;
		for (int i = nums.length - 1, j = nums.length - 1; i >= 0; i--) {
			if (nums[i] % 2 == 0) {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j--] = temp;
			}
		}
	}
}
