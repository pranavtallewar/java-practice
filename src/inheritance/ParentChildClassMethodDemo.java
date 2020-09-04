package inheritance;

public class ParentChildClassMethodDemo {

	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		Parent p1 = new Parent();
		p.hello();
		c.hello();
		p1.hello();

	}

}

class Parent {
	public void hello() throws NullPointerException {
		System.out.println("Hi from Parent");
	}
}

class Child extends Parent {
	@Override
	public void hello() throws RuntimeException {
		System.out.println("Hi from Child");

	}
}
