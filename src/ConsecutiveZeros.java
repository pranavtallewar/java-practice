
public class ConsecutiveZeros {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 0, 1, 1, 0, 0, 0 };
		System.out.println(maxZeros(nums));
	}

	static int maxZeros(int[] nums) {
		int count = 0;
		int max=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				count++;
			else
				count=0;
			
			max = Math.max( count, max );
		}
		return max;
	}
}
