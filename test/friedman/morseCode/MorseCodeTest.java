package friedman.morseCode;

import org.junit.Assert;
import org.junit.Test;

import friedman.morseCode.MorseCode;

public class MorseCodeTest {
	private MorseCode morseCode = new MorseCode();
	private String code;
	private String expected;

	public MorseCode getMorseCode() {
		return morseCode;
	}

	public String getCode() {
		return code;
	}

	public String getExpected() {
		return expected;
	}

	@Test
	public void testAlphabetToMorseCode() {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		code = morseCode.toMorseCode(alphabet);
		expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testGreenToMorseCode() {
		String green = "green";
		code = morseCode.toMorseCode(green);

		Assert.assertEquals("--. .-. . . -.", code);

	}

	@Test
	public void Lagavulin() {
		String wierdSeq = "Lagavulin 93 456h";
		code = morseCode.toMorseCode(wierdSeq);
		Assert.assertEquals(
				".-.. .- --. .- ...- ..- .-.. .. -. / ----. ...-- / ....- ..... -.... ....",
				code);
		Assert.assertEquals(
				wierdSeq.toUpperCase(),
				morseCode
						.toPlainText(".-.. .- --. .- ...- ..- .-.. .. -. / ----. ...-- / ....- ..... -.... ...."));
	}
	@Test
	public void emptyString(){
		String nullString ="";
		code = morseCode.toMorseCode(nullString);
		expected ="";
		Assert.assertEquals(expected, code);
	}
	@Test
	public void otherString(){
		String aString ="Josh and Sam 34";
		code = morseCode.toMorseCode(aString);
		expected =morseCode.toPlainText(code);
		Assert.assertEquals(expected, aString.toUpperCase());
	}
	

}
