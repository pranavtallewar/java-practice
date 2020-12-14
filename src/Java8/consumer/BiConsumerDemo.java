package Java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList(new Customer("Pranav", 987561), new Customer("Pooja", 1234535));
		customers.stream().forEach(customer -> greetCustomerV2.accept(customer, false));
	}

	static Consumer<Customer> greetCustomer = customer -> {
		System.out.println("Hello " + customer.name + ", thanks for register with " + customer.phone);
	};

	static BiConsumer<Customer, Boolean> greetCustomerV2 = (customer, showPhone) -> {
		if (showPhone)
			System.out.println("Hello " + customer.name + ", thanks for register with " + customer.phone);
		else
			System.out.println("Hello " + customer.name + ", thanks for register with us.");
	};

	static class Customer {
		public Customer(String name, int phone) {
			this.name = name;
			this.phone = phone;
		}

		private final String name;
		private final int phone;

	}

}
