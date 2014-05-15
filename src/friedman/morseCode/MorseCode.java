package friedman.morseCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MorseCode {
	private String[] alphabetCode = { ".-", "-...", "-.-.", "-..", ".", "..-.",
			"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
			".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--.." };
	private Map<String,String> cipher;
	private String[] digits = { "-----", ".----", "..---", "...--", "....-",
			".....", "-....", "--...", "---..", "----." };
	private final String space = "/";

	
	private StringBuilder builder;

	/**
	 * @param args
	 */
	public MorseCode(){
		cipher = new HashMap<String,String>();
		for(int i =0; i <digits.length;i++){
			cipher.put(String.valueOf(i), digits[i]);
			cipher.put( digits[i],String.valueOf(i));
		}
		for(int i =65; i <91;i++){
			cipher.put(alphabetCode[i-65],String.valueOf( (char)i));
			cipher.put(String.valueOf( (char)i), alphabetCode[i-65]);
		}
	}
	public String toPlainText(String input) {
		input = input.toUpperCase();
		String[] arrayOfStr = input.split(" ");
		builder = new StringBuilder();

		for (int i = 0; i < arrayOfStr.length; i++) {
			String currentChar = arrayOfStr[i];
			if(cipher.containsKey(currentChar)){
				builder.append(cipher.get(currentChar));
				} else {
					builder.append(" ");
				}


		}
		return builder.toString();

	}

	/*
	 * Encoding, you put a space, btwn each word, a space a slash and aspace
	 */

	public String toMorseCode(String input) {
		builder = new StringBuilder();
		input = input.toUpperCase();
		for (int i = 0; i < input.length(); i++) {
			String currentChar = String.valueOf(input.charAt(i));
			if(cipher.containsKey(currentChar)){
			builder.append(cipher.get(currentChar) + " ");
			} else {
				builder.append(this.space + " ");
			}
		}
		return builder.toString().trim();
	}

}
