import java.util.stream.IntStream;

/**
 * 
 * @author tallewar_p 
 * Check to see if given series of number is multiple of 3 or 5.
 *
 */
public class Result {

	int m1 = 3, m2 = 5;

	String checkIfGivenNoisMultipleofOtherNo(int n) {
		boolean fizz = false, buzz = false;
		if (n == this.m1) {
			this.m1 = this.m1 + 3;
			fizz = true;
		}
		if (n == this.m2) {
			this.m2 = this.m2 + 5;
			buzz = true;
		}
		if (fizz && buzz) {
			return "FizzBuzz";
		} else if (fizz && !buzz) {
			return "Fizz";
		} else if (!fizz & buzz) {
			return "Buzz";
		} else {
			return n + "";
		}
	}

	public static void main(String[] args) {
		
		Result r = new Result();
		IntStream.rangeClosed(1, 15).boxed().map(n -> r.checkIfGivenNoisMultipleofOtherNo(n))
				.forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		// Using Method reference.
		MultipleOfGivenNo m = new Result()::checkIfGivenNoisMultipleofOtherNo;
		IntStream.range(1, 15).boxed().map(n -> m.checkIfGivenNoisMultipleofOtherNo(n))
				.forEach(s -> System.out.print(s + " "));

	}

}

@FunctionalInterface
interface MultipleOfGivenNo {
	abstract String checkIfGivenNoisMultipleofOtherNo(int n);
}