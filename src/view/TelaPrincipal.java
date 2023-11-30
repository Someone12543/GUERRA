package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ControllerAPI;

import java.awt.event.*;
import java.io.IOException;

class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // não sei o que é isso
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 682 - (!System.getProperty("os.name").equals("Windows 10")? 32 : 0);
	JButton b1 = new JButton("Novo Jogo");
	JButton b2 = new JButton("Carregar Jogo");
	Principal p = new Principal();
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("War saved game", "war");
    
	//construtor
	public TelaPrincipal() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		chooser.setFileFilter(filter);
		
		//inicia um jogo novo, instanciando uma nova tela de criação de jogo
		p.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriacaoJogo tcj = new TelaCriacaoJogo();
				tcj.setTitle("WAR");
				tcj.setVisible(true);
			}
		});
		
		//carrega um jogo, produrando um arquivo com o formato correto
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser.showOpenDialog(p);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			       try {
			   		   ViewAPI.getViewAPI().tt = TelaTabuleiro.getTelaTabuleiro();
			    	   ControllerAPI.getControllerAPI().loadGame(chooser.getSelectedFile());
			       } catch (IOException err) { 
			    	   System.out.println(err.getMessage());
			       }
			    }
			}
		});
		
		getContentPane().add(p);
	}
	
}
