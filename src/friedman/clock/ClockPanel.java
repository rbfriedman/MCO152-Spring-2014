package friedman.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	private int hours;
	private int minute;
	private int seconds;
	private int minutes;
	private double scaleFace =1.05;
	private int scaleHeight ;
	private final int X = 0;
	private final int Y = 1;

	protected void paintComponent(Graphics g) {
		// This is a resizable clock//
		scaleHeight =(int)getHeight()/6;
		int WIDTH = getWidth();
		int HEIGHT = getHeight() - scaleHeight;
		
		double[] CENTER = { WIDTH / 2, HEIGHT / 2 + scaleHeight/2 };

		minutes = (int) Math.floor(System.currentTimeMillis() / (1000 * 60)
				% 60);
		hours = (int) Math.floor(System.currentTimeMillis() / (1000 * 60 * 60)
				% 12);
		seconds = (int) Math.floor(System.currentTimeMillis() / 1000);
		//hourRadians,minRadians, and secRadians measure the number of radians between the hand and its origin (0 degress)
		double hourRadians = (Math.PI * 2 * hours / 12);
		double minRadians = (Math.PI * 2 * minutes / 60);
		double secRadians = (Math.PI * 2 * seconds / 60);

		double armLength = HEIGHT / 2;
		//Drawing the clock face
		Path2D.Double path = new Path2D.Double();
		path.moveTo(
				(CENTER[X] + Math.cos(Math.PI * 2 - .5 * Math.PI) * armLength),
				(float) (CENTER[Y] + (float) Math.sin(Math.PI * 2 - .5
						* Math.PI *scaleFace)
						*armLength* scaleFace));
		for (int i = 1; i < 360; i++) {
			path.lineTo(
					(CENTER[X] + Math.cos(Math.PI * 2 * i / 360 - .5 * Math.PI *scaleFace)
							 *armLength* scaleFace),
					(float) (CENTER[Y] + (float) Math.sin(Math.PI * 2 * i / 360
							- .5 * Math.PI * scaleFace)
							 *armLength* scaleFace));
		}
		Graphics2D g2D = (Graphics2D) g;
		g2D.draw(path);
		double hourMarker, minuteMarker;
		for (int i = 1; i < 13; i++) {
			hourMarker = Math.PI * 2 * i / 12;

			g2D.drawString(
					String.valueOf(i),
					(float) (CENTER[X] + Math.cos(hourMarker - .5 * Math.PI)
							*  armLength),
					(float) (CENTER[Y] + (float) Math.sin(hourMarker - .5
							* Math.PI)
							* armLength)) ;
		}
		for (int i = 1; i < 60; i++) {
			if (i % 5 == 0) {
				continue;
			}
			minuteMarker = Math.PI * 2 * i / 60;

			g2D.drawString(
					"-",
					(float) (CENTER[X] + Math.cos(minuteMarker - .5 * Math.PI)
							* (armLength)),
					(float) (CENTER[Y] + (float) Math.sin(minuteMarker - .5
							* Math.PI)
							* ( armLength)));

		}
		//Hour hand
		g2D.setColor(Color.BLUE);
		g2D.draw(new Line2D.Double(CENTER[X], CENTER[Y], CENTER[X]
				+ Math.cos(hourRadians + Math.PI/2) * armLength, CENTER[Y]
				+ Math.sin(hourRadians +  Math.PI/2)* armLength));
		//Min hand
		g2D.draw(new Line2D.Double(CENTER[X], CENTER[Y], CENTER[X]
				+ Math.cos(minRadians - .5 * Math.PI) * armLength, CENTER[Y]
				+ Math.sin(minRadians - .5 * Math.PI) * armLength));
		//Second hand
		g2D.draw(new Line2D.Double(CENTER[X], CENTER[Y], CENTER[X]
				+ Math.cos(secRadians -.5* Math.PI) * armLength, CENTER[Y]
				+ Math.sin(secRadians -.5* Math.PI) * armLength));
		
	}
	
	

}
