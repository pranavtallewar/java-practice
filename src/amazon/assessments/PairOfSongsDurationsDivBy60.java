package amazon.assessments;

public class PairOfSongsDurationsDivBy60 {

	public static int numPairsDivisibleBy60(int[] time) {
		int count = 0;

		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				if((time[i] + time[j]) % 60 == 0)
					count++;
			}
		}

		return count;
	}
	
	public static int numPairsDivisibleBy60_1(int[] time) {
        int[] a = new int[60];
        int pairs = 0;
        for (int t : time) {
            pairs += a[60 - ((t - 1) % 60 + 1)];
            a[t % 60]++;
        }
        return pairs;
    }

	public static void main(String[] args) {
		int[] time = { 30, 20, 150, 100, 40 };
		System.out.println(numPairsDivisibleBy60(time));
		System.out.println(numPairsDivisibleBy60_1(time));
	}

}
