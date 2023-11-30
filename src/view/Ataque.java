package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Ataque extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//Cria um painel para a tela de ataque
	public Ataque() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(0, 1, 0, 50));
	}
}
