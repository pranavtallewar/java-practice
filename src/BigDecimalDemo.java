import java.math.BigDecimal;

public class BigDecimalDemo {

	public static void main(String[] args) {
		String[] s = { "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000" };
		String temp = "";
		int n = s.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				BigDecimal bd = new BigDecimal(s[i]);
				BigDecimal bd1 = new BigDecimal(s[j]);
				if (bd.compareTo(bd1) == -1) {
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}


		for (String s1 : s) {
			System.out.println(s1);
		}

	}

	

}
