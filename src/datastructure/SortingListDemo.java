package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortingListDemo {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "Pranav Tallewar"));
		employees.add(new Employee(2, "Pooja Mule"));
		employees.add(new Employee(3, "Jay Mule"));

		employees.forEach(System.out::println);
		Comparator<Employee> compareByName = (e1, e2) -> e1.getName().compareTo(e2.getName());
		Collections.sort(employees, compareByName);
		System.out.println("Sorted by Id:" + employees);
		
		// creates new sorted list
		List<Employee> sortedEmployeesByName = employees.stream().sorted(compareByName).collect(Collectors.toList());
		

		Comparator<Employee> compareById = (e1, e2) -> e1.getId().compareTo(e2.getId());
		Collections.sort(employees, compareById);
		System.out.println("Sorted by Id:" + employees);
		Collections.sort(employees, compareById.reversed());
		System.out.println("Sorted by Id:" + employees);

		TreeSet<Employee> empTreeSet = new TreeSet<>(compareByName);
		empTreeSet.add(new Employee(1, "Pranav Tallewar"));
		empTreeSet.add(new Employee(2, "Pooja Mule"));
		empTreeSet.add(new Employee(3, "Jay Mule"));
		empTreeSet.forEach(System.out::println);

		Map<Employee, String> map = new TreeMap<>(compareByName);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(-8);
		linkedList.add(10);
		linkedList.add(-20);
		//linkedList.add(null);
		Comparator<Integer> r = Collections.reverseOrder();
		Collections.sort(linkedList,r);
		for(int i : linkedList) {
			System.out.println(i+" ");
		}
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine(); // Reading input from STDIN
		System.out.println("Hi, " + str1 + "."); // Writing output to STDOUT

		// Scanner
		Scanner s1 = new Scanner(System.in);
		String str2 = s1.nextLine(); // Reading input from STDIN
		System.out.println("Hi, " + str2 + "."); // Writing output to STDOUT
		System.out.println("String with removed chars:" + removeCharacters(str1, str2));
		
	}

	private static String removeCharacters(String str1, String str2) {
		Set<Character> str2Set = new LinkedHashSet<>();
		for (char c : str2.toCharArray()) {
			str2Set.add(c);
		}
		// System.out.println(str2Set);
		List<Character> str1List = new ArrayList<>();
		for (int i = 0; i < str1.length(); i++) {
			System.out.println(str1.charAt(i));
			if (!str2Set.contains(str1.charAt(i))) {

				str1List.add(str1.charAt(i));
			}
		}
		System.out.println(String.valueOf(str1List));
		return str1List.toString();
	}
}

class Employee {

	private Integer id;

	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}