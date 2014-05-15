package friedman.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

public class WeeklyConditions {
	
	@SerializedName("cod")
	private String code;
	private int cnt;
	private String dt;
	private String id;
	private Weather[] weather;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=London,uk");

		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();

		WeeklyConditions cond = gson.fromJson(reader, WeeklyConditions.class);
	}

}
