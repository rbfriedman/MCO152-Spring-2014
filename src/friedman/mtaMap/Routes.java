package friedman.mtaMap;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {
	private List<Route> routes;

	public Routes() throws IOException {
		this.routes = this.readRoutes();
	}

	public List<Route> getRoutes() {
		// TODO Auto-generated method stub
		return routes;
	}
	
	public Color getColor(String routeId){
		for(Route r: routes){
			if(r.getRouteId().equals(routeId)){
				return r.getColor();
			}
		}
		return null;
		
	}
	private List<Route> readRoutes() throws IOException {
		String routeFile = "routes.txt";
		CSVReader csvRead = new CSVReader(new FileReader(routeFile));
		List<String[]> rawRoutes = csvRead.readAll();
		List<Route> routesList = new ArrayList<Route>();
		rawRoutes.remove(0);
		Route route = null;
		Color color = null;
		for (String[] s : rawRoutes) {
			if(s[7].length() == 6){
			color = new Color(Integer.parseInt(s[7].substring(0, 2),16),
					Integer.parseInt(s[7].substring(2, 4),16), Integer.parseInt(s[7]
							.substring(4),16));
			route = new Route(s[0], color);
			routesList.add(route);
			}
		}
		csvRead.close();
		return routesList;
	}
	
	
	
}
