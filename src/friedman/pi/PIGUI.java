package friedman.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PIGUI extends JFrame implements Runnable, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6251517502061074598L;
	private JTextArea area = new JTextArea();
	public PIGUI() {
		// TODO Auto-generated constructor stub
		/*
		 * Main ends, GUI continues running
		 * ????
		 * real job of UI thread is to handle what you as the user does with UI
		 * -when I move my mouse cursor over a button, button becomes highlighted
		 * 
		 * UI thread becomes busy/hangs
		 * 
		 * Why doesn't setText work?
		 * No thread can continue until actionperformed finsihes
		 */
	
		
		JButton jbStart = new JButton("Start");
		add(area,BorderLayout.CENTER);
		add(jbStart,BorderLayout.SOUTH);
		jbStart.addActionListener(this);
		
		this.setTitle("PI Finder");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void run(){
		double pi=0;
		for(int i =1; i <1000000000;i++){
			
				pi += 4*Math.pow(-1,i+1) /(2*i -1);
			
			area.setText(String.valueOf(pi));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		add(area);
		Thread t = new Thread(this);
		t.start();
	}
	
	public static void main(String[] args){
		PIGUI m = new PIGUI();
	}

}
