import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CandidateCode {
	Set<String> list = new HashSet<>();
	static int[] denominations = { 1, 2, 5 };
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer number = scan.nextInt();
		scan.close();
		System.out.print(combination(number));

	}

	private static int combination(Integer no) {
		int sum = 0;
		int cnt = 1;

		while (sum != no) {
			for (int i = 0; i < denominations.length; i++) {
				if (denominations[i] != 0) {
					sum += denominations[i];
					map.put(denominations[i], cnt);
					if (sum > no) {
						int c = cnt - 1;
						map.put(denominations[i], c);
						sum -= denominations[i];
						denominations[i] = 0;
						break;
					}
				}
			}
			cnt++;
		}
		if (sum == no) {
			if(map.get(2) > map.get(5) && map.get(1) > map.get(2)) {
				return 1;
			}
			return 0;
		} else
			return 0;
	}
}
