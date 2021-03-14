package amazon.assessments;

import java.util.ArrayList;
import java.util.List;

public class PerforamanceOptimization {

	public static void main(String[] args) {
		int n = 3, m = 2;
		List<Integer> h = new ArrayList<>();
		h.add(1);
		
		List<Integer> v = new ArrayList<>();
		h.add(1);
		h.add(2);
		System.out.println(storage(n, m, h, v));
	}

	public static long storage(int n, int m, List<Integer> h, List<Integer> v) {
		long totalCell = ++n * (++m);
		
		return totalCell;
	}
}
