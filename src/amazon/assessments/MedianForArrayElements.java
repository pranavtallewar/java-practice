package amazon.assessments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianForArrayElements {

	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // keeps track of
																										// the SMALL
																										// numbers
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // keeps track of the LARGE numbers

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		//double[] medians = runningMedian(array);
		double[] medians = medianTracker(array);
		for (int i = 0; i < medians.length; i++) {
			System.out.println(medians[i]);
		}
	}
	public static double[] medianTracker(int [] array) {
		double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
            medians[i]=getMedian();
        }
        return medians;
    }

	 private static void addNumber(int n) {
	        if (maxHeap.isEmpty()) {
	            maxHeap.add(n);
	        } else if (maxHeap.size() == minHeap.size()) {
	            if (n < minHeap.peek()) {
	                maxHeap.add(n);
	            } else {
	                minHeap.add(n);
	                maxHeap.add(minHeap.remove());
	            }
	        } else if (maxHeap.size() > minHeap.size()) {
	            if (n > maxHeap.peek()) {
	                minHeap.add(n);
	            } else {
	                maxHeap.add(n);
	                minHeap.add(maxHeap.remove());
	            }
	        }
	        // maxHeap will never have fewer elements than minHeap
	    }
	    
	    private static double getMedian() {
	        if (maxHeap.isEmpty()) {
	            return 0;
	        } else if (maxHeap.size() == minHeap.size()) {
	            return (maxHeap.peek() + minHeap.peek()) / 2.0;
	        } else { // maxHeap must have more elements than minHeap
	            return maxHeap.peek();
	        }
	    }
	
	static double[] runningMedian(int[] array) {
		double[] medians = new double[array.length];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);

			double median = 0.0;
			Collections.sort(list);
			if (i == 0)
				median = array[i];
			else if (list.size() % 2 != 0) {
				median = (double) list.get(list.size() / 2);
			} else {
				median = (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
			}
			medians[i] = median;
		}

		return medians;

	}
}
