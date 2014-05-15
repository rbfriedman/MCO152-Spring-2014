package friedman.weather;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

public class WeatherBarGraphPanel extends GraphPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2693686850105729117L;
	private ArrayList<java.lang.Double> temperatures;
	private ArrayList<Calendar> dates;

	public WeatherBarGraphPanel() {

		setPreferredSize(new Dimension(400, 300));
	}

	protected void paintComponent(Graphics g) {

		final int HEIGHT = getHeight() - 20;
		final int WIDTH = getWidth() - 20;
		final int graphOriginX = 100;
		double scalingFactor = (HEIGHT - 10) / 100.0;

		// Axes
		g.drawLine(graphOriginX, 10, 100, HEIGHT);
		g.drawLine(graphOriginX, HEIGHT, WIDTH, HEIGHT);
		// Labels
		g.drawString("Temperature", 5, HEIGHT / 2);
		g.drawString("Day", WIDTH / 2, HEIGHT - 10);
		// TickMarks
		/*
		 * To improve the precision of our graph, points will be drawn using
		 * doubles
		 */
		for (int i = HEIGHT - HEIGHT / 10; i > 10; i -= HEIGHT / 10) {
			g.drawLine(graphOriginX, i, graphOriginX + 2, i);

		}
		if (temperatures != null && dates != null) {
			for (int i = graphOriginX + WIDTH / dates.size(), dateCount = 1; dateCount < dates
					.size() && i < WIDTH; i += WIDTH / dates.size(), dateCount++) {
				if (dates.get(dateCount).get(Calendar.DAY_OF_MONTH) > dates
						.get(dateCount - 1).get(Calendar.DAY_OF_MONTH)) {
					g.drawLine(i, HEIGHT, i, HEIGHT - 2);

				}
			}
			int tickLocation = graphOriginX + 1 - WIDTH / temperatures.size();
			int widthOfBar = WIDTH / temperatures.size();
			g.setColor(getRandomColor());

			for (int i = 0; i < temperatures.size(); i++) {

				g.setColor(getRandomColor());

				g.fill3DRect(tickLocation += widthOfBar, HEIGHT
						- (int) (temperatures.get(i) * scalingFactor), WIDTH
						/ temperatures.size(),
						(int) (temperatures.get(i) * scalingFactor), true);

				g.setColor(getBackground());
				g.drawString(
						((int) Math.floor(temperatures.get(i)) + ""),
						tickLocation,
						HEIGHT
								- (int) (temperatures.get(i) / 2 * scalingFactor));

			}
		}
	}

	private Color getRandomColor() {
		// TODO Auto-generated method stub
		Random gen = new Random();

		return new Color(gen.nextInt(200), gen.nextInt(200), gen.nextInt(200));
	}

}
