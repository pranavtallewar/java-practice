package trycatchfinally;

import java.io.IOException;

public class FinallyDemo {

	public static void main(String[] args) throws IOException {
		ThrowsException te = new ThrowsException();
		te.display();
	}

}

class Finally {
	public int testInt() {
		try {
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return 1;
		}
	}
}

class ThrowsException {
	public void display() throws IOException {
		throw new IOException("device error");
	}
}
