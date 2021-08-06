package nestedinterface;

interface Showable {
	void show();

	interface Message {
		void msg();
	}
}

class NestedInterfaceDemo implements Showable.Message, Showable {
	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String args[]) {
		Showable.Message message = new NestedInterfaceDemo();// upcasting here
		message.msg();
		Showable show = new NestedInterfaceDemo();
		show.show();
	}

	@Override
	public void show() {
		System.out.println("Showing from Parent interface");

	}
}
