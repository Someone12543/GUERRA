package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
				terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
				
				Arrays.sort(terrs, collator);
				
				cb2.removeAllItems();
				
				for (String s : terrs) {
					cb2.addItem(s);
				}
			}
		});
		
		terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
		
		Arrays.sort(terrs, collator);
		
		for (String s : terrs) {
			cb2.addItem(s);
		}
		
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
				if (!mod.attackTerritory(cb1.getSelectedItem().toString(), cb2.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(a, "Combinação de países incompatível.", getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				for (ImageIcon im : mod.getAtkImages()) {
					temp = new JButton(im);
					d.add(temp);
				}
				for (ImageIcon im : mod.getDefImages()) {
					temp = new JButton(im);
					d.add(temp);
				}
				
				dispose();
			}
		});
		
		getContentPane().add(a);
	}
	
}
