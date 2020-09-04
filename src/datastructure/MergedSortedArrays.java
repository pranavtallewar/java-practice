package datastructure;

public class MergedSortedArrays {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		mergeSortedArrays(nums, 3, nums2, 3);
		for (int c = 0; c < nums.length; c++) {
			System.out.print(nums[c] + " ");
		}

	}

	static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (k >= 0) {
			if (j < 0 || (i >= 0 && nums1[i] > nums2[j]))
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
	}
}
