package Java8.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		String book = "java 8";
		Optional<String> optionalStr = Optional.ofNullable(book);
		System.out.println("Book is not null : " + optionalStr.orElse("java 9").toUpperCase());
		book = null;
		optionalStr = Optional.ofNullable(book);

		System.out.println("\nChecking orElse from Optional:");
		System.out.println("Book is set to null : " + optionalStr.orElse("java 9").toUpperCase());

		System.out.println("\nChecking map and orElseGet methods from Optional:");
		System.out.println(optionalStr.map(String::toUpperCase).orElseGet(() -> "Java9"));

		System.out.println("\nChecking orElseThrow from Optional as object is null:");
		//optionalStr.orElseThrow(NullPointerException::new);

		System.out.println("\nChecking isPresent from Optional as object is null:");
		System.out.println(optionalStr.isPresent());

		System.out.println("\nChecking ifPresent from Optional as object is null:");
		optionalStr.ifPresent(t -> System.out.println(t));
		
	}

}
