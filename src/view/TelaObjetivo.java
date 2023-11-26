package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
	ObjetivoView objv = new ObjetivoView();
	Image img;
	
	public TelaObjetivo() {
		ModelAPI.getModelAPI();
		
		
		getContentPane().add(objv);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponents(g);
		g2d.drawImage(img, 0, 0, 147, 225, null);
	}
	
}
