package friedman.mtaMap;

import java.awt.Color;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {
	private List<Trip> trips;

	public Trips() throws Exception {
		this.trips = this.readTrips();
	}

	public List<Trip> getTrips() {
		// TODO Auto-generated method stub
		return trips;
	}
	
	public Trip getTrip(String s){
		for (Trip t: trips){
			if(t.getRouteId().equals(s)){
				return t;
			}
		}
		return null;
	}
	
	private List<Trip> readTrips() throws Exception {
		CSVReader csvRead = new CSVReader(new FileReader("trips.txt"));
		List<String[]> rawTrips = csvRead.readAll();
		rawTrips.remove(0);
		List<Trip> tripsList = new ArrayList<Trip>();
		Trip trip = null;
		for (String[] s : rawTrips) {
			if(!s[6].equals("")){
			trip = new Trip(s[2], s[0], s[6]);
			tripsList.add(trip);
			}
		}
		return tripsList;
	}
	
}
