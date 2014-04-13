package qrxgj.pirates.main;

import javax.swing.JFrame;

import qrxgj.pirates.core.GameCanvas;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameCanvas game = new GameCanvas(300, 200);
		
		window.add(game);
		window.setSize(300, 200);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	}
}
