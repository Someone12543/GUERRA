package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Posicionar extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//Criação do painel de posicionar
	public Posicionar() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(0, 1, 0, 50));
	}
}
