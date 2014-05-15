package friedman.mtaMap;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main() throws Exception{
		MapofRoutes map = new MapofRoutes();
		add(map);
		this.setTitle("Map");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) throws Exception{
		Main main = new Main();
		
		
	}
}
