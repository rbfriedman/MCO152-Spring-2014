package friedman.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class PostalLocations {
	private List<PostalLocation> postalCodes;

	public List<PostalLocation> getPostalCodes() {
		return postalCodes;
	}

	public PostalLocations() throws IOException {
		// TODO Auto-generated constructor stub
		postalCodes =readZipFile("ZIP_CODES.txt");
	}

	public List<PostalLocation> readZipFile(String fileName) throws IOException {
		CSVReader read = new CSVReader(new FileReader(fileName));
		// List<String[]> rawPostalCodes = read.readAll();
		postalCodes = new ArrayList<PostalLocation>();
		Iterator<String[]> postalCodesIter = read.readAll().iterator();
		
		while (postalCodesIter.hasNext()) {
			String[] info = postalCodesIter.next();
			try{
			postalCodes.add(new PostalLocation(info[0],
					Double.valueOf(info[1]), Double.valueOf(info[2]), info[3],
					info[4]));
			}catch(NumberFormatException n){
				continue;
			}
		}
		return postalCodes;
	}
	
	public PostalLocation getPostalCode(String city, String state){
		city = city.toUpperCase().trim();
		state = state.toUpperCase();
		for(PostalLocation p: postalCodes){
			if(city.equals(p.getCity()) && state.equals(p.getState())){
				return p;
			}
		}
		return null;
	}

}
