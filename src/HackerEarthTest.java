public class HackerEarthTest extends Thread {

	static boolean b1, b2;
	static int i = 0;

	public void run() {
		i = i + 1;
	}

	public static void main(String[] args) {
		HackerEarthTest t = new HackerEarthTest();

		int x = 0;
		if (!b1) {
			if (!b2) {
				b1 = true;
				x++;
				if (!b1)
					x++;
				else if (b2 = true)
					x = x + 100;
				else if (b1 | b2)
					x = x + 1000;
			}
		}

		System.out.println(x);
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		t2.start();
		System.out.println(HackerEarthTest.i);
	}

}
