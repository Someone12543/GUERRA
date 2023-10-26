package view;

import javax.swing.JFrame;

class TelaTabuleiro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 1200;
	public final int ALT_DEFAULT = 700;
	Tabuleiro t = new Tabuleiro();
	
	public TelaTabuleiro() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().add(t);
	}

	@Override
	public void dispose() {
		// implementar save
		super.dispose();
	}
}
