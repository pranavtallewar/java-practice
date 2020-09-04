package exception;

import java.io.IOException;

public class TestExceptionPropagation {

	void m() throws IOException {
		throw new IOException("device error");
	}

	void n() throws IOException {
		m();
	}

	void p() throws IOException {

		n();

	}

	void validateAge(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("You are Under age - " + age);
		else
			System.out.println("You are allowed to vote - " + age);
	}

	public static void main(String[] args) {
		try {
			new TestExceptionPropagation().p();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			new TestExceptionPropagation().validateAge(21);
			new TestExceptionPropagation().validateAge(17);
		} catch (InvalidAgeException e) {
			e.printStackTrace();
		}

	}

}

class InvalidAgeException extends Exception {
	public InvalidAgeException(String s) {
		super(s);
	}
}