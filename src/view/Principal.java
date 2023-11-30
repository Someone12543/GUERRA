package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

class Principal extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image bg;
	
	//Criação do painel da tela principal
	//Carrega a imagem de fundo
	public Principal() {
		try {
			bg = ImageIO.read(new File("assets/bgconfiguracao.png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	//Re-implementação do método paintComponent
	//Desenha a imagem de fundo
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g);
		g2d.drawImage(bg, 0, 0, null);
	}
}
