package datastructure;

public class EvenDigitNumFromArray {

	public static void main(String[] args) {
		int[] nums = new int[] {12,345,2,6,7896};
		System.out.println(findEvenDigitNumSum(nums));
	}
	static int findEvenDigitNumSum(int[] nums) {
		int max=0;
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			String s = Integer.toString(n);
			if(s.length() % 2 ==0) {
				max++;
			}
		}
		return max;
	}
}
