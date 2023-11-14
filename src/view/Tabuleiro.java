package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ControllerAPI;
import model.ModelAPI;

class Tabuleiro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image source, bg;
	ImageIcon nextAction, rollDices;
	ArrayList<Exercito> listaExercitos;
	
	public Tabuleiro() {
		try {
			bg = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_fundo.png"));
			source = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_mapa copy.png"));
			nextAction = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnProxJogada.png")));
			rollDices = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnJogarDados.png")));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		this.listaExercitos = new ArrayList<Exercito>();
		
		listaExercitos.add(new Exercito(600, 350, 0));
		
		JButton proxJog = new JButton(nextAction);
		JButton jogaDad = new JButton(rollDices);
		
		proxJog.setMargin(new Insets(0,0,0,0));
		proxJog.setContentAreaFilled(false);
		proxJog.setBorder(null);
		proxJog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerAPI.getControllerAPI().nextAction();
			}
		});
		
		jogaDad.setMargin(new Insets(0,0,0,0));
		jogaDad.setContentAreaFilled(false);
		jogaDad.setBorder(null);
		jogaDad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ControllerAPI.getControllerAPI().attack();
			}
		});
		
		add(jogaDad);
		add(proxJog);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bg, 0, 0, 1185, 660, null);
		g2d.drawImage(source, 0, 0, 1185, 660,null);
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		for (Exercito e : listaExercitos) {
			switch(e.color) {
			case 0:
				g2d.setPaint(Color.YELLOW);
				break;
			case 1:
				g2d.setPaint(Color.BLUE);
				break;
			case 2:
				g2d.setPaint(Color.WHITE);
				break;
			case 3:
				g2d.setPaint(Color.GREEN);
				break;
			case 4:
				g2d.setPaint(Color.RED);
				break;
			case 5:
				g2d.setPaint(Color.BLACK);
				break;
			default:
				g2d.setPaint(Color.GRAY);
			}
			g2d.fill(e.elip);			
			
			g2d.setPaint(Color.DARK_GRAY);
			g2d.draw(e.elip);
			
			if (e.color != 5)
				g2d.setPaint(Color.BLACK);
			else
				g2d.setPaint(Color.WHITE);
			
			g2d.drawString(Integer.toString(e.number), e.x + e.w/2 - 5, e.y + e.h/2 + 8); //esse -5 e + 8 foi no olhômetro
		}
	}
	
}
