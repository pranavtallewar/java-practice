package Java8.defaultmethods;

public class DefaultMethodsDemo implements Poet, Writer {
	public void existingMethod(String str) {

		System.out.println("String is: " + str);
	}

	public void disp(String str) {
		System.out.println("String is: " + str);
	}

	// Implementation of duplicate default method
	public void newMethod() {
		System.out.println("Implementation of default method");
	}

	@Override
	public void canWrite() {
		Poet.super.canWrite();
	}

	public static void main(String[] args) {
		DefaultMethodsDemo obj = new DefaultMethodsDemo();
		obj.canWrite();
		Writer.write();
	}

}

interface Poet {
	default void canWrite() {
		System.out.println("Poet's default method");
	}

	void existingMethod(String str);

	static void write() {
		System.out.println("Poet's static write method");
	}
}

interface Writer {

	default void canWrite() {
		System.out.println("Writer's default method");
	}

	void disp(String str);

	static void write() {
		System.out.println("Writer's static write method");
	}
}