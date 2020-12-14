package datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmpMapNSetDemo {

	public static void main(String[] args) {
		Map<Emp, String> map = new HashMap<>();
		Emp e1 = new Emp(1, "Pranav");
		Emp e2 = new Emp(2, "Piyush");
		Emp e3 = new Emp(1, "Pranav");
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		
		map.put(e1, "ABC");
		map.put(e2, "DEF");
		map.put(e3, "PQR");
		System.out.println(map);

		Set<Emp> emps = new HashSet<>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);

		System.out.println(emps);
	}

}

class Emp {
	int id;
	String name;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

}
