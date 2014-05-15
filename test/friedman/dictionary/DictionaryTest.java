package friedman.dictionary;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import friedman.dictionary.Dictionary;

public class DictionaryTest {
private Dictionary aDictionary;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUpperCase() throws FileNotFoundException {
		aDictionary = new Dictionary();
		assertTrue(aDictionary.exists("NURL"));
		assertTrue(aDictionary.exists("NURL"));
		assertTrue(aDictionary.exists("NUNS"));
		assertTrue(aDictionary.exists("IMPRISONMENTS"));
		assertTrue(aDictionary.exists("ZOOGEOGRAPHICAL"));
	}
	@Test
	public void testMixedCase() throws FileNotFoundException{
		aDictionary = new Dictionary();
		
		assertTrue(aDictionary.exists("SIXTieth"));
		assertTrue(aDictionary.exists("UNiSEX"));
	}
	@Test
	public void testLowerCase() throws FileNotFoundException{
		aDictionary = new Dictionary();
		
		assertTrue(aDictionary.exists("inattentively"));
		assertTrue(aDictionary.exists("ae"));
		assertTrue(aDictionary.exists("ad"));
		
		
	}
	@Test
	public void testNonDictWords() throws FileNotFoundException{
		aDictionary = new Dictionary();
		
		assertFalse(aDictionary.exists("ZOOGEOLLLL"));
		assertFalse(aDictionary.exists("OGEOLLLL"));
		assertFalse(aDictionary.exists("ZOOLLLL"));
		assertFalse(aDictionary.exists("AOGEOLLLL"));
		assertFalse(aDictionary.exists("APPPP"));
		
		
		
	}
	@Test
	public void testNulls() throws FileNotFoundException{
		aDictionary = new Dictionary();
		assertFalse(aDictionary.exists("  "));
		assertFalse(aDictionary.exists(null));
	}
		
	

}
