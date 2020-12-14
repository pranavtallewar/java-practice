package strings;

public class FinalImmutable {

	public static void main(String[] args) {
		final StringBuilder sb  = new StringBuilder("Hello");
		System.out.println(sb.toString());
		
		// Even though reference variable sb is final 
        // We can perform any changes 
		sb.append(" World");
		System.out.println("Post appending:"+sb.toString());
		
		// Here we will get Compile time error 
        // Because reassignment is not possible for final variable 
		//sb = new StringBuilder("Changed String");
		
		final String s = new String("Hello");
		System.out.println(s);
		//s = s.concat(" string");
		//System.out.println(s);

	}

}
