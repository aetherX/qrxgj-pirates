package qrxgj.pirates.core;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {
	private static final long serialVersionUID = -2218555690097957235L;
	
	public final int GWIDTH = 700;
	public final int GHEIGHT = 500;
	
	@Override
	public void paint(Graphics g) {
		RenderHelper.drawCircle(g, 10, 10, 10, 10);
	}
}
