package view;

import java.awt.Image;
import javax.swing.JFrame;

import model.ModelAPI;

class TelaObjetivo extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 395;
	public final int ALT_DEFAULT = 650;
	Image img;
	ObjetivoView objv;
	
	//construtor
	public TelaObjetivo() {
		img = ModelAPI.getModelAPI().getObjectiveImage();
		
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//abre tela que mostra carta do objetivo do jogador
		objv = new ObjetivoView(img);
		
		getContentPane().add(objv);
	}
}
