package qrxgj.pirates.main;

import javax.swing.JFrame;

import qrxgj.pirates.core.GameCanvas;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		GameCanvas game = new GameCanvas();
		
		window.add(game);
		window.setSize(game.GWIDTH, game.GHEIGHT);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
