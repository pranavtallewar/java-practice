package datastructure;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumInArray {

	public static void main(String[] args) {
		int[] nums3 = new int[] { 3, 2, 7, 2, 3, 1,4 };
		List<Integer> list = findDisappearedNumbers(nums3);
		System.out.println(list);
	}

	/**
	 * 
	 */
	static List<Integer> findDisappearedNumbers(int[] nums) {
		int i = 0, x, t, l = nums.length;
		List<Integer> missing = new ArrayList<>();
		while (i < l) {
			x = nums[i];
			if (x != (i + 1)) {
				if (nums[x - 1] != x) {
					// swap(nums,i,x-1);
					t = nums[i];
					nums[i] = nums[x - 1];
					nums[x - 1] = t;
				} else
					i++;
			} else
				i++;
		}
		for (i = 0; i < l; i++) {
			if (nums[i] != i + 1)
				missing.add(i + 1);
		}
		return missing;
	}
}
