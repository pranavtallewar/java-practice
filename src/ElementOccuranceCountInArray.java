import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElementOccuranceCountInArray {

	public static void main(String[] args) {
		arrayElementCount(new int[] { 4, 5, 4, 5, 4, 6 });
		String str = "abdacdd";

		arrayElementCount(str);
	}

	static void arrayElementCount(String str) {
		char[] inputArray = str.toCharArray();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < inputArray.length; i++) {
			int count = 0;
			if (!set.contains(inputArray[i] + "")) {
				set.add(inputArray[i] + "");
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == inputArray[i]) {
						count++;
					}
				}
				System.out.println("Count of " + inputArray[i] + " is:" + count);
			}
		}
		
		//Java 8 way
		Map<String, Long> charCount = IntStream.range(0, str.length()).mapToObj(i -> str.substring(i, i + 1))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(charCount);

	}

	static void arrayElementCount(int inputArray[]) {
		// Creating a HashMap object with elements of inputArray as keys and their count
		// as values

		Map<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

		// checking every element of the inputArray

		/*
		 * for (int i : inputArray) { if (elementCountMap.containsKey(i)) { // If
		 * element is present in elementCountMap, incrementing it's count by 1
		 * 
		 * elementCountMap.put(i, elementCountMap.get(i) + 1); } else { // If element is
		 * not present in elementCountMap, // adding this element to elementCountMap
		 * with 1 as it's value
		 * 
		 * elementCountMap.put(i, 1); } }
		 */
		Arrays.stream(inputArray).forEach(i -> {
			if (elementCountMap.containsKey(i)) {
				// If element is present in elementCountMap, incrementing it's count by 1
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				// If element is not present in elementCountMap,
				// adding this element to elementCountMap with 1 as it's value
				elementCountMap.put(i, 1);
			}
		});

		System.out.println("Input Array : " + Arrays.toString(inputArray));

		System.out.println("Element Count : " + elementCountMap);
	}
}
