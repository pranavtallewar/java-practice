package trycatchfinally;

import java.io.IOException;

public class ThrowsDemo {

	public static void main(String[] args){
		M m = new M();
		m.method();

		System.out.println("normal flow...");
	}

}

class M {
	void method()  {
		try {
			System.out.println("Testing demo");
			int c = 5 / 0;
		} catch (Exception e) {
			throw new RuntimeException("device error", e);	
		}

	}
}