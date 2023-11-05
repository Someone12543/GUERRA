package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class CriacaoJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CriacaoJogo() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(0, 1, 0, 150));
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
	}
}
