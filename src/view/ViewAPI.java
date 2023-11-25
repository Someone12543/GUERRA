package view;

import javax.swing.JOptionPane;

import controller.ControllerAPI;

import observer.*;

public class ViewAPI implements Observer{
	
	public static ViewAPI instance;
	TelaTabuleiro tt;
	
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
	
	public void notify(Subject s) {
		TelaTabuleiro tt = TelaTabuleiro.getTelaTabuleiro();
		tt.t.repaintExe((int)s.obsGet(0), (int)s.obsGet(1), (String)s.obsGet(2));
	}
	
	public void showErrorInsufficientPlayers() {
		JOptionPane.showMessageDialog(null, "Não há jogadores sufciente para iniciar o jogo.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showWinner(String name, String objective) {
		ControllerAPI ctrl = ControllerAPI.getControllerAPI();
		String message = name + " ganhou ao " + objective;
		JOptionPane.showMessageDialog(tt, message, "Temos um vencedor!", JOptionPane.INFORMATION_MESSAGE);
		if (JOptionPane.showConfirmDialog(tt, "Desejam continuar?", "Continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 1) {
			//load no save state inicial (falar com ivan)
		}
		else
			tt.dispose();
	}
	
	
}
