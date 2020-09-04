package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter size of the array");
		int l = Integer.parseInt(br.readLine());
		int[] a = new int[l];
		// insert elements in the array logic
		System.out.println("enter a elements\n");
		for (int i = 0; i < l; i++) {
			
			int el = Integer.parseInt(br.readLine());
			a[i] = el;
		}
		// sorting elements in the array logic
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		// remove duplicate elements logic
		int b = 0;
		a[b] = a[0];
		for (int i = 1; i < l; i++) {
			if (a[b] != a[i]) {
				b++;
				a[b] = a[i];

			}

		}
		for (int i = 0; i <= b; i++) {
			System.out.println(a[i]);
		}
	}

}
