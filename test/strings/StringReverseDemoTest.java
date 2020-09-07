package strings;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
public class StringReverseDemoTest {
	StringReverseDemo demo;

	@BeforeEach
	public void setUp() {
		demo = new StringReverseDemo();
	}

	@DisplayName("Should pass a non-null message to our test method")
	@ParameterizedTest
	@ValueSource(strings = { "test", "test1" })
	public void testReverse(String input) {
		String reversed = demo.reverse(input);
		assertNotNull(reversed);

	}

	@DisplayName("Should pass reverse expected String")
	@ParameterizedTest
	@ValueSource(strings = { "Sony is going to introduce Internet TV soon" })
	public void testReverse1(String message) {
		String expected = "noos VT tenretnI ecudortni ot gniog si ynoS";
		String actual = demo.reverse(message);
		assertEquals(expected, actual);
	}
	
}
