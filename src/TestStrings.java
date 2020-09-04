import java.util.Arrays;
import java.util.List;

public class TestStrings {

	private static List<String> list = Arrays.asList(new String("ABC"), new String("ABC"), "AEF", "QPR");

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("XYZ");
		System.out.println(methodA(s1));

	}

	private static Long methodA(String s1) {
		return list.stream().filter(s -> s.equals(s1)).count();
	}

}
