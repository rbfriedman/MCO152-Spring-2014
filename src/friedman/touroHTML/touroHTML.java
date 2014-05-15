package friedman.touroHTML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class touroHTML {

	public touroHTML() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("http://www.touro.edu/students");
		
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		/*
		 * With reader class I can now print html to the creen
		 */
		
		String line;
		while((line = reader.readLine())!=null){
			System.out.println(line);
		}

	}

}
