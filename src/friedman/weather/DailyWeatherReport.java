package friedman.weather;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyWeatherReport {

	private Main main;
	private String dt_txt;
	private long dt;

	private Calendar date;
	
	public Main getMain() {
		return main;
	}
	public Calendar getDate() throws ParseException {
		// TODO Auto-generated method stub
		date = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String newDt_txt =dt_txt.replaceAll("-", "/");
		date.setTime(df.parse(newDt_txt));
		return date;
	}
	
}
