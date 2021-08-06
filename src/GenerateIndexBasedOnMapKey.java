import java.util.Objects;

public class GenerateIndexBasedOnMapKey {

	public static void main(String[] args) {
		int hashCode = Objects.hash("vishal");
		System.out.println(hashCode);
		System.out.println(hashCode % 15);
	}

}
