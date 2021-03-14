package Java8.methodreference.staticmethod;

public class MethodReferenceToStatic {

	public static void say() {
		System.out.println("Hello, this is static method");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running..");
	}

	public static void main(String[] args) {
		// functional interface referring to static method by it's functional method
		// say()
		Sayable sayable = MethodReferenceToStatic::say;
		// calling it simply
		sayable.say();
		
		//Pre-defined function interface Runnable referring to static method.
		Thread t2 = new Thread(MethodReferenceToStatic::ThreadStatus);
		//calling it to start
		t2.start();

	}

}

interface Sayable {
	void say();
}