package view;

import java.awt.Image;

import javax.swing.JFrame;

import model.ModelAPI;

class TelaCartas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 650;
	public final int ALT_DEFAULT = 395;
	Cartas c;
	
	public TelaCartas() {
		setSize(LARG_DEFAULT, ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Image[] imgs = ModelAPI.getModelAPI().getCardImages();
		c = new Cartas(imgs);
		
		getContentPane().add(c);
	}
}
