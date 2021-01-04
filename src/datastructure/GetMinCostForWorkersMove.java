package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMinCostForWorkersMove {

	public static void main(String[] args) {
		List<Integer> crews = new ArrayList<>();
		crews.add(3);
		crews.add(1);
		crews.add(4);
		crews.add(6);
		crews.add(5);

		List<Integer> jobs = new ArrayList<>();
		jobs.add(9);
		jobs.add(8);
		jobs.add(3);
		jobs.add(15);
		jobs.add(1);

		System.out.println(getMinCost(crews, jobs));
	}

	public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
		long cost = 0;

		Collections.sort(crew_id);
		Collections.sort(job_id);

		int len1 = crew_id.size();
		int len2 = job_id.size();

		if (len1 == len2) {
			for (int i = 0; i < len1; i++) {

				if (job_id.get(i) >= crew_id.get(i)) {
					cost = cost + (job_id.get(i) - crew_id.get(i));
				} else if (job_id.get(i) < crew_id.get(i)) {
					cost = cost + (crew_id.get(i) - job_id.get(i));
				}
			}
		}

		return cost;
	}

}
