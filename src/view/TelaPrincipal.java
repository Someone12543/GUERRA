package view;

import javax.swing.*;
import java.awt.event.*;

class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // não sei o que é isso
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JButton b1 = new JButton("Novo Jogo");
	JButton b2 = new JButton("Carregar Jogo");
	Principal p = new Principal();
	
	public TelaPrincipal() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.add(b1);
		b1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										TelaCriacaoJogo tcj = new TelaCriacaoJogo();
										tcj.setTitle("WAR");
										tcj.setVisible(true);
									}
							});
		
		p.add(b2);
		// adicionar listener de carregar jogo (depois de implementar save)
		
		getContentPane().add(p);
	}
	
}
