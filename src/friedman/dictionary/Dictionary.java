package friedman.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
	private File file;

	// private Map<String,String> aMap = new HashMap<String,String>();
	private Map<String,String> map;

	
	public Dictionary() throws FileNotFoundException {
		Long seconds =System.currentTimeMillis();
		this.file = new File("OWL.txt");

		String definition;
		String word,def;
		Scanner read = new Scanner(this.file);

		map = new HashMap<String,String>();
		while (read.hasNextLine()) {
			word = read.next();
			def = read.nextLine();
			map.put(word,def);
		}
		System.out.println(System.currentTimeMillis()-seconds);

	}
	public File getFile(){
		return this.file;
	}
	
	public Iterator<String> iterator(){
		return map.keySet().iterator();
	}
	public boolean exists(String aWord){
		
		return map.containsKey(aWord.trim().toUpperCase());
	}
	public Map<String,String> getDictionaryList() {
		return map;
	}
	
	public String getDefinition(String word){
		return map.get(word);
	}
		
}
