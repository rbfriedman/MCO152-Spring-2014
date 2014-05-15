package friedman.ufo;

public class PostalLocation {
	private String zip;
	private double lattitude;
	private double longitude;
	private String city;
	private String state;
	public PostalLocation(String zip, double lattitude, double longitude,
			String city, String state) {
		this.zip = zip;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "PostalLocation [zip=" + zip + ", lattitude=" + lattitude
				+ ", longitude=" + longitude + "]";
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
