package view;

import javax.swing.JOptionPane;

import model.ModelAPI;
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
	
	//a viewAPI implemena observer, por isso tem o metodo notify para ser notificada de mudanças
	public void notify(Subject s) {
		//pegando o singleton da tela tabuleiro
		TelaTabuleiro tt = TelaTabuleiro.getTelaTabuleiro();
		
		//chamando o método do tabuleiro que é recuperado via a tela tabuleiro e realiza as alterações na tela e usa o repaint para exibir elas
		tt.t.repaintExe((int)s.obsGet(0), (int)s.obsGet(1), (String)s.obsGet(2), (String)s.obsGet(3));
		tt.repaint();
	}
	
	public void showErrorInsufficientPlayers() {
		JOptionPane.showMessageDialog(null, "Não há jogadores sufciente para iniciar o jogo.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showWinner(String name, String objective) {
		String message = name + " ganhou ao " + objective;
		JOptionPane.showMessageDialog(tt, message, "Temos um vencedor!", JOptionPane.INFORMATION_MESSAGE);
		if (JOptionPane.showConfirmDialog(tt, "Desejam continuar?", "Continuar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
			ModelAPI.getModelAPI().restartGame();
		}
		else
			tt.dispose();
	}
	
	public void openTabuleiro() {
		TelaTabuleiro tt = TelaTabuleiro.getTelaTabuleiro();
		this.tt = tt;
		tt.setTitle("WAR");
		tt.setVisible(true);
	}
	
	public void updateAction (String act) {
		tt.t.repaintAction(act);
		tt.repaint();
	}
	
	public void enableSave() {
		tt.b3.setEnabled(true);
	}
}
