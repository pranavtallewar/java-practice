package Java8.stream.maps;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * 
 * 
 * 
 * map() -> has to return one object. That means each object in the input stream
 * results in exactly one object in the output stream.
 * 
 * flatMap() -> returns a stream for each object. That means the function can
 * return any number of objects for each input object (including none). The
 * resulting streams are then concatenated to one output stream.
 *
 */

public class MapAndFlatMapDemo {

	public static void main(String[] args) {
		Parcel amazon = new Parcel("Amazon", "Laptop", "Phone");
		Parcel flipkart = new Parcel("Flipkart", "Monitor", "Mouse", "Keyboard");

		List<Parcel> parcels = Arrays.asList(amazon, flipkart);
		System.out.println("=======Without FlatMap======");
		List<List<String>> mapReturn = parcels.stream().map(Parcel::getItems).collect(Collectors.toList());
		System.out.println(mapReturn);
		System.out.println("\n=======With FlatMap======");
		List<String> flatMapReturn = parcels.stream().map(Parcel::getItems).flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(flatMapReturn);

		// Creating a list of Prime Numbers
		List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

		// Creating a list of Odd Numbers
		List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

		// Creating a list of Even Numbers
		List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

		System.out.println("\nThe Structure before flattening is : " + listOfListofInts);

		// Using flatMap for transformating and flattening.
		List<Integer> listofInts = listOfListofInts.stream().flatMap(list -> list.stream())
				.collect(Collectors.toList());

		System.out.println("The Structure after flattening is : " + listofInts);
	}

}

class Parcel {
	String name;
	List<String> items;

	public Parcel(String name, String... items) {
		super();
		this.name = name;
		this.items = Arrays.asList(items);
	}

	public List<String> getItems() {
		return items;
	}

}