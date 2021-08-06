package tomtom;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BinaryToZeroCount {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=399999; i++) {
			sb.append(1);
		}
		//int res = new BinaryToZeroCount().solution_simple(sb.toString());
		int res = new BinaryToZeroCount().solution_simple("1111010101111");
		System.out.println(res);

	}
	public int solution(String S) {
		BigInteger number = convertStringToBinary(S);
		int count = 0;
		while (number.compareTo(BigInteger.ZERO) != 0) {
			if (number.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
				number = number.divide(new BigInteger("2"));
			} else {
				number = number.subtract(new BigInteger("1"));
			}
			count++;
		}
		return count;
	}

	private BigInteger convertStringToBinary(String s) {
		BigDecimal sum = new BigDecimal("0");
		BigDecimal base = new BigDecimal(2);
		BigDecimal temp;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				int exponent = s.length() - 1 - i;
				temp = base.pow(exponent);
				sum = sum.add(temp);
			}

		}
		return sum.toBigInteger();
	}
	// Submitted
	public static int solution_simple(String S) {
		int firstOneAt = S.indexOf("1");
		return firstOneAt == -1 ? 0 : S.replace("0", "").length() + S.length() - firstOneAt - 1;
	}
}
