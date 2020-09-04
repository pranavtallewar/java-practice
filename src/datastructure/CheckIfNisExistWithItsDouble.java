package datastructure;

public class CheckIfNisExistWithItsDouble {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1, 7, 11 };
		boolean isExist = checkIfExist(nums);
		System.out.println("\nExist:" + isExist);

	}

	static boolean checkIfExist(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] * 2 == nums[j]) {
					return true;
				} else if (nums[j] * 2 == nums[i]) {
					return true;
				}

			}
		}
		return false;
	}

}
