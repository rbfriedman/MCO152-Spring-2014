package friedman.weather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class WeeklyWeatherFrame extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2328544424204424251L;
	private JTextField jtfLocation;
	private JPanel jpContainer;
	private WeatherLineGraphPanel graph;
	private JPanel jpQuery;
	private JPanel jpQueryContainer;
	private JPanel jpGraph;
	private JPanel jpButton;
	private JButton jbEnter;
	private String url = "http://api.openweathermap.org/data/2.5/forecast?q=";
	private String newURL;

	public WeeklyWeatherFrame() {
		jpContainer = new JPanel();
		graph = new WeatherLineGraphPanel();
		jpContainer.setLayout(new BoxLayout(jpContainer, BoxLayout.Y_AXIS));
		// Panel for the query
		jpQuery = new JPanel();
		// Panel holding the query and button
		jpQueryContainer = new JPanel();
		// Panel holding the graph
		jpGraph = new JPanel();
		// Instantiating query fields
		JLabel jlbLocation = new JLabel("Enter a location");
		jtfLocation = new JTextField(20);
		jbEnter = new JButton("Enter");
		jpButton = new JPanel();
		jpButton.add(jbEnter);

		jpQuery.add(jlbLocation);
		jpQuery.add(jtfLocation);

		jpQueryContainer.add(jpQuery);
		jpQueryContainer.add(jpButton);

		jpQueryContainer.setMinimumSize(new Dimension(400, 100));
		jpGraph.setMinimumSize(new Dimension(400, 300));
		jpContainer.add(jpQueryContainer);

		
		jpContainer.add(graph);
		add(jpContainer);
		jbEnter.addActionListener(new ButtonListener(this));
		setMinimumSize(new Dimension(450,500));
		this.setTitle("Weather Graph");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	@Override
	public void run() {
		try {
			URL url = new URL(this.newURL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new Gson();
			ArrayList<Double> temps = new ArrayList<Double>();
			ArrayList<Calendar> dates = new ArrayList<Calendar>();

			WeeklyConditions wc = gson.fromJson(reader, WeeklyConditions.class);
			if (wc.getCode().equals("404")) {
				add(new JLabel("An error occured while parsing the JSON"));
			} else {
				System.out.println("JSON printout:\n" + gson.toJson(wc));

				for (DailyWeatherReport dwr : wc.getDwr()) {

					temps.add(dwr.getMain().getTempF());
					try {
						dates.add(dwr.getDate());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				graph.addInfo(temps,dates);
				repaint();
				

			}
		} catch (MalformedURLException e) {
			add(new JLabel("Malformed URL"), BorderLayout.SOUTH);
		} catch (IOException e) {
			add(new JLabel("Invalid URL Connection"), BorderLayout.SOUTH);
		}

	}

	private class ButtonListener implements ActionListener {
		private WeeklyWeatherFrame wwf;

		public ButtonListener(WeeklyWeatherFrame wwf) {
			this.wwf = wwf;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String location = jtfLocation.getText();

			location.replaceAll(" ", "+");

			newURL = url + location;
			Thread thread = new Thread(wwf);
			thread.start();

		}

	}

}
