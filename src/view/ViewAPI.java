package view;

import javax.swing.JOptionPane;

public class ViewAPI {
	
	public static ViewAPI instance;
	
	private ViewAPI() {
		TelaPrincipal t = new TelaPrincipal();
		t.setTitle("WAR");
		t.setVisible(true);
	}
	
	public static ViewAPI getViewAPI() {
		if (instance == null)
			instance = new ViewAPI();
		return instance;
	}
	
	public void showErrorInsufficientPlayers() {
		JOptionPane.showMessageDialog(null, "Não há jogadores sufciente para iniciar o jogo.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
