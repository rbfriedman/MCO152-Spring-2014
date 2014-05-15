package friedman.mtaMap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.List;

import javax.swing.JPanel;

public class MapofRoutes extends JPanel {
	private Routes routes;
	private Trips trips;
	private Shapes shapes;
	private double minLong;
	private double maxLong;
	private double maxLat;
	private double minLat;
	private Point2D.Double[] points;

	public MapofRoutes() throws Exception {
		this.routes = new Routes();
		this.trips = new Trips();
		this.shapes = new Shapes();
		this.getCoordinateInformation();
		// this.getPoints();
	}

	private void getCoordinateInformation() {
		minLong = 200;
		maxLong = -200;
		maxLat = -200;
		minLat = 200;
		for (Shape s : shapes.getShapes()) {
			if (s.getLattitude() > maxLat) {
				maxLat = s.getLattitude();
			} else if (s.getLattitude() < minLat) {
				minLat = s.getLattitude();
			}

			if (s.getLongitude() > maxLong) {
				maxLong = s.getLongitude();
			} else if (s.getLongitude() < minLong) {
				minLong = s.getLongitude();
			}

		}
		/*
		 * System.out.println(minLong + " " + maxLong + " " + maxLat + " " +
		 * minLat);
		 */
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		/*
		 * System.out.println("Trips" +this.trips.getTrips().size()
		 * +"\n Shapes " + this.shapes.getShapes().size() + "\n Routes " +
		 * this.routes.getRoutes().size());
		 * System.out.println(this.routes.getRoutes().size());
		 */

		for (Route r : this.routes.getRoutes()) {
			// Trip t = this.trips.getTrips().get(1000);

			g2.setColor(r.getColor());

			if (trips.getTrip(r.getRouteId()) != null) {

				List<Shape> shapesList = shapes.getShapes(trips.getTrip(
						r.getRouteId()).getShapeId());
				Path2D.Double path = getPath(shapesList);

				// System.out.println(r.getRouteId() + " "+ ++count);
				g2.draw(path);

			} else {
				System.out.println("Null: " + r.getRouteId());
			}
		}

	}

	private java.awt.geom.Path2D.Double getPath(List<Shape> shapesList) {
		// TODO Auto-generated method stub

		Path2D.Double path = new Path2D.Double();
		double pixelX = (((shapesList.get(0).getLongitude() - minLong) / (maxLong - minLong)) * getHeight());
		double pixelY = (((shapesList.get(0).getLattitude() - minLat) / (maxLat - minLat)) * getWidth());
		path.moveTo(pixelX, pixelY);

		for (int i = 0; i < shapesList.size(); i++) {
			pixelX = (((shapesList.get(i).getLongitude() - minLong) / (maxLong - minLong)) * getHeight());
			// System.out.println(shapesList.get(i).getLongitude() + " "
			// + shapesList.get(i).getLattitude());
			pixelY = (((shapesList.get(i).getLattitude() - minLat) / (maxLat - minLat)) * getWidth());
			// System.out.println(pixelX + " " + pixelY);
			path.lineTo(pixelX, pixelY);

		}
		return path;
	}

}