import java.text.SimpleDateFormat;
import java.util.Date;

public class Test extends BaseC implements BaseI {

	public static void main(String[] args) {
		int var1 = 42;
		int var2 = ~var1;
		System.out.println(var1 + " " + var2);

		int g = 3;
		System.out.println(++g * 8);

		String s = new SimpleDateFormat("MMMM").format(new Date()).substring(0, 3);
		System.out.println(s);

		Date d = new Date();

		short s1 = 9;
		// System.out.println(add(s1,6));

		(new Test()).method();

		Float f1 = new Float("3.0");
		int x = f1.intValue();
		byte b = f1.byteValue();
		double d1 = f1.doubleValue();
		System.out.println(x + b + d1);

		int aa = 1;
		int kk = aa++;
		int cc = ++kk;
		System.out.println(aa + " " + kk + " " + cc);
	}

}

class A {
	int add(int i, int j) {
		return i + j;
	}
}

interface BaseI {
	void method();
}

class BaseC {
	public void method() {
		System.out.println("Inside BaseC::method");
	}

}