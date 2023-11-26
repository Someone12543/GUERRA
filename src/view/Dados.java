package view;

import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Dados extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public Dados() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(2, 3, 30, 20));
	}
	
	public void paintComponent(Graphics g) {
		//Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
	}
}