package friedman.clock;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;

public class Clock extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3659982896242722241L;
	private ClockPanel clockPanel;
	private Thread t;
	
	public Clock() {
		
		clockPanel = new ClockPanel();
		add(clockPanel);
		t = new Thread(this);
		t.start();
		this.setTitle("Clock");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(350,350));
	}
	
	


	@Override
	public void run() {
		while(true){
		try{
			
			repaint();
			t.sleep(1000);
		}catch(InterruptedException e){
			
			
		}
		}
		
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		Clock a = new Clock();
	}

}
