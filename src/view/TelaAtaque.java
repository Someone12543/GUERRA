package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	protected ArrayList<String> terrs;
	private Comparator<String> comp = new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
	        o1 = Normalizer.normalize(o1, Normalizer.Form.NFD);
	        o2 = Normalizer.normalize(o2, Normalizer.Form.NFD);
	        return o1.compareTo(o2);
	    }
	};
	
	//construtor
	public TelaAtaque() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mod = ModelAPI.getModelAPI();
		
		terrs = mod.getCurrPlayerTerr(true);
		
		Collections.sort(terrs, comp);
		
		//lista inicial de territórios de onde partir o ataque
		String[] temp = new String[terrs.size()];
		terrs.toArray(temp);
		cb1 = new JComboBox<String>(temp);
		
		
		//atualiza combobox2 com uma lista de territorios adjacentes ao selecionado
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
					Collections.sort(terrs, comp);
					
					update(cb2, terrs);
				}
				catch (NullPointerException np){
					return;
				}
			}
		});
		
		//lista inicial de territórios adjacentes ao território automaticamente selecionado
		terrs = mod.getFrontierNames(cb1.getSelectedItem().toString());
		
		Collections.sort(terrs, comp);
		
		for (String s : terrs) {
			cb2.addItem(s);
		}
		
		a.add(new JLabel("País de origem:"));
		a.add(cb1);
		
		a.add(new JLabel("País de destino:"));
		a.add(cb2);
		
		//fecha a tela
		a.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//realiza o ataque entre os territórios selecionados ao abrir a tela de dados
		a.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = cb1.getSelectedItem().toString();
				String temp2 = cb2.getSelectedItem().toString();
				
				TelaDados td = new TelaDados(temp1, temp2);
				td.setTitle(getTitle());
			}
		});
		
		getContentPane().add(a);
	}
	
	// método auxiliar para atualizar combobox facilmente
	void update(JComboBox<String> c, ArrayList<String> names) {
		
		c.removeAllItems();
		
		for (String s : names) {
			c.addItem(s);
		}
		
		return;
	}
}
