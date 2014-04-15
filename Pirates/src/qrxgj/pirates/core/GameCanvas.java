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
	
	public int fiftySix;
	//
	//
	//
	
	Random r;
	EntityDisco disco;
	
	/**
	 * Sets up the canvas.
	 * 
	 * @param w - Width of desired canvas
	 * @param h - Height of desired canvas
	 */
	public GameCanvas(int w, int h) {
	// set up the canvas and stuff
		setPreferredSize(new Dimension(w, h));
		setVisible(true);
		setBackground(Color.BLACK);
		
		System.out.println(getHeight() + " " + getWidth());
		
	// important core stuff should go in init!
		init();
	}
	
	/**
	 * Initial method.
	 */
	private void init() {
		r = new Random();
		disco = new EntityDisco(100);
		
		running = true;
		
		renderTh = new Thread(new Runnable() {
			@Override
			public void run(){
				try{ Thread.sleep(50); } catch(Exception ex) { } // problem seemed to be: repainting too fast, need to let
																 // running = true work or something? unsure.
				while(running) {
					repaint();
				}
			}
		});
		
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
		renderTh.start();
	}
	
	/**
	 * Applies the rendered image to this canvas with double buffer.
	 * 
	 * @param g - the specified Graphics context
	 */
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
	
	/**
	 * Updates this canvas.
	 * <p>
	 * This method is called in response to a call to repaint. Updates this canvas by calling paint.
	 */
	@Override
	public void update(Graphics g){
	// THIS IS IMPORTANT!
	// update(g) is called upon repaint().
	// if it is not overridden, it will first flush the screen, then paint everything.
	// this creates flickering.
		paint(g);
	}
	
	/**
	 * Renders an image on this canvas.
	 * 
	 * @param g - the specified Graphics context
	 */
	private void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		disco.renderTo(g);
	}
}
