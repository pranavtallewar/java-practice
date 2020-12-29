package designpattern.structural.decorator;

import org.junit.Test;
import org.junit.jupiter.api.Order;

public class DecoratorTest {

	@Test
	@Order(1)
	public void testDecoratorForThickCrust() {
		Pizza pizza = new ThickCrustPizza();
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());

		Peproni pepperoni = new Peproni(pizza);
		System.out.println(pepperoni.getDescription());
		System.out.println(pepperoni.getCost());

		Cheese cheese = new Cheese(pepperoni);
		System.out.println(cheese.getDescription());
		System.out.println(cheese.getCost());

		Chicken chicken = new Chicken(cheese);
		System.out.println(chicken.getDescription());
		System.out.println(chicken.getCost());
	}

	@Test
	@Order(0)
	public void testDecoratorForCheeseBurst() {
		Pizza pizza = new CheeseBurst();
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());

		Peproni pepperoni = new Peproni(pizza);
		System.out.println(pepperoni.getDescription());
		System.out.println(pepperoni.getCost());

		Chicken chicken = new Chicken(pepperoni);
		System.out.println(chicken.getDescription());
		System.out.println(chicken.getCost());
	}
}
