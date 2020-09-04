package trycatchfinally;

import java.io.IOException;

public class ThrowsDemo {

	public static void main(String[] args) throws IOException {
		M m = new M();
		m.method();

		System.out.println("normal flow...");
	}

}

class M {
	void method() throws IOException {
		try {
			System.out.println("Testing demo");
			int c = 5 / 0;
		} catch (Exception e) {
			throw new IOException("device error", e);
		}

	}
}