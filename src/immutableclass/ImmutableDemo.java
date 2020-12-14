package immutableclass;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ImmutableDemo {

	public static void main(String[] args) {
		Address add = new Address("Home", "Adajan", "Surat");

		ZoneId defaultZoneId = ZoneId.systemDefault();

		LocalDate localDate = LocalDate.of(1989, 06, 12);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		Map<String, String> map = new HashMap<>();
		map.put("1", "test");

		Employee emp = new Employee(1, "Pranav", 31, date, add, map);
		System.out.println("Testing of Object " + emp);
		emp.getAddress().setCity("Ahmedabad");
		emp.getMap().put("1", "test1");
		System.out.println("City updated to Ahmedabad");
		System.out.println("Checking now");
		System.out.println(emp);
		System.out.println("City and Map remains unchanged...");

	}

}

final class Employee {

	final Integer id;

	final String name;

	final Integer age;

	final Date date;

	final Address address;

	final Map<String, String> map;

	public Employee(Integer id, String name, Integer age, Date date, Address address, Map<String, String> map) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.date = new Date(date.getTime());
		this.address = address;
		this.map = map;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Date getDate() {
		return new Date(date.getTime());
	}

	public Map<String, String> getMap() {
		return new HashMap<>(map);
	}

	public Address getAddress() {

		Address add = new Address();
		add.setAddress(this.address.getAddress());
		add.setAddressType(this.address.getAddressType());
		add.setCity(this.address.getCity());

		return add;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", date=" + date + ", address=" + address
				+ ", map=" + map + "]";
	}

}

class Address implements Cloneable {

	public String addressType;
	public String address;
	public String city;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressType, String address, String city) {
		super();
		this.addressType = addressType;
		this.address = address;
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressType=" + addressType + ", address=" + address + ", city=" + city + "]";
	}

}