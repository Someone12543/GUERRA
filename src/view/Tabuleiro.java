package view;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Tabuleiro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image source, bg;
	ArrayList<Exercito> listaExercitos;
	
	public Tabuleiro() {
		try {
			bg = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_fundo.png"));
			source = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_mapa copy.png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		this.listaExercitos = new ArrayList<Exercito>();
		listaExercitos.add(new Exercito(600, 350, 0));
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bg, 0, 0, 1185, 660, null);
		g2d.drawImage(source, 0, 0, 1185, 660,null);
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		for (Exercito e : listaExercitos) {
			switch(e.color) {
			case 0:
				g2d.setPaint(Color.YELLOW);
				break;
			case 1:
				g2d.setPaint(Color.BLUE);
				break;
			case 2:
				g2d.setPaint(Color.WHITE);
				break;
			case 3:
				g2d.setPaint(Color.GREEN);
				break;
			case 4:
				g2d.setPaint(Color.RED);
				break;
			case 5:
				g2d.setPaint(Color.BLACK);
				break;
			default:
				g2d.setPaint(Color.GRAY);
			}
			g2d.fill(e.inner);			
			
			g2d.setPaint(Color.DARK_GRAY);
			g2d.draw(e.outter);
			
			if (e.color != 5)
				g2d.setPaint(Color.BLACK);
			else
				g2d.setPaint(Color.WHITE);
			
			g2d.drawString(Integer.toString(e.number), e.x + e.w/2 - 5, e.y + e.h/2 + 8); //esse -5 e + 8 foi no olhômetro
		}
	}
	
}
