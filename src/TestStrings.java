import java.util.Arrays;
import java.util.List;

public class TestStrings {

	private static List<String> list = Arrays.asList(new String("ABC"), new String("ABC"), "AEF", "QPR");

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("XYZ");
		String s3 = "ABC";
		System.out.println(s3.hashCode());
		System.out.println(s1.equals(s3));
		System.out.println(s1.hashCode());
		System.out.println(methodA(s1));

	}

	private static Long methodA(String s1) {
		list.forEach(s->{
			System.out.println(s.hashCode());
		});
		return list.stream().filter(s -> s.equals(s1)).count();
	}

}
