package recursion;

public class MaxElementFromArray {

	public static void main(String[] args) {
		int[] array = { 11, 21, 0, 45, 10, 25 };
		String[] str = "N|WDesk".split("\\|");
		System.out.println(getMaxFromArray(array, array.length));
	}

	static int getMaxFromArray(int[] array, int size) {
		if (size == 1)
			return array[0];

		int maxValue = getMaxFromArray(array, size - 1);

		return Integer.max(array[size - 1], maxValue);
	}
}
