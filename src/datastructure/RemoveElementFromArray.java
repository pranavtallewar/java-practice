package datastructure;

public class RemoveElementFromArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 2, 3 };
		System.out.println(removeElement(nums, 2));
		for (int c = 0; c < nums.length; c++) {
			System.out.print(nums[c] + " ");
		}
		int[] nums1 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(
				"\nNumber of Elements in Array after removing duplicates:" + removeDuplicatesFromSortedArrays(nums1));
		for (int c = 0; c < nums1.length; c++) {
			System.out.print(nums1[c] + " ");
		}
	}

	static int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}

	static int removeDuplicatesFromSortedArrays(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int last = 1;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] != nums[i-1]) {
				nums[last] = nums[i];
				last++;
			}
		}
		int j = nums.length - last;
		for(int i = j; i < nums.length; i++) {
			nums[i] = 0;
		}

		return last;
	}
}
