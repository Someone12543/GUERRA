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
import javax.swing.JTextField;

import model.ModelAPI;

public class TelaMovimentar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JComboBox<String> cb1;
	JComboBox<String> cb2 = new JComboBox<String>();
	JTextField quantidade = new JTextField();
	JButton b1 = new JButton("Cancelar movimento");
	JButton b2 = new JButton("Confirmar movimento");
	Movimentar m = new Movimentar();
	ModelAPI mod;
	String[] terrs;
	
	public TelaMovimentar() {
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
		
		m.add(new JLabel("País de origem:"));
		m.add(cb1);
		
		m.add(new JLabel("País de destino:"));
		m.add(cb2);
		
		m.add(new JLabel("Tropas a movimentar:"));
		m.add(quantidade);
		
		m.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		m.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qtd;
				
				try {
					qtd = Integer.valueOf(quantidade.getText());
					if (!mod.moveTroops(cb1.getSelectedItem().toString(), cb2.getSelectedItem().toString(), qtd)) {
						JOptionPane.showMessageDialog(m, "Número inválido.", getTitle(), JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(m, "Somente números interios são aceitos.", getTitle(), JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		getContentPane().add(m);
	}
	
}