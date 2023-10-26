package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class CriacaoJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CriacaoJogo() {
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
	}
}
