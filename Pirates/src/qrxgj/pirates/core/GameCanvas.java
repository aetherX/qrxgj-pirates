package qrxgj.pirates.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import qrxgj.pirates.entity.EntityDisco;

public class GameCanvas extends Canvas {
	private static final long serialVersionUID = -2218555690097957235L;
	
	//
	// IMPORTANT STUFFS!
	//
	
	// game things
	
	public boolean running;
	
	private Thread computeTh;
	private Thread renderTh;
	
	private Graphics bufferG;
	private BufferedImage bufferI;
//	private BufferStrategy bufferS;
	
	//
	//
	//
	
	Random r;
	EntityDisco disco;
	
	public GameCanvas(int w, int h) {
	// set up the canvas and stuff
		setSize(w, h);
		setVisible(true);
		setBackground(Color.BLACK);
		
		System.out.println(getHeight() + " " + getWidth());
		
	// important core stuff should go in init!
		init();
	}
	
	private void init() {
		r = new Random();
		disco = new EntityDisco(20, 20);
		
		running = true;
		
		renderTh = new Thread(new Runnable() {
			@Override
			public void run(){
				while(running) {
					repaint();
					try{ Thread.sleep(1); } catch(Exception ex) { }
				}
			}
		});
		
		renderTh.start();
		
		computeTh = new Thread(new Runnable() {
			@Override
			public void run(){
				while(running) {
					disco.compute();
					try { Thread.sleep(50); } catch(Exception ex) { }
				}
			}
		});
		
		computeTh.start();
	}
	
	// IT STILL FLICKERS GAHHHHHHHHHHHHHHHHHHHHHHHHHHH
	
	@Override
	public void paint(Graphics g) {
		if(		bufferI == null 						||
				bufferI.getHeight(this) != getHeight() 	||
				bufferI.getWidth(this) != getWidth()) 	{
			bufferI = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		}
		bufferG = bufferI.createGraphics();
		render(bufferG);
		g.drawImage(bufferI, 0, 0, this);
		
//		createBufferStrategy(2);
//		bufferS = getBufferStrategy();
//		
//		bufferG = bufferS.getDrawGraphics();
//		render(bufferG);
//		bufferS.show();
	}
	
	private void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		disco.renderTo(g);
	}
}
