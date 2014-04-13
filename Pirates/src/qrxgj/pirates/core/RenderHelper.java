package qrxgj.pirates.core;

import java.awt.Graphics;

public class RenderHelper {
	private RenderHelper() {
		System.err.println("YOU SHOULDN'T BE MAKING RENDERHELPER OBJECTS!");
	}
	
	public static void drawCircle(Graphics g, int x1, int y1, int w, int h) {
		g.drawOval(x1, y1, w, h);
	}
}
