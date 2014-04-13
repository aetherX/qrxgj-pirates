package qrxgj.pirates.entity;

import java.awt.Color;
import java.awt.Graphics;

import qrxgj.pirates.core.Renderable;
import qrxgj.pirates.main.Main;

public class EntityDisco extends Entity implements Renderable {
	int pos;
	int time;
	int w, h;
	
	public EntityDisco(int ww, int hh) {
		pos = 0;
		time = 0;
		w = ww; h = hh;
	}
	
	@Override
	public void renderTo(Graphics g) {
		switch(pos) {
		case 0:
			g.setColor(Color.BLUE);
			g.fillOval(((Main.GWIDTH / 5) * 1) - (w / 2), (Main.GHEIGHT / 2) - (h / 2), w, h);
			break;
		case 1:
			g.setColor(Color.RED);
			g.fillOval(((Main.GWIDTH / 5) * 2) - (w / 2), (Main.GHEIGHT / 2) - (h / 2), w, h);
			break;
		case 2:
			g.setColor(Color.YELLOW);
			g.fillOval(((Main.GWIDTH / 5) * 3) - (w / 2), (Main.GHEIGHT / 2) - (h / 2), w, h);
			break;
		case 3:
			g.setColor(Color.GREEN);
			g.fillOval(((Main.GWIDTH / 5) * 4) - (w / 2), (Main.GHEIGHT / 2) - (h / 2), w, h);
			break;
		}
	}

	@Override
	public void compute() {
		// count the amount of time elapsed.
		time++;
		
		// if the time in seconds is over 1 second
		if((time / 20) > 1) {
			// increase "pos", change state
			pos++;
			// and reset the timer
			time = 0;
		}
		
		if(pos > 3) {
			// there is no state higher than 4, so if it is 4 revert to 0
			pos = 0;
		}
	}
}
