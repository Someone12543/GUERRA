package view;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControllerAPI;

class TelaTabuleiro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 953;
	public final int ALT_DEFAULT = 735;
	JButton b1;
	JButton b2;
	ImageIcon nextAction, rollDices;
	Tabuleiro t = new Tabuleiro();
	ControllerAPI controller = ControllerAPI.getControllerAPI();
	
	public TelaTabuleiro() {
		try {
			nextAction = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnProxJogada.png")));
			rollDices = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnJogarDados.png")));
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		b1 = new JButton(rollDices);
		b2 = new JButton(nextAction);
		
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		t.add(b1);
		b1.setMargin(new Insets(0,0,0,0));
		b1.setContentAreaFilled(false);
		b1.setBorder(null);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (controller.getTurno()) {
					case 0:
						TelaPosicionar tp = new TelaPosicionar();
						//tp.setTitle("POSICIONAR!");
						//tp.setVisible(true);
						break;
					case 1:
						TelaAtaque ta = new TelaAtaque();
						ta.setTitle("ATAQUE!");
						ta.setVisible(true);
						break;
					case 2:
						TelaMovimentar tm = new TelaMovimentar();
						//tm.setTitle("ATAQUE!");
						//tm.setVisible(true);
						break;
				}
				
					
			}
		});
		
		t.add(b2);
		b2.setMargin(new Insets(0,0,0,0));
		b2.setContentAreaFilled(false);
		b2.setBorder(null);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.nextAction();
			}
		});
		
		getContentPane().add(t);
	}

	@Override
	public void dispose() {
		controller.endGame();
		super.dispose();
	}
}
