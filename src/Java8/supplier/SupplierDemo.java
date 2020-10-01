package Java8.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B");
		Supplier<String> supplier = () -> "Not Found any";
		System.out.println(list.stream().findAny().orElseGet(supplier));
		
		List<String> emptylist = Arrays.asList();
		System.out.println(emptylist.stream().findAny().orElseGet(supplier));
		
		Supplier<Double> doubleSupplier1 = () -> Math.random();
	    DoubleSupplier doubleSupplier2 = Math::random;

	    System.out.println(doubleSupplier1.get());
	    System.out.println(doubleSupplier2.getAsDouble());
	}
}
