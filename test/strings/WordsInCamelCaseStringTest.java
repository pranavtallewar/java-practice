package strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Pass the method parameters provided by the @ValueSource annotation")
public class WordsInCamelCaseStringTest {


	@DisplayName("geeksForGeeks-Expected-3")
	@ParameterizedTest
	@ValueSource(strings = { "geeksForGeeks"})
	public void testReverse(String input) {
		int actual = WordsInCamelCaseString.camelcase(input);
		assertEquals(actual, 3);

	}

	@DisplayName("iGotAnInternInGeeksForGeeks-Expected-8")
	@ParameterizedTest
	@ValueSource(strings = { "iGotAnInternInGeeksForGeeks" })
	public void testReverse1(String message) {
		int actual = WordsInCamelCaseString.camelcase(message);
		assertEquals(actual, actual);
	}
	
}
