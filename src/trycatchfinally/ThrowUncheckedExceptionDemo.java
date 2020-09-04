package trycatchfinally;

import java.io.IOException;

public class ThrowUncheckedExceptionDemo {

	static String name;
	
	static void validate(int age) {
		if (age < 18)
			throw new ArithmeticException("not valid age");
		else
			System.out.println("welcome to vote");
	}

	void m() throws IOException {
		throw new java.io.IOException("device error");// checked exception
	}

	void n() throws IOException {
		m();
	}

	void p() {
		try {
			n();
		} catch (Exception e) {
			System.out.println("exception handeled");
		}
	}

	public static void main(String[] args) {
		validate(13);
		System.out.println("rest of the code...");

		ThrowUncheckedExceptionDemo t = new ThrowUncheckedExceptionDemo();
		t.p();
		System.out.println("normal flow");
	}

}
