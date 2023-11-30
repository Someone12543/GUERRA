package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import model.ModelAPI;

class TelaCartas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 850;
	public final int ALT_DEFAULT = 400;
	Cartas c;
	JButton trocar;
	JCheckBox[] cards = new JCheckBox[5];
	int[] selectedIndex = new int[3];
	int qtd = 0;
	
	//consttrutor
	public TelaCartas() {
		setSize(LARG_DEFAULT, ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//recupera as cartas de ModelAPI
		String[] names = ModelAPI.getModelAPI().getCardNames();
		Image[] imgs = ModelAPI.getModelAPI().getCardImages();
		c = new Cartas(imgs);
		
		//checkbox de seleção
		int i = 0;
		ItemListener handler = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					qtd--;
					if (qtd < 3) {
						trocar.setEnabled(false);
					}
				}
				else {
					qtd++;
					if (qtd == 3) {
						trocar.setEnabled(true);
					}
					else if (qtd > 3){
						qtd--;
						JCheckBox selected = (JCheckBox) e.getSource();
						selected.removeItemListener(this);
						selected.setSelected(false);
						selected.addItemListener(this);
					}
				}
			}
		};
		
		//adiciona um checkbox para cada carta
		for (String name : names) {
			cards[i] = new JCheckBox(name);
			cards[i].addItemListener(handler);		
			c.add(cards[i]);
			i++;
		}
		
		//valida e confirma a troca
		c.add(trocar);
		trocar = new JButton("Trocar");
		trocar.setEnabled(false);
		trocar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0, j = 0;
				for (JCheckBox cb : cards) {
					if (cb == null)
						continue;
					
					if (cb.isSelected()) {
						selectedIndex[i++] = j;
					}
					
					j++;
				}
				
				if (ModelAPI.getModelAPI().performTrade(selectedIndex))
					dispose();
			}
		});

		getContentPane().add(c);
	}
}
