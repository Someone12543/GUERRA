package view;

import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.ModelAPI;

class TelaPosicionar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JComboBox<String> cb1;
	JTextField quantidade = new JTextField();
	JButton b0 = new JButton("Posicionar exércitos de continentes");
	JButton b1 = new JButton("Cancelar posicionamento");
	JButton b2 = new JButton("Confirmar posicionamento");
	JLabel posicionar, posicionarCont;
	Posicionar p = new Posicionar();
	ModelAPI mod;
	ArrayList<String> terrs;
	TelaPosicionar self;
	TelaPosicionarContinente tpc;
	
	//construtor
	public TelaPosicionar() {
		self = this;
		tpc = new TelaPosicionarContinente(self);
		
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mod = ModelAPI.getModelAPI();
		
		terrs = mod.getCurrPlayerTerr(false);
		
		Collections.sort(terrs, new Comparator<String>() {
		    @Override
		    public int compare(String o1, String o2) {
		        o1 = Normalizer.normalize(o1, Normalizer.Form.NFD);
		        o2 = Normalizer.normalize(o2, Normalizer.Form.NFD);
		        return o1.compareTo(o2);
		    }
		});
		
		//lista inicial de territórios para posicionar tropas
		String[] temp = new String[terrs.size()];
		terrs.toArray(temp);
		cb1 = new JComboBox<String>(temp);
	
		p.add(new JLabel("País a posicionar:"));
		p.add(cb1);
		
		Integer[] troops = mod.getTroopsPos();
		
		//instancia a label de posicionar tropas de continentes em seu estado inicial
		posicionarCont = new JLabel("<html>Tropas de continentes a posicionar: "
			+ sumInteger(troops).toString()
			+ (troops[1] != 0? "<br>África: " + troops[1].toString() : "")
			+ (troops[2] != 0? "<br>América do Norte: " + troops[2].toString() : "")
			+ (troops[3] != 0? "<br>América do Sul: " + troops[3].toString() : "")
			+ (troops[4] != 0? "<br>Ásia: " + troops[4].toString() : "")
			+ (troops[5] != 0? "<br>Europa: " + troops[5].toString() : "")
			+ (troops[6] != 0? "<br>Oceania: " + troops[6].toString() : "")
			+ "</html>");
		
		posicionarCont.setMinimumSize(new Dimension(100, 200));
		
		p.add(posicionarCont);
		
		//instancia a label de posicionar tropas genéricas em seu estado inicial
		posicionar = new JLabel("Tropas a posicionar: " + mod.getTroopsPos()[0].toString());
		
		p.add(posicionar);
		p.add(quantidade);
		
		//abre a tela de posicionar tropas por continente e torna essa tela invisível
		p.add(b0);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tpc.isDisplayable()) {
					tpc = new TelaPosicionarContinente(self);
					tpc.setTitle("POSICIONAR EM CONTINENTE!");
					tpc.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		//fecha a tela
		p.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//tenta realizar um posicionamento no território selecionado e atualizar a label,
		//tratando NumberFormatException
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qtd;
				
				try {
					qtd = Integer.valueOf(quantidade.getText());
					if (!mod.positionTroops(cb1.getSelectedItem().toString(), qtd, false)) {
						JOptionPane.showMessageDialog(p, "Número inválido", getTitle(), JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					posicionar.setText("Tropas a posicionar: " + mod.getTroopsPos()[0].toString());
				}
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(p, "Somente números inteiros são aceitos.", getTitle(), JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		getContentPane().add(p);
	}
	
	//override feito para fechar telas extras
	@Override
	public void dispose() {
		if (tpc.isActive()) {
			tpc.dispose();
		}
		super.dispose();
	}
	
	//override feito por conta de problemas com a atualização do label de tropas a posicionar em continentes
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (!b) return;
		Integer[] troops = mod.getTroopsPos();
		posicionarCont.setText("<html>Tropas de continentes a posicionar: "
				+ sumInteger(troops).toString()
				+ (troops[1] != 0? "<br>África: " + troops[1].toString() : "")
				+ (troops[2] != 0? "<br>América do Norte: " + troops[2].toString() : "")
				+ (troops[3] != 0? "<br>América do Sul: " + troops[3].toString() : "")
				+ (troops[4] != 0? "<br>Ásia: " + troops[4].toString() : "")
				+ (troops[5] != 0? "<br>Europa: " + troops[5].toString() : "")
				+ (troops[6] != 0? "<br>Oceania: " + troops[6].toString() : "")
				+ "</html>");
	}
	
	//método auxiliar que retorna a soma de um array de inteiros
	private Integer sumInteger(Integer[] ints) {
		Integer temp = 0;
		
		for (int i = 1; i < 7; i++) {
			temp += ints[i];
		}
		
		return temp;
	}
}
