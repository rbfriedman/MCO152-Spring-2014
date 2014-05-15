package friedman.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

public class WeeklyConditions {

	@SerializedName("cod")
	private String code;
	private DWRList list;

	public DWRList getDwr() {
		return list;
	}

	public String getCode() {
		return code;
	}

	public void setDwr(DWRList dwr) {
		this.list = dwr;
	}

	
}
