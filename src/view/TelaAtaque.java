package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.ModelAPI;

class TelaAtaque extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public int LARG_DEFAULT = 395;
	public int ALT_DEFAULT = 650;
	protected JComboBox<String> cb1;
	protected JComboBox<String> cb2 = new JComboBox<String>();
	private JButton b1 = new JButton("Cancelar ataque");
	private JButton b2 = new JButton("Confirmar ataque");
	private Ataque a = new Ataque();
	private ModelAPI mod;
	protected String[] terrs;
	
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
					
					update(cb2, terrs);
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
				
				TelaDados td = new TelaDados(temp1, temp2, cb1, cb2);
				td.setTitle(getTitle());
			}
		});
		
		getContentPane().add(a);
	}
	
	void update(JComboBox<String> c, String[] names) {
		
		c.removeAllItems();
		
		for (String s : names) {
			c.addItem(s);
		}
		
		return;
	}
}
