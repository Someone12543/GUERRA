package view;

import java.awt.geom.Ellipse2D;

class Exercito {
	Ellipse2D inner, outter;
	int number, color;
	float x, y, w = 35.0f, h = 35.0f;
	
	public Exercito(float pos_x, float pos_y, int color) {
		this.x = pos_x;
		this.y = pos_y;
		this.inner = new Ellipse2D.Double(x, y, w, h);
		this.outter = new Ellipse2D.Double(x, y, w, h);
		this.color = color;
		this.number = 1;
	}
	
	
}
