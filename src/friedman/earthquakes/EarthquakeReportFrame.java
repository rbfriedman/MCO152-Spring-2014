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
		MyListCellRenderer cellRenderer = new MyListCellRenderer();
		this.jlEarthquakes.setCellRenderer(cellRenderer);
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
		MyListCellRenderer cellRenderer = new MyListCellRenderer();
		this.jlEarthquakes.setCellRenderer(cellRenderer);
		this.jlEarthquakes.setListData(jlistArr);
		this.jlEarthquakes.setBackground(Color.cyan);

		this.setVisible(true);
	}

	class MyListCellRenderer extends JLabel implements ListCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5507811426864727444L;

		@Override
		public Component getListCellRendererComponent(JList jlist, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			// TODO Auto-generated method stub
			   setText(value.toString());
			   
				 switch(Integer.valueOf(((String)value).substring(0))) {
				 case 1 :
					 this.setBackground(new Color(25,25,112));
					 break;
				 case 2:
					 this.setBackground(Color.BLUE);
					 break;
				 case 3:
					 this.setBackground(new Color(65,164,35));
					 break;
				 case 4:
					 this.setBackground(new Color(69,168,182));
					 break;
				 case 5:
					 this.setBackground(new Color(85,242,106));
					 break;
				 case 6:
					 this.setBackground(Color.YELLOW);
					 break;
				 case 7:
					 this.setBackground(Color.ORANGE);
					 break;
				 case 8:
					 this.setBackground(new Color(226,123,97));
					 break;
				 case 9:
					 this.setBackground(Color.red);
					 break;
				 case 10:
					 this.setBackground(new Color(183,24,12));
					 break;
					 
				 }
			   
		        
		      

		        return this;
		}
	}
}
