package strings;

public class SmallestSubString {

	public static void main(String[] args) {
		String input1 = "this is a test string";
		String input2 = "tist";
		int input2Len = input2.length();
		String smallSubString = null;

		for (int i = 0; i < input1.length(); i++) {
			for (int j = input2Len - 1; j < input1.length(); j++) {
				String tmp = input1.substring(i, j + 1);
				boolean isContains = isContains(tmp, input2);
				if (isContains) {
					if (smallSubString == null)
						smallSubString = tmp;
					else if (smallSubString.length() > tmp.length())
						smallSubString = tmp;
				}
			}
			input2Len++;
		}
		if (smallSubString == null)
			System.out.println("No such window exists");
		else
			System.out.println("Smallest window ::: " + smallSubString);
	}

	public static boolean isContains(String tmp, String sStr) {

		int array[] = new int[256];

		for (int i = 0; i < tmp.length(); i++) {
			array[tmp.charAt(i)]++;
		}

		for (int i = 0; i < sStr.length(); i++) {
			if (array[sStr.charAt(i)] == 0)
				return false;
			else
				array[sStr.charAt(i)]--;
		}
		return true;
	}

}
