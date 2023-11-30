package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Dados extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//Criação do painel de dados
	public Dados() {
		setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		setLayout(new GridLayout(2, 3, 30, 20));
	}
}