package friedman.mtaMap;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {
	private List<Shape> shapes;

	public Shapes() throws Exception {
		this.shapes = this.readShapes();
	}

	public List<Shape> getShapes() {
		return this.shapes;
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> shapesList = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (s.getShapeId().equals(shapeId)) {
				shapesList.add(s);
			}
		}
		return shapesList;
	}

	private List<Shape> readShapes() throws Exception {
		CSVReader csvRead = new CSVReader(new FileReader("shapes.txt"));
		List<String[]> rawShapes = csvRead.readAll();
		rawShapes.remove(0);
		List<Shape> shapesList = new ArrayList<Shape>();
		Shape shape = null;
		for (String[] s : rawShapes) {
			shape = new Shape(s[0], Double.valueOf(s[1]), Double.valueOf(s[2]));
			shapesList.add(shape);
		}
		csvRead.close();
		return shapesList;
	}

	public List<Shape> getIndividualShapes() {
		List<Shape> shapesList = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (!shapesList.contains(s)) {
				shapesList.add(s);
			}
		}
		return shapesList;
	}

}
