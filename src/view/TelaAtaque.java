package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.ModelAPI;

public class TelaAtaque extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JComboBox<String> cb1;
	JComboBox<String> cb2 = new JComboBox<String>();
	JButton b1 = new JButton("Cancelar ataque");
	JButton b2 = new JButton("Confirmar ataque");
	JButton temp;
	Ataque a = new Ataque();
	Dados d = new Dados();
	ModelAPI mod;
	String[] terrs;
	
	public TelaAtaque() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mod = ModelAPI.getModelAPI();
		
		terrs = mod.getCurrPlayerTerr();
		
		Collator collator = Collator.getInstance();
		
		collator.setStrength(Collator.PRIMARY);
		Arrays.sort(terrs, collator);
		
		cb1 = new JComboBox<String>(terrs);

		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
					Arrays.sort(terrs, collator);
					
					update(cb2);
				}
				catch (NullPointerException np){
					return;
				}
			}
		});
		
		terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
		
		Arrays.sort(terrs, collator);
		
		for (String s : terrs) {
			cb2.addItem(s);
		}
		
		a.add(new JLabel("País de origem:"));
		a.add(cb1);
		
		a.add(new JLabel("País de destino:"));
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
				String temp1 = cb1.getSelectedItem().toString();
				String temp2 = cb2.getSelectedItem().toString();
				
				if (!mod.attackTerritory(temp1, temp2)) {
					JOptionPane.showMessageDialog(a, "Combinação de países incompatível.", getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				
//				for (ImageIcon im : mod.getAtkImages()) {
//					temp = new JButton(im);
//					d.add(temp);
//				}
//				for (ImageIcon im : mod.getDefImages()) {
//					temp = new JButton(im);
//					d.add(temp);
//				}
				
				terrs = mod.getCurrPlayerTerr();
				Arrays.sort(terrs, collator);
				
				update(cb1);
				cb1.setSelectedItem(temp1);
				cb2.setSelectedItem(temp2);
			}
		});
		
		getContentPane().add(a);
	}
	
	private void update(JComboBox<String> c) {
		
		c.removeAllItems();
		
		for (String s : terrs) {
			c.addItem(s);
		}
		
		return;
	}
}
