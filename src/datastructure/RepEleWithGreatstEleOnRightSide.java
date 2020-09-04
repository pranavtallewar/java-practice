package datastructure;

public class RepEleWithGreatstEleOnRightSide {

	public static void main(String[] args) {
		int[] nums = new int[] { 17, 18, 5, 4, 6, 1 };
		int[] res_arr = replaceElements(nums);
		for (int i = 0; i < res_arr.length; i++) {
			System.out.print(res_arr[i] + " ");
		}
	}

	/**
	 *  17, 18, 5, 4, 6, 1
	 *	17, 18, 5, 4, 1, 1
	 *	17, 18, 5, 6, 1, 1
	 *	17, 18, 6, 6, 1, 1
	 *	18,  6, 6, 6, 1, 1
	 *	18,  6, 6, 6, 1,-1
	 */
	
	static int[] replaceElements(int[] arr) {
		int max = arr[arr.length - 1];
		int currentMax = -1;
		int i = arr.length - 2;
		while (i >= 0) {
			currentMax = max;
			max = Math.max(max, arr[i]);
			arr[i] = currentMax;
			i--;
		}
		arr[arr.length - 1] = -1;

		return arr;
	}

}
