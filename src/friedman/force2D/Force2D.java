package friedman.force2D;

public class Force2D {
	private double x;
	private double y;

	public Force2D(double d, double e) {
		this.x = d;
		this.y = e;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public Double getAngle() {
		double radians = Math.atan2(this.y, this.x);
		double angle = Math.toDegrees(radians);
		return angle;

	}

	public Force2D add(Force2D force2D) {
		return new Force2D(force2D.getX() + this.getX(), force2D.getY()
				+ this.getY());

	}

}
