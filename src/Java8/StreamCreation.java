package Java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreation {
	public static String get() {
		return "Hello JUnit 5";
	}

	public List<String> allToUpperCase(List<String> words) {
		return words.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public Employee1[] getEmployees() {
		Employee1[] arrayOfEmps = { new Employee1(1, "Jeff Bezos", 100000.0), new Employee1(2, "Bill Gates", 200000.0),
				new Employee1(3, "Mark Zuckerberg", 300000.0), null, new Employee1(4, "Mukesh Ambani", 3500000.0),
				new Employee1(5, "Ratan Tata", 250000.0), null };
		return arrayOfEmps;
	}

	public static void main(String[] args) {
		Employee1[] arrayOfEmps = { new Employee1(1, "Jeff Bezos", 100000.0), new Employee1(2, "Bill Gates", 200000.0),
				new Employee1(3, "Mark Zuckerberg", 300000.0), null, new Employee1(4, "Mukesh Ambani", 3500000.0),
				new Employee1(5, "Ratan Tata", 250000.0), null };

		// ways of obtaining stream
		Stream.of(arrayOfEmps);
		List<Employee1> empList = Arrays.asList(arrayOfEmps);
		Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);
		System.out.println("Employees Name length:");
		empList.stream().filter(e -> e != null).map(e -> e.getName()).mapToInt(String::length)
				.forEach(System.out::println);

		Double sum = empList.stream().filter(e -> e != null).mapToDouble(e -> e.getSalary()).sum();

		System.out.println("Emp Names:" + empList.stream().filter(e -> e != null).map(Employee1::getName)
				.collect(Collectors.toList()).toString());

		// forEach() loops over the stream elements, calling the supplied function on
		// each element.
		// forEach() is a terminal operation, which means that, after the operation is
		// performed, the stream pipeline is considered consumed, and can no longer be
		// used.
		empList.stream().filter(e -> e != null) // produces a new stream that contains elements of the original stream
												// that pass a given test
				.forEach(e -> e.salaryIncrement(10.0));
		empList.forEach(System.out::println);

		// map() produces a new stream after applying a function to each element of the
		// original stream
		// collect() gets stuff out of the stream once we are done with all the
		// processing
		// performs mutable fold operations (repackaging elements to some data
		// structures and applying some additional logic, concatenating them, etc.) on
		// data elements held in the Stream instance.
		// toList() collector to collect all Stream elements into a List instance.
		List<Integer> empIds = empList.stream().filter(e -> e != null) // filter(); this produces a new stream that
																		// contains elements of the original stream that
																		// pass a given test
				.map(Employee1::getId).collect(Collectors.toList());
		System.out.println(empIds);
		for (int i = 1; i < empIds.size(); i += 2) {
			empIds.remove(i);
		}
		System.out.println(empIds);

		Employee1 emp = empList.stream().filter(e -> e != null && e.getSalary() > 3500010).findFirst().orElse(null);
		System.out.println("Employee's salary greater than 3500010:" + emp);

		List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		System.out.println("getOddEvenList:" + new StreamCreation().getOddEven(intList));
		intList.stream().distinct().forEach(s -> System.out.print(s + " "));

		List<Double> productPriceList = Arrays.asList(20000.0, 25000.4, 3000.4, 2004.50, 40000.50, 32000.50);
		productPriceList.stream().forEach(p -> {
			Double gst = (p * 18) / 100;
			p = p + gst;

		});
		System.out.println();
		productPriceList.forEach(s -> System.out.print(s + " "));
		System.out.println();
		Double totalGSTPayable = productPriceList.stream()
				.collect(Collectors.reducing(0.0, e -> e * 18 / 100, (p1, p2) -> p1 + p2));

		System.out.println("Total GST Payable:" + totalGSTPayable + "\n");

		// peek() is used to perform multiple operations on each element of the stream
		// before any terminal operation is applied
		empList.stream().filter(e -> e != null).peek(e -> e.salaryIncrement(10.0)).peek(System.out::println)
				.collect(Collectors.toList());

	}

	public Long getEmpNotNullCount(List<Employee1> empList) {
		Long empCount = empList.stream().filter(e -> e != null).count();
		return empCount;
	}

	public List<String> getFlatStringStream(List<List<String>> namesNested) {

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
		return namesFlatStream;
	}

	public String getEmpNamesJoinedByComma(List<Employee1> empList) {
		return empList.stream().filter(e -> e != null).map(Employee1::getName).collect(Collectors.joining(","));
	}

	public DoubleSummaryStatistics getSummarizedEmpSalaries(List<Employee1> empList) {
		return empList.stream().filter(e -> e != null).collect(Collectors.summarizingDouble(Employee1::getSalary));
	}

	public Map<Boolean, List<Integer>> getOddEven(List<Integer> list) {
		return list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
	}
}

class Employee1 {
	private int id;
	private String name;
	private double salary;

	public Employee1(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public void salaryIncrement(double d) {
		this.salary += d;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
