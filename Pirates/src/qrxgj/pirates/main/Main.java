package qrxgj.pirates.main;

import java.awt.Toolkit;

import javax.swing.JFrame;

import qrxgj.pirates.core.GameCanvas;

public class Main {
	public static final int GWIDTH = 500;
	public static final int GHEIGHT = 300;
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameCanvas game = new GameCanvas(GWIDTH - 12, GHEIGHT - 12);
		window.add(game);
		window.setSize(GWIDTH, GHEIGHT);
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(window.getInsets());
		
		window.setLocation(
				((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - (window.getWidth() / 2), 
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - (window.getHeight() / 2));
	}
}
