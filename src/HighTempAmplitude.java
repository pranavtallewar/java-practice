import java.util.Arrays;
import java.util.OptionalInt;

public class HighTempAmplitude {

	public static void main(String[] args) {
		int[] temps = new int[] { -3, -14, -5, 7, 8, 42, 8, 3 };

		System.out.println(solution(temps));
	}

	public static String solution(int[] T) {
		int tempsToExtractPerSeason = T.length / 4;

		int c = 0, j = 0;
		int[] temps = new int[2];
		int[] tempDiff = new int[4];
		for (int i = 0; i < T.length; i++) {
			temps[c] = T[i];
			c++;
			if (c == tempsToExtractPerSeason) {
				c = 0;
				tempDiff[j] = caluclateDiff(temps);
				j++;
			}

		}

		int n = getIndexOfLargest(tempDiff);
		if (n == 0)
			return "WINTER";
		else if (n == 1)
			return "SPRING";
		else if (n == 2)
			return "SUMMER";
		else if (n == 3)
			return "AUTOMN";
		return null;
	}

	public static int caluclateDiff(int[] t) {
		int diff = 0;
		OptionalInt max = Arrays.stream(t).max();
		OptionalInt min = Arrays.stream(t).min();
		if (max.isPresent() && min.isPresent()) {
			diff = max.getAsInt() - min.getAsInt();
		}
		return diff;
	}

	public static int getIndexOfLargest(int[] array) {
		if (array == null || array.length == 0)
			return -1; // null or empty

		int largest = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[largest])
				largest = i;
		}
		return largest; // position of the first largest found
	}

}
