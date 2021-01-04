import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ArrayManipulate {

	public static void main(String[] args) throws IOException {
		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs = br.readLine(); // Reading input from STDIN
		int array_size = Integer.parseInt(inputs.split(" ")[0]);
		int num_of_operations = Integer.parseInt(inputs.split(" ")[1]);

		Scanner s = new Scanner(System.in);
		String arrayInput = s.nextLine();
		
		int[] int_array = toIntArray(s.nextLine().split(" "));
	}

	static int[] toIntArray(String[] arr) {
	    int[] ints = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        ints[i] = Integer.parseInt(arr[i]);
	    }
	    return ints;
	}
	 static int maxTripletSum(int[] arr, int n){
	        int sum=0;
	        for(int i=1;i < n-1;++i){
	            int max1=0, max2=0;
	            for(int j=0; j< i; ++j){
	                if(arr[j] < arr[i]){
	                	sum = Math.max(sum, arr[i]+(max1 * arr[i]));
	                }
	            }
	        }
	        return sum;
	    }
}
