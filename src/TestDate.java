import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		Date d = new Date();

		SimpleDateFormat s = new SimpleDateFormat("MMM");
		String date = s.format(d);
		System.out.println(date);

	}

}
