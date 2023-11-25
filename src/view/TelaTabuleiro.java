package view;

import javax.swing.JFrame;

import controller.ControllerAPI;

class TelaTabuleiro extends JFrame {
	/**
	 * 
	 */
	
	static TelaTabuleiro instance;
	private static final long serialVersionUID = 1L;
	public final int LARG_DEFAULT = 1040;
	public final int ALT_DEFAULT = 700;
	Tabuleiro t = new Tabuleiro();
	
	private TelaTabuleiro() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		getContentPane().add(t);
	}
	
	public static TelaTabuleiro getTelaTabuleiro() {
		if(instance == null)
			instance = new TelaTabuleiro();
		return instance;
	}

	@Override
	public void dispose() {
		ControllerAPI.getControllerAPI().endGame();
		super.dispose();
	}
}
