package designpattern.structural;

import java.util.HashMap;
import java.util.Map;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		final OfficeInternetAccess access = new ProxyInternetAccess("Pranav");
		access.grantInternetAccess();
	}

}

interface OfficeInternetAccess {
	public void grantInternetAccess();
}

class RealInternetAccess implements OfficeInternetAccess {
	private String employeeName;

	public RealInternetAccess(String empName) {
		this.employeeName = empName;
	}

	@Override
	public void grantInternetAccess() {
		System.out.println("Internet Access granted for employee: " + employeeName);
	}
}

class ProxyInternetAccess implements OfficeInternetAccess {
	private String employeeName;
	private RealInternetAccess realaccess;
	
	private static Map<String,Integer> accessMap = new HashMap<>();
	{
		accessMap.put("Pranav", 10);
		accessMap.put("Miten", 8);
		accessMap.put("Jay", 6);
		accessMap.put("Pooja", 5);
		accessMap.put("CK", 4);
	}

	public ProxyInternetAccess(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public void grantInternetAccess() {
		if (getRole(employeeName) > 4) {
			realaccess = new RealInternetAccess(employeeName);
			realaccess.grantInternetAccess();
		} else {
			System.out.println("No Internet access granted. Your job level is below 5");
		}
	}

	private int getRole(String emplName) {
		// Check role from the database based on Name and designation
		// return job level or job designation.
		
		return accessMap.get(emplName);
	}
}