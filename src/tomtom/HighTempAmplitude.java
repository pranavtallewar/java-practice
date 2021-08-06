package tomtom;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class HighTempAmplitude {

	public static void main(String[] args) {
		int[] temps = new int[] { -3, -14, -5, 7, 8, 42, 8, 3, 4 };
		int[] temps1 = new int[] { 2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18 };
		System.out.println(solution(temps));
	}

	public static String solution(int[] T) {
		final String[] seasons = { "WINTER", "SPRING", "SUMMER", "AUTUMN" };
		if ((T.length % seasons.length) != 0) {
			return "Invalid T array. Incorrect number of temperature combinations";
		}
		int tempsToExtractPerSeason = T.length / seasons.length;

		int cntrForSeason = 0, cntrForDiff = 0;
		int[] temps = new int[tempsToExtractPerSeason];
		int[] tempDiff = new int[seasons.length];
		for (int i = 0; i < T.length; i++) {
			temps[cntrForSeason] = T[i];
			cntrForSeason++;
			if (cntrForSeason == tempsToExtractPerSeason) {
				cntrForSeason = 0;
				tempDiff[cntrForDiff] = caluclateAmplitude(temps);
				cntrForDiff++;
			}

		}
		int n = getIndexOfLargest(tempDiff);
		return seasons[n];
	}

	public static int caluclateAmplitude(int[] t) {
		int diff = 0;
		int max = Arrays.stream(t).max().getAsInt();
		int min = Arrays.stream(t).min().getAsInt();
		diff = max - min;
		return diff;
	}

	public static int getIndexOfLargest(int[] array) {
		if (array == null || array.length == 0)
			return -1; // null or empty

		return IntStream.range(0, array.length).parallel().reduce((a, b) -> array[a] < array[b] ? b : a).getAsInt(); // position
																														// of
																														// the
																														// first
																														// largest
																														// found
	}

}
