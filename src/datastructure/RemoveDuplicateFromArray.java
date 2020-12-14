package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter size of the array");
		int l = Integer.parseInt(br.readLine());
		int[] array = new int[l];
		// insert elements in the array logic
		System.out.println("enter a elements\n");
		for (int i = 0; i < l; i++) {

			int el = Integer.parseInt(br.readLine());
			array[i] = el;
		}
		// sorting elements in the array logic

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		// remove duplicate elements logic
		int b = 0;
		array[b] = array[0];
		for (int i = 1; i < l; i++) {
			if (array[b] != array[i]) {
				b++;
				array[b] = array[i];
			}

		}

		for (int i = 0; i <= b; i++) {
			System.out.println(array[i]);
		}
	}

}
