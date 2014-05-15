package friedman.conditions;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConditionsGUI extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1212880740040255333L;
	private JTextField jtfCitySearch;
	private JLabel jlbCitySearch;
	private String urlString = "http://api.openweathermap.org/data/2.5/weather?q=";
	private JTextPane jtpInfo = new JTextPane();
	private JButton jb;
	private JPanel pane;

	public ConditionsGUI() {

		jb = new JButton("See Weather");
		jtfCitySearch = new JTextField();
		jlbCitySearch = new JLabel("Type a city name");

		pane = new JPanel();
		pane.setLayout(new GridLayout(1, 3));
		this.setLayout(new BorderLayout());
		add(jtpInfo, BorderLayout.CENTER);
		pane.add(jlbCitySearch);
		pane.add(jtfCitySearch);
		pane.add(jb);
		add(pane, BorderLayout.SOUTH);
		this.setTitle("Weather");
		this.setLocationRelativeTo(null);

		this.setSize(350, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.addActionListener(new WeatherListener(this)); 

	}
		

	public static void main(String[] args) {
		ConditionsGUI cond = new ConditionsGUI();
		cond.setVisible(true);
	}
	private class WeatherListener implements ActionListener{
		ConditionsGUI gui;
		public WeatherListener(ConditionsGUI gui){
			this.gui = gui;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Thread thread = new Thread(gui);
			thread.start();

			

		}
	}
	@Override
	public void run() {
		String queryString = jtfCitySearch.getText();
		queryString.replaceAll(" ", "+");

		String urlStringWithQuery = urlString + queryString;

		System.out.println(urlString + " " + urlStringWithQuery);
		// From creating to URL until json should be done in its own
		// Thread

		
		try {
			URL url = new URL(urlStringWithQuery);
			URLConnection connection = url.openConnection();
			InputStream in=connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			Conditions cond = gson.fromJson(reader, Conditions.class);
			Gson formatter = new GsonBuilder().setPrettyPrinting().create();
			String jsonOutput = formatter.toJson(cond);
			if(jsonOutput.contains("404") ){
				add(new JLabel("This page does not exist on the net"),BorderLayout.NORTH);
				//revalidate();
			}else{
				jtpInfo.setText(jsonOutput);
			}
			

			repaint();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			add(new JLabel("Malformed URL"),BorderLayout.NORTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			add(new JLabel("Invalid URL Connection"),BorderLayout.NORTH);
		}
		
		

		
	
		
	}

}

