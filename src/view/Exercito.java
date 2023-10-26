package view;

import java.awt.geom.Ellipse2D;

class Exercito {
	Ellipse2D inner, outter;
	int number, color;
	float x, y;
	
	public Exercito(float pos_x, float pos_y) {
		this.x = pos_x;
		this.y = pos_y;
		this.inner = new Ellipse2D.Double(x, y, 5, 5);
		this.outter = new Ellipse2D.Double(x, y, 5, 5);
		this.number = 1;
	}
	
	
}
