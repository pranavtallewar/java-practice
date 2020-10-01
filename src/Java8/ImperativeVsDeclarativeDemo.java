package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ImperativeVsDeclarativeDemo {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Pranav", Gender.MALE), new Person("Pooja", Gender.FEMALE),
				new Person("Miten", Gender.MALE), new Person("Jay", Gender.MALE), new Person("Nisha", Gender.FEMALE),
				new Person("Sandeep", Gender.MALE));
		System.out.println(people);
		System.out.println("\nApproach to find females and print\n");
		imperativeApproach(people);
		declarativeApproach(people);

	}

	static void imperativeApproach(List<Person> people) {
		System.out.println("---- Imperative Approach ----");
		List<Person> females = new ArrayList<>();
		for (Person person : people) {
			if (Gender.FEMALE.equals(person.gender))
				females.add(person);
		}
		for (Person female : females) {
			System.out.println(female);
		}
	}

	static void declarativeApproach(List<Person> people) {
		System.out.println("---- Declarative Approach ----");
		people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).collect(Collectors.toList())
				.forEach(System.out::println);
	}

	static class Person {
		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		private final String name;
		private final Gender gender;

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}

	static enum Gender {
		MALE, FEMALE;
	}
}
