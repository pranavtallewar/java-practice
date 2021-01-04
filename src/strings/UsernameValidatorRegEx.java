package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UsernameValidatorRegEx {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Julia");
		list.add("Samantha");
		list.add("Samantha_21");
		list.add("1Samantha");
		list.add("Samantha?10_2A");
		list.add("JuliaZ007");
		list.add("Julia@007");
		list.add("_Julia007");
		
		for (String userName : list) {
			if (userName.matches(UsernameValidator.regularExpression)) {
				System.out.println("Valid");
			} else {
				System.out.println("Invalid");
			}
		}
	}
}

class UsernameValidator {
	public static final String regularExpression = "^(?=.{8,30}$)(?![_0-9])[a-zA-Z0-9_]+$";
}
