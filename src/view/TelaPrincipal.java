package view;

import java.awt.Color;

import javax.swing.*;

class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // não sei o que é isso
	public final int LARG_DEFAULT = 1200;
	public final int ALT_DEFAULT = 700;
	JButton b1 = new JButton("Novo Jogo");
	JButton b2 = new JButton("Carregar Jogo");
	JPanel p = new JPanel();
	
	public TelaPrincipal() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.add(b1);
		p.add(b2);
		p.setBackground(Color.gray);
		getContentPane().add(p);
	}
	
}
