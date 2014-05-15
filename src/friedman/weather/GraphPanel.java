package friedman.weather;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 247008912006365608L;
	protected ArrayList<java.lang.Double> temperatures;
	protected ArrayList<Calendar> dates;

	public void addInfo(ArrayList<java.lang.Double> temps,
			ArrayList<Calendar> dates) {
		this.temperatures = temps;
		this.dates = dates;
		System.out.println(this.temperatures.toString());

	}
}
