package designpattern.structural.decorator;

import java.math.BigDecimal;

public class Chicken extends PizzaDecorator {

	private Pizza pizza;

	private static final String name = "Chicken";

	public Chicken(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return this.pizza.getDescription() + " with " + name;
	}

	@Override
	public BigDecimal getCost() {
		return this.pizza.getCost().add(new BigDecimal(5.0));
	}

}
