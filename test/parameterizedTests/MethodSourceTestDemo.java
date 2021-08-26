package parameterizedTests;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class MethodSourceTestDemo {

	@DisplayName("Should pass student id pass students stream")
	@ParameterizedTest
	@MethodSource("getStudents")
	public void testParameterizedMethodWithObject(Student student) {
		System.out.println(student);
		Assertions.assertTrue(student.getId() >= 1);
	}

	private static Stream<Student> getStudents() {
		return Stream.of(new Student(1, "Pranav"), new Student(2, "Miten"));
	}
}

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
class Student {

	private int id;

	private String name;

}