package friedman.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class StatisticsOfOWL {

	private Map<Character, Integer> letterStatistics;
	private Integer charCount;
	private Integer totalWords;
	private Map<Character, Integer> letterAppearances;
	private Map<Character, Boolean> hasLetterAppeared;

	public static void main(String[] args) throws FileNotFoundException {
		
		StatisticsOfOWL statisticsOfOWL = new StatisticsOfOWL();
		System.out.println(statisticsOfOWL.toString());
	}

	public StatisticsOfOWL() throws FileNotFoundException {
		// initialize values and instantiate Scanner
		Dictionary dict = new Dictionary();
		letterStatistics = new LinkedHashMap<Character, Integer>();
		letterAppearances = new LinkedHashMap<Character, Integer>();
		hasLetterAppeared = new HashMap<Character, Boolean>();
		charCount = 0;
		totalWords = 0;
		for (int i = 65; i < 91; i++) {
			letterStatistics.put(Character.valueOf((char) i), 0);
			letterAppearances.put(Character.valueOf((char) i), 0);
			hasLetterAppeared.put(Character.valueOf((char) i), false);
		}
		// Read and process text file
		Iterator<String> it = dict.iterator();
		while(it.hasNext()) {
			totalWords++;
			char[] charsInWord = it.next().toCharArray();

			for (int i = 0; i < charsInWord.length; i++) {
				letterStatistics.put(charsInWord[i],
						letterStatistics.get(charsInWord[i]) + 1);
				if (!hasLetterAppeared.get(charsInWord[i])) {
					letterAppearances.put(charsInWord[i],
							letterAppearances.get(charsInWord[i]) + 1);
					hasLetterAppeared.put(charsInWord[i], true);
				}
				charCount++;
			}
			for(Entry<Character, Boolean> c:hasLetterAppeared.entrySet()){
				c.setValue(false);
			}

		}

	}

	public void printLetterCount() {
		for (Entry<Character, Integer> m : letterStatistics.entrySet()) {
			System.out.println(m);
		}
	}

	public String toString() {
		StringBuilder statistics = new StringBuilder();
		for (Entry<Character, Integer> m : letterAppearances.entrySet()) {
			statistics.append(m.getKey()
					+ " "
					+ String.format("%7d", letterStatistics.get(m.getKey()))
					+ "  "
					+ String.format("%7s",
							percentageFormatter((double) m.getValue()
									/ totalWords)) + "\n");
		}
		return statistics.toString();
	}

	private String percentageFormatter(Double num) {
		DecimalFormat formatter = new DecimalFormat("##.00%");
		return formatter.format(num);
	}

	public Double getProprtionalOccurence(Character c) {
		return (double) (letterStatistics.get(c) / charCount);
	}

	public Integer getCharCount() {
		return charCount;
	}

	public Map<Character, Integer> getletterStatisticsMap() {
		return letterStatistics;
	}

}
