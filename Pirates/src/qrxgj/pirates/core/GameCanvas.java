package qrxgj.pirates.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
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
	
	//
	//
	//
	
	Random r;
	EntityDisco disco;
	
	public GameCanvas(int w, int h) {
	// set up the canvas and stuff
		setPreferredSize(new Dimension(w, h));
		setVisible(true);
		setBackground(Color.BLACK);
		
		System.out.println(getHeight() + " " + getWidth());
		
	// important core stuff should go in init!
		init();
	}
	
	private void init() {
		r = new Random();
		disco = new EntityDisco(20);
		
		running = true;
		
		renderTh = new Thread(new Runnable() {
			@Override
			public void run(){
				while(running) {
					repaint();
					System.out.println("repainted"); // for some reason, if there is only repaint(); in the while
													 // loop, it seems to refuse to loop more than once :(
													 // if you could solve it that would be epicsauce.
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
	
	@Override
	public void paint(Graphics g) {
		if(		bufferI == null 						|| // if the bufferI doesn't exist or is wrong
				bufferI.getHeight(this) != getHeight() 	||
				bufferI.getWidth(this) != getWidth()) 	{
			bufferI = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB); // create it
			bufferG = bufferI.createGraphics(); // create bufferG, the corresponding bufferI graphics
		}
		render(bufferG); // give the bufferG to render(g)
		g.drawImage(bufferI, 0, 0, this); // finally, paint the image
	}
	
	@Override
	public void update(Graphics g){
	// THIS IS IMPORTANT!
	// update(g) is called upon repaint().
	// if it is not overridden, it will first flush the screen, then paint everything.
	// this creates flickering.
		paint(g);
	}
	
	private void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		disco.renderTo(g);
	}
}
