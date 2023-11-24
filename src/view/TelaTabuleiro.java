package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControllerAPI;

class TelaTabuleiro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 1200;
	public final int ALT_DEFAULT = 700;
	Tabuleiro t = new Tabuleiro();
	
	public TelaTabuleiro() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

		JButton proxJog = new JButton(t.nextAction);
		JButton jogaDad = new JButton(t.rollDices);
		JButton saveGam = new JButton();
		
		proxJog.setMargin(new Insets(0,0,0,0));
		proxJog.setContentAreaFilled(false);
		proxJog.setBorder(null);
		proxJog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ControllerAPI.getControllerAPI().nextAction();
			}
		});
		
		jogaDad.setMargin(new Insets(0,0,0,0));
		jogaDad.setContentAreaFilled(false);
		jogaDad.setBorder(null);
		jogaDad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ControllerAPI.getControllerAPI().attack();
			}
		});
		
		saveGam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerAPI.getControllerAPI().saveGame();
				} catch (IOException err) {
					JOptionPane.showMessageDialog(t, "Não foi possível salvar o jogo.", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		t.add(saveGam);
		t.add(jogaDad);
		t.add(proxJog);
		
		getContentPane().add(t);
	}

	@Override
	public void dispose() {
		ControllerAPI.getControllerAPI().endGame();
		super.dispose();
	}
}
