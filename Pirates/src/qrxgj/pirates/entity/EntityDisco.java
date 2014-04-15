package qrxgj.pirates.entity;

import java.awt.Color;
import java.awt.Graphics;

import qrxgj.pirates.core.Renderable;
import qrxgj.pirates.main.Main;

public class EntityDisco extends Entity implements Renderable {
	int pos;
	int sz, x;
	boolean right = true;
	
	/**
	 * 'Disco' Entity.
	 * <p>
	 * Random ball bouncing across the screen horizontally.
	 * @param szz - diameter size
	 */
	public EntityDisco(int szz) {
		pos = 0;
		sz = szz;
		x = 10;
	}
	
	/**
	 * Entity image.
	 */
	@Override
	public void renderTo(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(x - (sz / 2), 100 - (sz / 2), sz, sz);
	}

	/**
	 * Calculates the entity position.
	 */
	@Override
	public void compute() {
		if(right) {
			x+=10;
		}else {
			x-=10;
		}
		switch(x) {
		case 50:
			right = true;
			break;
		case 450:
			right = false;
			break;
		default:
			break;
		}
	}
}
