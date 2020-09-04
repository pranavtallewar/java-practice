package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
		int[] res_arr = duplicateZeros(nums);
		for (int i = 0; i < res_arr.length; i++) {
			System.out.print(res_arr[i] + " ");
		}
	}

	static int[] duplicateZeros(int[] nums) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
		}
		int temp;
		for (int i = 0; i < nums.length; i++) {
			temp = queue.poll();
			if (temp == 0) {
				nums[i] = temp;
				if (i + 1 < nums.length) {
					nums[i + 1] = temp;
					i++;
				}
			} else {
				nums[i] = temp;
			}
		}
		return nums;
	}

}
