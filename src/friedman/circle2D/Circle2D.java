package friedman.circle2D;

public class Circle2D {
	private double x;
	private double y;
	private double radius;


	public Circle2D() {
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public Circle2D(int xLoc, int yLoc, int radius) {
		this.x = xLoc;
		this.y = yLoc;
		this.radius = radius;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getArea() {
		return Math.PI *this.radius * this.radius;
	}

	public double getPerimeter() {
		return Math.PI * 2 * this.radius;
	}


	private double getDistance(Circle2D b) {
		return Math.sqrt((b.x - this.x)*(b.x - this.x) + (b.y - this.y)*(b.y - this.y));
	}

	public boolean contains(int x, int y) {
		// returns the distance between the center and the point < radius
		// if more than the radius, this point is external
		return Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * y - this.y) < this.radius;
	}

	public boolean contains(Circle2D circle) {
		// point must be contained
		// distnace between radii
		return this.getDistance(circle) + circle.radius < this.radius;
	}

	public boolean overlaps(Circle2D circle) {
		return (this.radius + circle.radius) > getDistance(circle);
	}

	public double getRadius() {
		// TODO Auto-generated method stub
		return this.radius;
	}
}
