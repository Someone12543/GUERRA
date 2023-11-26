package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

class Cartas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image[] imgs;
	
	public Cartas(Image[] imgs) {
		this.imgs = imgs;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);

		int i = 0;
		for (Image img : imgs) {
			g2d.drawImage(img, 0 + (i * 150), 100, 130, 200, null);
			i++;
		}
	}
}
