package designpattern.structural.decorator;

import java.math.BigDecimal;

public class Peproni extends PizzaDecorator {

	private Pizza pizza;
	private static final String name="Pepperoni";

	public Peproni(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public BigDecimal getCost() {
		return this.pizza.getCost().add(new BigDecimal(1.50));
	}

	@Override
	public String getDescription() {
		return this.pizza.getDescription() +" with "+ name;
	}

}
