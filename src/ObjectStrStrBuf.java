
public class ObjectStrStrBuf {

	public void method(StringBuffer sb) {
		System.out.println("StringBuffer Verion");
	}

	public void method(String s) {
		System.out.println("String Version");
	}

	public void method(Object o) {
		System.out.println("Object Version");
	}

	public static void main(String[] args) {

		ObjectStrStrBuf question = new ObjectStrStrBuf();
		StringBuffer s = null;
		// question.method(null);
		question.method(s);
	}

}
