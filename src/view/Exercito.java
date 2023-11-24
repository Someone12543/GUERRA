package view;

import java.awt.geom.Ellipse2D;

class Exercito {
	Ellipse2D elip;
	int number, color;
	float x, y, w = 20.0f, h = 20.0f;
	
	public Exercito(float pos_x, float pos_y, int color) {
		this.x = pos_x;
		this.y = pos_y;
		this.elip = new Ellipse2D.Double(x, y, w, h);
		this.color = color;
		this.number = 1;
	}
	
	
}
