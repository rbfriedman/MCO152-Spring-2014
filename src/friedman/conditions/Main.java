package friedman.conditions;

public class Main {
	private double temp;

	private double getTemp() {
		return temp;
	}

	public double getTempF() {
		return temp * 1.8 - 459.67;
	}

	public double getTempC() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
