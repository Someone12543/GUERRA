package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class CriacaoJogo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Criação do painel de criar jogo
	public CriacaoJogo() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(0, 1, 0, 80));
	}
}
