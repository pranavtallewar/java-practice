package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadLocalDemo {

	private static List<User> users = new ArrayList<>();

	public static void main(String[] args) {
		createUsers();
		users.forEach(System.out::println);
	}

	private static void createUsers() {
		for (int i = 1; i <= 1000; i++) {
			Date date = RandomDates.createRandomDate(1900, 2000);
			users.add(new User(i, date));
		}
	}

}

class User {
	Integer userId;
	Date dateOfBirth;

	public User(Integer userId, Date dateOfBirth) {
		this.userId = userId;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getUserId() {
		return userId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", dateOfBirth=" + dateOfBirth + "]";
	}

}

class RandomDates {
	public static int createRandomIntBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static Date createRandomDate(int startYear, int endYear) {
		int day = createRandomIntBetween(1, 28);
		int month = createRandomIntBetween(1, 12);
		int year = createRandomIntBetween(startYear, endYear);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.of(year, month, day);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		return date;
	}
}

class ThreadLocalHolder {
	public static ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("mm-DD-yyyy"));
}
