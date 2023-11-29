package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerAPI;
import model.*;

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
	
	//construtor
	public TelaCriacaoJogo() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p.add(new JLabel("Nome do Jogador:"));
		p.add(nomeJogador);
		
		p.add(cb);
		
		//adiciona jogador, verificando se as condições são válidas
		p.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModelAPI mod = ModelAPI.getModelAPI();
				if (mod.existPlayerColor(cb.getSelectedIndex()))
					JOptionPane.showMessageDialog(p, "Já existe um jogador dessa cor.", getTitle(), JOptionPane.ERROR_MESSAGE);
				else {
					mod.addPlayer(nomeJogador.getText(), cb.getSelectedIndex());
					JOptionPane.showMessageDialog(p, "Jogador adicionado.", getTitle(), JOptionPane.INFORMATION_MESSAGE);
				}
				nomeJogador.setText("");
			}
		});
		
		//inicia um jogo, abrinndo a tela de tabuleiro
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAPI ctrl = ControllerAPI.getControllerAPI();
				if(ctrl.startGame()) {
					ViewAPI.getViewAPI().openTabuleiro();
					dispose();
				}
			}
		});
		
		
		getContentPane().add(p);
	}

}
