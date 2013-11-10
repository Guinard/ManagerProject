package common.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public MainFrame(){
		super();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(900,600));
	}
	
	public void paint(Graphics g) {
	    Dimension d = this.getPreferredSize();
	    
	  }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame test=new MainFrame();

	}

}
