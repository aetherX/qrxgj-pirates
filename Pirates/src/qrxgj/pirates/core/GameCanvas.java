package qrxgj.pirates.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.text.html.parser.Entity;

public class GameCanvas extends Canvas {
	private static final long serialVersionUID = -2218555690097957235L;
	
	//
	// IMPORTANT STUFFS!
	//
	
	boolean running;
	
	private Thread computeTh;
	private Thread renderTh;
	
	private Graphics bufferG;
	private Image bufferI;
	
	//
	//
	//
	
	public GameCanvas(int w, int h) {
	// set up the canvas and stuff
		setSize(w, h);
		setVisible(true);
		
		init();
	}
	
	private void init() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(10, 10, 25, 25);;
	}
}
