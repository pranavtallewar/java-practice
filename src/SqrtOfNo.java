
public class SqrtOfNo {

	public static void main(String[] args) {
		System.out.println("The square root of 144 is: " + squareRoot(144));
		System.out.println("The square root of 144 is: " + floorSqrt(625));
	}

	public static double squareRoot(int num) {
		// temporary variable
		double t;

		// divide given no by 2
		double sqrtroot = num / 2;
		do {
			// assign it to var
			t = sqrtroot;
			//
			sqrtroot = (t + (num / t)) / 2;
		} while ((t - sqrtroot) != 0);
		return sqrtroot;
	}

	// Time complexity  O(log(n))
	// Space Complexity O(1)
	public static int floorSqrt(int x) {
		// Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		long start = 1, end = x, ans = 0;
		while (start <= end) {
			int mid = (int) ((start + end) / 2);

			// If x is a perfect square
			if (mid * mid == x)
				return (int) mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
			} else // If mid*mid is greater than x
				end = mid - 1;
		}
		return (int) ans;
	}

}
