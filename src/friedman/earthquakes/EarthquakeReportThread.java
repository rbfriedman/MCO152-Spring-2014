package friedman.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class EarthquakeReportThread extends Thread {
	private static final String FEED_URL = "http://earthquake-report.com/feeds/recent-eq?json";
	private EarthquakeReportList earthquakeReportList;
	private EarthquakeReportFrame frame;

	public EarthquakeReportThread(EarthquakeReportFrame frame) {
		this.frame = frame;
	}

	public void run() {
		while (true) {
			try {

				URL url = new URL(FEED_URL);
				URLConnection connection = url.openConnection();
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				final JsonReader jsonReader = new JsonReader(reader);

				Gson gson = new Gson();
				earthquakeReportList = gson.fromJson(jsonReader,
						EarthquakeReportList.class);
				System.out.println("Earthquake Info has been read in\n"
						+ earthquakeReportList.toString());
				frame.loadEarthquakeInfo(earthquakeReportList);
				//window.refresh(quakes);
			} catch (MalformedURLException m) {
				m.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				this.sleep(60 * 1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
