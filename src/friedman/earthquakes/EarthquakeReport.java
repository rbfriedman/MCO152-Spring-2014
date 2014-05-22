package friedman.earthquakes;

public class EarthquakeReport {
	private String magnitude;
	private String location;
	@Override
	public String toString() {
		return magnitude + ' '+ location ;
	}
}
