package staticnestedclass;

public class StaticNestedClassDemo {

	static int data = 30;
	int data1 = 10;

	static class Inner {
		void msg() {
			System.out.println("data is " + data);
			show();
		}
	}
	
	public void display() {
		System.out.println("display()");
	}
	
	public static void show() {
		System.out.println("show()");
	}

	public static void main(String[] args) {
		StaticNestedClassDemo.Inner obj = new StaticNestedClassDemo.Inner();
		obj.msg();

	}

}
