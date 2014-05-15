package friedman.mtaMap;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

public class Route {
	private String routeId;
	private Color color;
	private CSVReader read;
	public Route(String routeId, Color color) throws FileNotFoundException {
		this.routeId = routeId;
		this.color = color;
		
	}
	public String getRouteId() {
		return routeId;
	}
	public Color getColor() {
		return color;
	}
	
	
}
