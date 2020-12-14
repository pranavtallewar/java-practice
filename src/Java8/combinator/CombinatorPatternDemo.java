package Java8.combinator;

import java.util.function.Function;

import Java8.combinator.CustomerValidator.ValidationResult;
import static Java8.combinator.CustomerValidator.*;

public class CombinatorPatternDemo {

	public static void main(String[] args) {
		Customer customer = new Customer("PranavTallewar", "pranav@gmail.com", "+919765964643");
		ValidationResult validator = isEmailValid()
									.and(isNameValid())
									.and(isNameValid())
									.apply(customer);

		if (!validator.equals(ValidationResult.SUCCESS))
			throw new RuntimeException(validator.toString());
		else
			System.out.println(validator.toString());
	}

}

class Customer {
	public Customer(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	private final String name;
	private final String email;
	private final String phone;

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
}

interface CustomerValidator extends Function<Customer, ValidationResult> {
	enum ValidationResult {
		SUCCESS, PHONE_NOT_VALID, EMAIL_NOT_VALID, NAME_NOT_VALID
	};

	default CustomerValidator and(CustomerValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}

	static CustomerValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS
				: ValidationResult.EMAIL_NOT_VALID;
	}

	static CustomerValidator isPhoneValid() {
		return customer -> customer.getPhone().startsWith("+91") ? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NOT_VALID;
	}

	static CustomerValidator isNameValid() {
		return customer -> !customer.getPhone().matches("[A-Za-z]+") ? ValidationResult.SUCCESS
				: ValidationResult.NAME_NOT_VALID;
	}
}