package Java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemoWithCustomObject {

	public static void main(String[] args) {
		
		Person person = new Person("ABC", null);
		System.out.println("Email details using map and orElse:"
				+ person.getEmail().map(String::toLowerCase).orElse("Email not present"));
		System.out
				.println((person.getEmail().isPresent()) ? person.getEmail().get().toLowerCase() : "Email not present");

		Person person1 = new Person("DEF", "DEF@GMAIL.com", Arrays.asList("976512", "4513165"));

		Optional<String> nameOptional = Optional.ofNullable(person1.getName());
		System.out.println(nameOptional.orElse("Default name returned"));
		
		Person person2 = new Person(null, "DEF@GMAIL.com", Arrays.asList("976512", "4513165"));

		Optional<String> nullNameOptional = Optional.ofNullable(person2.getName());
		System.out.println(nullNameOptional.orElseThrow(()-> new IllegalArgumentException("Name not present")));
		
		

	}

}

class Person {
	String name;
	String email;
	List<String> phoneNumbers;

	public Person(String name, String email, List<String> phoneNumbers) {
		this.name = name;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
	}

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

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", phoneNumbers=" + phoneNumbers + "]";
	}

}
