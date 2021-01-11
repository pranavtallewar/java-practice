package recursion;

public class PrintReverseArrayUsingRecursion {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4 };

		System.out.println("Print array in revers order:");
		printReverseArray(array, array.length);

		System.out.println("\nPrint array in actual order:");
		printArray(array, 0);
	}

	static void printReverseArray(int[] arr, int startIndex) {

		if (startIndex == 0)
			return;

		System.out.print(" " + arr[--startIndex]);

		printReverseArray(arr, startIndex);
	}

	static void printArray(int[] arr, int startIndex) {
		if (startIndex == arr.length)
			return;

		System.out.print(" " + arr[startIndex]);
		printArray(arr, ++startIndex);
	}

}
