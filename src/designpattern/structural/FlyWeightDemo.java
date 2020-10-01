package designpattern.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightDemo {

	public static void main(String[] args) {
		Pen redThinPen = PenFactory.getThinPen("Red");
		redThinPen.draw("Hello");

		Pen redThickPen = PenFactory.getThickPen("Red");
		redThickPen.draw("Hello");

		Pen redMediumPen = PenFactory.getMediumPen("Red");
		redMediumPen.draw("Hello");

		Pen redThinPen2 = PenFactory.getThinPen("Red");
		redThinPen2.draw("Hello");
		System.out.println(redThinPen.hashCode());
		System.out.println(redThinPen2.hashCode());

	}

}

interface Pen {
	public void setColor(String color);

	public void draw(String content);
}

enum BrushSize {
	THICK, MEDIUM, THIN;
}

class ThickPen implements Pen {

	final BrushSize brushSize = BrushSize.THICK;
	private String color = null;

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void draw(String content) {
		System.out.println("Drawing Thick content in color " + color);
	}

}

class ThinPen implements Pen {

	final BrushSize brushSize = BrushSize.THIN;
	private String color = null;

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void draw(String content) {
		System.out.println("Drawing Thin content in color " + color);
	}

}

class MediumPen implements Pen {

	final BrushSize brushSize = BrushSize.MEDIUM;
	private String color = null;

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void draw(String content) {
		System.out.println("Drawing Medium content in color " + color);
	}

}

class PenFactory {

	private static final Map<String, Pen> penMap = new HashMap<>();

	public static Pen getThickPen(String color) {
		String key = color + "-THICK";
		Pen pen = penMap.get(key);
		if (null != pen) {
			return pen;
		} else {
			pen = new ThickPen();
			pen.setColor(color);
			penMap.put(key, pen);
		}
		return pen;
	}

	public static Pen getThinPen(String color) {
		String key = color + "-THIN";
		Pen pen = penMap.get(key);
		if (null != pen) {
			return pen;
		} else {
			pen = new ThinPen();
			pen.setColor(color);
			penMap.put(key, pen);
		}
		return pen;
	}

	public static Pen getMediumPen(String color) {
		String key = color + "-MEDIUM";
		Pen pen = penMap.get(key);
		if (null != pen) {
			return pen;
		} else {
			pen = new MediumPen();
			pen.setColor(color);
			penMap.put(key, pen);
		}
		return pen;
	}

}