package Java8.methodreference.constructor;

public class ConstructorReference {

	public static void main(String[] args) {
		// referring constructor with the help of functional interface
		Messageable hello = Message::new;
		hello.getMessage("Hello from Constructor");

	}
}

class Message {
	Message(String msg) {
		System.out.println(msg);
	}
}

interface Messageable {
	Message getMessage(String msg);
}

@FunctionalInterface
interface FucnctionalDemo {

  void letsDoSomething();
  //void letsGo();      //invalid because another abstract method does not allow
  public String toString();    // valid because toString from Object 
  public boolean equals(Object o); //valid
  public static int sum(int a,int b)   // valid because method static
    {   
        return a+b;
    }
    public default int sub(int a,int b)   //valid because method default
    {
        return a-b;
    }
}