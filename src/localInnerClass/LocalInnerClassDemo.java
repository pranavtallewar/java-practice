package localInnerClass;

public class LocalInnerClassDemo {
	private int data = 30;// instance variable
	private final int d = 13;

	void display() {
		class Local {
			void msg() {
				System.out.println("accessing non-final var:" + data);
				System.out.println("accessing final var:" + d);
			}
		}
		Local l = new Local();
		l.msg();
	}

	public static void main(String[] args) {
		System.out.println("<======LocalInnerClass=====>");
		System.out.println(
				"A class i.e., created inside a method, is called local inner class in java. Local Inner Classes are the inner classes that are defined inside a block. Generally, this block is a method body. Sometimes this block can be a for loop, or an if clause. Local Inner classes are not a member of any enclosing classes. ");
		LocalInnerClassDemo obj = new LocalInnerClassDemo();
		obj.display();
	}

}
