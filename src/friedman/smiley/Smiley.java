package friedman.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Smiley extends JComponent{
	
	
	protected void paintComponent(Graphics g){
		g.fillOval(350, 350, 15, 15);
		g.fillOval(450, 350, 15, 15);
		g.setColor(Color.YELLOW);
		g.fillArc(300, 400, 200, 200, 0, -180);
	}
	
}
