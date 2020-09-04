package datastructure.sort;

import java.util.Arrays;

public class BubbleSortDemo {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 60, 35, 2, 45, 320, 5 };

		System.out.println("Array before sort:");
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
		bubbleSort(array);
		System.out.println("\n\nArray after sort:");
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
	}

	static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length - i; j++) {
				if (array[j-1] > array[j]) {
					int smallestNumber = array[j-1];
					array[j-1] = array[j];
					array[j] = smallestNumber;
				}

			}
		}
	}
}
