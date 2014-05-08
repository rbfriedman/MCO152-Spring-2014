package friedman.tictactoe;

public class Location {
	private int x;
	private int y;

	public Location(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public Location(Location location) {
		// TODO Auto-generated constructor stub
		this(location.getX(),location.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Location l){
		return this.getX() == l.getX() && this.getY() == l.getY();
	}
	
	public String toString(){
		return this.getX() +", " + this.getY();
	}

}
