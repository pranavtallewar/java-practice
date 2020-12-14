package designpattern.creational;

public class SingletonDemo {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}

class Singleton {

	private static volatile Singleton instance = null;
	
	private Singleton() {
		
	}
	public static Singleton getInstance() {
		if(null == instance) {
			synchronized(Singleton.class) {
				if(null == instance)
					instance = new Singleton();
			}
		}
		return instance;
	}
	
}
