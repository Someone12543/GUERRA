package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.ModelAPI;

class TelaDados extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 400;
	public final int ALT_DEFAULT = 300;
	String orig, dest;
	Integer[] atk, def;
	Dados d = new Dados();
	JButton[] dadoAtq = new JButton[3];
	JButton[] dadoDef = new JButton[3];
	JButton atacar;
	ModelAPI mod = ModelAPI.getModelAPI();
	
	public TelaDados(String orig, String dest) {
		setSize(LARG_DEFAULT, ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		atacar = new JButton("Finalizar ataque");
		atacar.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!mod.attackTerritory(orig, dest, atk, def)) {
					JOptionPane.showMessageDialog(d, "Combinação de países incompatível.", getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
					dispose();
			}
		});
		
		int[] troopQtd = mod.getTroopQtds(orig, dest);
		
		atk = mod.throwDices(troopQtd[0]);
		def = mod.throwDices(troopQtd[1]);
		
		for (int q = 0; q <= atk.length; q++) {
			if (q == atk.length) {
				JOptionPane.showMessageDialog(d, "Não há tropas suficientes", getTitle(), JOptionPane.ERROR_MESSAGE);
				dispose();
				break;
			}
			if (atk[q] != 0)
				break;
		}
		
		int i = 0;
		for (Integer j : atk) {
			dadoAtq[i] = new JButton(mod.getAtkImage(j));
			dadoAtq[i].setMargin(new Insets(0,0,0,0));
			dadoAtq[i].setContentAreaFilled(false);
			dadoAtq[i].setBorder(null);
			dadoAtq[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					
					source.setIcon(mod.getAtkImage(source.getIcon()));
					
					int ind = 0;
					for (JButton but : dadoAtq) {
						if (but == source)
							break;
						ind++;
					}
					
					atk[ind] = atk[ind] == 6 ? 0 : atk[ind] + 1;
				}
			});
			
			if(j == 0)
				dadoAtq[i].setEnabled(false);
			
			d.add(dadoAtq[i]);
			i++;
		}
		
		i = 0;
		for (Integer j : def) {
			dadoDef[i] = new JButton(mod.getDefImage(j));
			dadoDef[i].setMargin(new Insets(0,0,0,0));
			dadoDef[i].setContentAreaFilled(false);
			dadoDef[i].setBorder(null);
			dadoDef[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					
					source.setIcon(mod.getDefImage(source.getIcon()));
					
					int ind = 0;
					for (JButton but : dadoDef) {
						if (but == source)
							break;
						ind++;
					}
					
					def[ind] = def[ind] == 6 ? 0 : def[ind] + 1;
				}
			});
			
			if (j == 0) 
				dadoDef[i].setEnabled(false);
			
			d.add(dadoDef[i]);
			i++;
		}
		
		d.add(atacar);
		
		getContentPane().add(d);
	}

}
