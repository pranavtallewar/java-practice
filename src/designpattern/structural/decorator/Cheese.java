package designpattern.structural.decorator;

import java.math.BigDecimal;

public class Cheese extends PizzaDecorator {

	private Pizza pizza;
	private static final String name = "Cheese";

	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return this.pizza.getDescription() + " with " + name;
	}

	@Override
	public BigDecimal getCost() {
		// TODO Auto-generated method stub
		return this.pizza.getCost().add(new BigDecimal(1.0));
	}

}
