package qrxgj.pirates.main;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

import qrxgj.pirates.core.GameCanvas;

public class Main {
	public static final int GWIDTH = 300;
	public static final int GHEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameCanvas game = new GameCanvas(GWIDTH, GHEIGHT);
		
		window.add(game);
		window.setSize(GWIDTH, GHEIGHT);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(
				((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - (window.getWidth() / 2), 
				((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - (window.getHeight() / 2));
	}
}
