package inheritance;

public class ParentChildDemo {
	public static void main(String[] args) {
		Parent1 p = new Child1();
		p.method1();

	}
}

class Parent1 {
	Parent1 method1() {
		System.out.println("Parent");
		return null;
	}
}

class Child1 extends Parent1 {
	Child1 method1() {
		System.out.println("Child");
		return null;
	}
}