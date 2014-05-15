package friedman.mtaMap;

public class Shape {
	private String shapeId;
	private double lattitude;
	private double longitude;

	public Shape(String shapeId, double lattitude, double longitude) {
		this.shapeId = shapeId;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLattitude() {
		return lattitude;
	}

	public double getLongitude() {
		return longitude;
	}

}
