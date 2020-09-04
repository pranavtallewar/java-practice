package Java8.methodreference.instancemethod;

public class InstanceMethodReference {

	public String saySomething() {
		return "Hello this is no-static method.";
	}

	public void printMsg() {
		System.out.println("Hello, this is instance method. Thread is running..");
	}

	public static void main(String[] args) {

		InstanceMethodReference imr = new InstanceMethodReference();
		// Referring non-static method using reference.
		Sayable sayable = imr::saySomething;
		//
		System.out.println(sayable.say());

		Thread t = new Thread(imr::printMsg);
		t.start();

	}

}

interface Sayable {
	String say();
}