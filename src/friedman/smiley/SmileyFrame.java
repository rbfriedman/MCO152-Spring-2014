package friedman.smiley;

import javax.swing.JFrame;

public class SmileyFrame extends JFrame{
	public SmileyFrame(){
		Smiley a = new Smiley();
		add(a);
		this.setTitle("Smiley");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args){
		SmileyFrame a = new SmileyFrame();
		
	}
}
