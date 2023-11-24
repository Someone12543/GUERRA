package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ControllerAPI;

import java.awt.event.*;
import java.io.IOException;
import java.io.File;

class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // não sei o que é isso
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	JButton b1 = new JButton("Novo Jogo");
	JButton b2 = new JButton("Carregar Jogo");
	Principal p = new Principal();
	JFileChooser chooser = new JFileChooser(new File("/Documents/WAR-SaveFiles/"));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("War saved game", "war");
    
	
	public TelaPrincipal() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		chooser.setFileFilter(filter);
		
		p.add(b1);
		b1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										TelaCriacaoJogo tcj = new TelaCriacaoJogo();
										tcj.setTitle("WAR");
										tcj.setVisible(true);
									}
							});
		
		p.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser.showOpenDialog(p);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			       try {
			    	   ControllerAPI.getControllerAPI().loadGame(chooser.getSelectedFile());
			       } catch (IOException err) { 
			    	   System.out.println(err.getMessage());
			       }
			    }
			}
		});
		// adicionar listener de carregar jogo (depois de implementar save)
		
		getContentPane().add(p);
	}
	
}
