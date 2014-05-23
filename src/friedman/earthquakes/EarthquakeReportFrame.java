package friedman.earthquakes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class EarthquakeReportFrame extends JFrame {

	/**
	 * This class displays earthquake information in a JList
	 */
	private static final long serialVersionUID = 6736946374486938900L;
	private JList<String> jlEarthquakes;

	public EarthquakeReportFrame() {
		this.jlEarthquakes = new JList<String>();
		//MyListCellRenderer cellRenderer = new MyListCellRenderer();
		this.jlEarthquakes.setCellRenderer(new MyListCellRenderer());
		add(this.jlEarthquakes);
		EarthquakeReportThread myThread = new EarthquakeReportThread(this);
		myThread.start();
		// general JFrame settings
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void loadEarthquakeInfo(EarthquakeReportList earthquakeReportList) {
		int sizeOfList = earthquakeReportList.size();
		String[] jlistArr = new String[sizeOfList];
		for (int i = 0; i < sizeOfList; i++) {
			jlistArr[i] = earthquakeReportList.get(i).toString();

		}
		
		this.jlEarthquakes.setListData(jlistArr);

		this.setVisible(true);
	}

}
