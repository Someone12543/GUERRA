package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ControllerAPI;
import model.ModelAPI;

public class TelaAtaque extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JComboBox<String> cb1 = new JComboBox<String>();
	JComboBox<String> cb2 = new JComboBox<String>();
	JButton b1 = new JButton("Cancelar ataque");
	JButton b2 = new JButton("Confirmar ataque");
	Ataque a = new Ataque();
	
	public TelaAtaque() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		ModelAPI mod = ModelAPI.getModelAPI();
		
		a.add(cb1);
		a.add(cb2);
		
		a.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		a.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAPI ctrl = ControllerAPI.getControllerAPI();
				if(ctrl.startGame()) {
					TelaTabuleiro tt = new TelaTabuleiro();
					ViewAPI.getViewAPI().tt = tt;
					tt.setTitle("WAR");
					tt.setVisible(true);
					dispose();
				}
			}
		});
		
		getContentPane().add(a);
	}
	
}
