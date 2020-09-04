package datastructure;

public class ValidMountainArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 3, 4, 2, 1 };
		boolean isExist = validMountainArray(nums);
		System.out.println(isExist);
	}

	static boolean validMountainArray(int[] A) {
		int n = A.length;
		int i = 0;
		// walk up from left to right until we can't: that has to be the peak
		while (i + 1 < n && A[i] < A[i + 1])
			i++;
		// the peak is not the first or last element.
		// If we reach the end, the array is valid, otherwise its not.
		if (i == 0 || i == n - 1)
			return false;
		// we walk down. If we reach the end, the array is valid, otherwise its not.
		while (i + 1 < n && A[i] > A[i + 1])
			i++;

		return i == n - 1;
	}

}
