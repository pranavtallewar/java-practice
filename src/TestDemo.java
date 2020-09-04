
public class TestDemo {
	static String[] xyz;

	public static void main(String argv[]) {
		xyz = argv;
	}

	public void runMethod() {
		System.out.println(xyz[1]);
	}
}
