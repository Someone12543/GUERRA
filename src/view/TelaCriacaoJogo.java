package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class TelaCriacaoJogo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JButton b1 = new JButton("Adicionar novo jogador");
	JButton b2 = new JButton("Iniciar Jogo");
	JTextField nomeJogador = new JTextField();
	String[] cores = {"Amarelo", "Azul", "Branco", "Verde", "Vermelho", "Preto"};
	JComboBox<String> cb = new JComboBox<String>(cores);
	CriacaoJogo p = new CriacaoJogo();
	
	public TelaCriacaoJogo() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p.add(nomeJogador);
		p.add(cb);
		
		p.add(b1);
		
		
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTabuleiro tt = new TelaTabuleiro();
				tt.setTitle("WAR");
				tt.setVisible(true);
				dispose();
			}
		});
		
		getContentPane().add(p);
	}

}