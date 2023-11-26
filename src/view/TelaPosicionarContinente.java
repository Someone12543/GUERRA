package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ModelAPI;

public class TelaPosicionarContinente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JComboBox<String> cb1;
	JTextField quantidade = new JTextField();
	JButton b1 = new JButton("Cancelar posicionamento");
	JButton b2 = new JButton("Confirmar posicionamento");
	JButton temp;
	Posicionar p = new Posicionar();
	ModelAPI mod;
	String[] terrs;
	
	public TelaPosicionarContinente(TelaPosicionar tp) {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mod = ModelAPI.getModelAPI();
		
		terrs = mod.getCurrPlayerTerr();
		
		Collator collator = Collator.getInstance();
		
		collator.setStrength(Collator.PRIMARY);
		Arrays.sort(terrs, collator);
		
		cb1 = new JComboBox<String>(terrs);
		
		p.add(cb1);
		
		p.add(quantidade);
		
		
		
		p.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setVisible(true);
				dispose();
			}
		});
		
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qtd;
				
				try {
					qtd = Integer.valueOf(quantidade.getText());
					if (!mod.positionTroops(cb1.getSelectedItem().toString(), qtd, true)) {
						JOptionPane.showMessageDialog(p, "Número inválido", getTitle(), JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(p, "Somente números interios são aceitos.", getTitle(), JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		getContentPane().add(p);
	}
	
}