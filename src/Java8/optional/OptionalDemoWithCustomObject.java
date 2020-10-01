package Java8.optional;

import java.util.Optional;

public class OptionalDemoWithCustomObject {

	public static void main(String[] args) {
		Person person = new Person("ABC", null);
		System.out.println("Email details using map and orElse:"
				+ person.getEmail().map(String::toLowerCase).orElse("Email not present"));
		System.out
				.println((person.getEmail().isPresent()) ? person.getEmail().get().toLowerCase() : "Email not present");

	}

}

class Person {
	String name;
	String email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getEmail() {
		return Optional.ofNullable(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + "]";
	}

}
