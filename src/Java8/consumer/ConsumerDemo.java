package Java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {

		List<Integer> l = Arrays.asList(1, 2, 3, 4);
		l.forEach(t -> System.out.println(t));

		List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

		Consumer<List<String>> upperCaseConsumer = list -> {
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i).toUpperCase());
			}
		};
		Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

		upperCaseConsumer.andThen(printConsumer).accept(cities);

		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(4, 5, 6);
		double d2 = p1.dist2D(p2);
		double d3 = p1.dist3D(p2);
		// The code below uses runtime polymorphism to call the overridden printDistance
		// method:
		Point2D p = new Point2D(0, 0);
		p.printDistance(d2);
		p = p1;
		p.printDistance(d3);
	}

}

class Point2D {
	protected double x;
	protected double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double dist2D(Point2D p) {
		return Math.ceil(Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2)));

	}

	public void printDistance(double d) {
		System.out.println("2D distance = " + new Double(d).intValue());
	}
}

class Point3D extends Point2D {
	protected double z;

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z;
	}

	public double dist3D(Point3D p) {
		return Math.ceil(Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2)));
	}

	public void printDistance(double d) {
		System.out.println("3D distance = " + new Double(d).intValue());
	}

}