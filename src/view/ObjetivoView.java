package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

class ObjetivoView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	
	//Criação do painel do objetivo, recebendo a sua imagem como parâmetro
	public ObjetivoView(Image img) {
		this.img = img;
	}
	
	//Re-implementação do método paintComponent
	//Desenha a imagem do objetivo
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		g2d.drawImage(img, 0, 0, 380, 618, null);
	}
}
