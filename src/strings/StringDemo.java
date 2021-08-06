package strings;

public class StringDemo {

	public static void main(String[] args) {
		String s1 = "Pranav";
		String s2 = "Pranav";
		System.out.println((s1 == s2) + "-" + s1.hashCode() + "-" + s2.hashCode());
		System.out.println(s1.equals(s2));
		
		String s3 = new String("Pranav");
		
		System.out.println((s1 == s3));
		System.out.println(s1.equals(s3));
		System.out.println(s1.hashCode());
		System.out.println(s3.hashCode());

		String s4 = new String(s2);
		System.out.println((s2 == s4));
		System.out.println(s2.equals(s4));
		System.out.println(s4.equals(s3));
	}

}
