package friedman.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class ListSightings {
	public static void main(String[] args) throws JsonIOException,
			JsonSyntaxException, IOException {

		Gson gson = new Gson();
		final FileReader reader = new FileReader("ufo_awesome.json");
		final Sightings list = gson.fromJson(reader, Sightings.class);
		
		Map<String,List<Sighting>> map = new HashMap<>();
		
		for(Sighting s: list){
			String location = s.getLocation();
			List<Sighting> sightings = map.get(location);
			if(sightings == null){
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);
			}
		System.out.println(list.size());
		//PostalLocations locations = new PostalLocations();
		for(int i=0; i <list.size();i++){
			final Sighting s = list.get(i);
			if ("19950115".equals(s.getSightedAt())) {
				System.out.println(s);
			}
			
		}
		
	
		
	

	}
}
