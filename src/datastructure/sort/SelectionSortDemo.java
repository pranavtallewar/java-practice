package datastructure.sort;

import java.util.Arrays;

public class SelectionSortDemo {

	public static void main(String[] args) {
		int[] array = new int[] { 9, 14, 3, 2, 43, 11, 58, 22 };

		System.out.println("Array before sort:");
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
		selectionSort(array);
		System.out.println("\n\nArray after sort:");
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
	}

	static void selectionSort(int[] array) {
		int count=0;
		//System.out.println();
		for (int i = 0; i < array.length-1; i++) {
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				//System.out.println();
				if (array[j] < array[index]) {
					index = j;
				}
				int smallestNumber = array[index];
				array[index] = array[i];
				array[i] = smallestNumber;
				
				count++;
				//Arrays.stream(array).forEach(e -> System.out.print(e + " "));
			}
			//System.out.println("\n");
		}
		//System.out.println("\ncount="+count);
	}
}
