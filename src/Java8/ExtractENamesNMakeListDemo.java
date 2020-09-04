package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractENamesNMakeListDemo {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Pranav"));
		list.add(new Employee(2, "Miten"));
		list.add(new Employee(3, "Pooja"));
		list.add(new Employee(4, "Jay"));
		// extracts employee names, sorts then and stores in list
		List<String> empName = list.stream().map(Employee::getName).sorted().collect(Collectors.toList());
		System.out.println(empName);
	}

}

class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
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

}
