package qrxgj.pirates.entity;

import java.awt.Color;
import java.awt.Graphics;

import qrxgj.pirates.core.Renderable;
import qrxgj.pirates.main.Main;

public class EntityDisco extends Entity implements Renderable {
	int pos;
	int sz, x;
	
	public EntityDisco(int szz) {
		pos = 0;
		sz = szz;
		x = 10;
	}
	
	@Override
	public void renderTo(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(x - (sz / 2), 100 - (sz / 2), sz, sz);
	}

	@Override
	public void compute() {
		x += 10;
		
		if(x > 490){
			x = 10;
		}
	}
}
