
abstract class HackerEarth {
	public abstract double hashcode();

	public abstract boolean equals();

	public abstract String toString();
}

public class ShowVal {

	final int num = 10;

	public void display() {
		int num = 12;
		Runnable runnable = new Runnable() {
			final int num = 15;

			@Override
			public void run() {
				int num = 20;
				System.out.println(this.num);

			}

		};
		runnable.run();
	}

	public static void main(String[] args) {
		ShowVal v = new ShowVal();
		v.display();

		int count = 0;
		int a = 3;
		while (count++ < 3) {
			int b = (1 + 2 * count) % 3;
			switch (b) {
			default:
			case 0:
				a -= 1;
				break;
			case 1:
				a += 5;
			}
		}
		System.out.println(a);
		int sum = 0;
		int c = 3;
		while (sum++ < 3) {
			int b = (1 + 2 * sum) % 3;
			switch (b) {
			default:
			case 0:
				c -= 1;
				break;
			case 1:
				c += 5;
			}
		}
		System.out.println(c);

	}

}
