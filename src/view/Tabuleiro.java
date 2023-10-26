package view;

import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Tabuleiro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image source;
	
	public Tabuleiro() {
		try {
			source = ImageIO.read(new File("assets/tabuleiro/"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(source, 0, 0, null);
	}
	
}
