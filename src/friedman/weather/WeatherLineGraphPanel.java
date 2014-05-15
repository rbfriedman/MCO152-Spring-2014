package friedman.weather;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.Random;


public class WeatherLineGraphPanel extends 
		GraphPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8196869097614451895L;
	

	public WeatherLineGraphPanel() {
		setPreferredSize(new Dimension(400, 300));
	}
	
	
	protected void paintComponent(Graphics g) {
		final int HEIGHT = getHeight() - 20;
		final int WIDTH = getWidth() - 20;
		final int graphOriginX = 100;
		//Scales the y values to a y axis of 100
		double scalingFactor = (HEIGHT - 10) / 100.0;
		// Axes
		g.drawLine(graphOriginX, 10, 100, HEIGHT);
		g.drawLine(graphOriginX, HEIGHT, WIDTH, HEIGHT);
		// Labels
		g.drawString("Temperature", 5, HEIGHT / 2);
		g.drawString("Day", WIDTH / 2, HEIGHT+10 );
		// TickMarks for Temperatures
		Graphics2D g2 = (Graphics2D) g;

		for (double i = HEIGHT - HEIGHT / 10; i > 10; i -= HEIGHT / 10) {
			g2.draw(new Line2D.Double(graphOriginX, i, graphOriginX + 2.0, i));

		}
		if(temperatures!=null && dates!=null){
		// Tickmarks for the days
		int dateCount = 1;
		for (double i = graphOriginX + WIDTH / dates.size(); dateCount < dates
				.size() && i < WIDTH; i += WIDTH / dates.size(), dateCount++) {
			if (dates.get(dateCount).get(Calendar.DAY_OF_MONTH) > dates.get(
					dateCount - 1).get(Calendar.DAY_OF_MONTH)) {
				g2.draw(new Line2D.Double(i, HEIGHT, i, HEIGHT - 2));

			}
		}
		//The x tickMarks increments by a consistent WIDTH/temps.size()
		//The y tickMark changes in slope according to the difference in temps
		double tickLocation = graphOriginX;

		g2.setColor(getRandomColor());
		
		double tickMarkerY = 0;
		//PreviousPoint wll be our first point and the first value of the line being drawn
		Point2D.Double previousPoint = new Point2D.Double(tickLocation,
				tickMarkerY += (HEIGHT - (temperatures.get(0) * scalingFactor)));

		Point2D.Double currentPoint = previousPoint;
		for (int i = 1; i < temperatures.size(); i++) {
			tickMarkerY -=  (temperatures.get(i) - temperatures.get(i - 1))
					* scalingFactor;
			
			currentPoint = new Point2D.Double(tickLocation += WIDTH
					/ temperatures.size(), tickMarkerY);
			// Reset the color when the day changes
			if (dates.get(i).get(Calendar.DAY_OF_MONTH) > dates.get(i - 1).get(
					Calendar.DAY_OF_MONTH)) {
				g2.setColor(getRandomColor());

			}
			g2.draw(new Line2D.Double(previousPoint, currentPoint));
			System.out.println(previousPoint.toString() +  " "
					+ temperatures.get(i));
			previousPoint = currentPoint;

		}
		}
	}

	private Color getRandomColor() {
		// TODO Auto-generated method stub
		Random gen = new Random();

		return new Color(gen.nextInt(200), gen.nextInt(200), gen.nextInt(200));
	}

}
