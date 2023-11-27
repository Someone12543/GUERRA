package view;

import javax.swing.JOptionPane;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import model.ModelAPI;
import observer.*;

public class ViewAPI implements Observer{
	
	private static Clip clipAtual;
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
	
	public static void reproduzirSomAsync(String caminhoDoSom) {
        new Thread(() -> {
            try {
                // Se houver um som atual em reprodução, pare-o
                pararReproducao();

                // Crie um Clip de áudio
                Clip clip = AudioSystem.getClip();
                // Carregue o áudio do arquivo
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(caminhoDoSom));
                clip.open(inputStream);
                // Reproduza o som
                clip.start();
                // Aguarde até que o som termine de ser reproduzido
                Thread.sleep(clip.getMicrosecondLength() / 1000);
                // Feche o Clip
                clip.close();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void pararReproducao() {
        // Se houver um som atual em reprodução, pare-o
        if (clipAtual != null && clipAtual.isOpen()) {
            clipAtual.stop();
            clipAtual.close();
        }
    }
	
	//a viewAPI implemena observer, por isso tem o metodo notify para ser notificada de mudanças
	public void notify(Subject s) {
		//pegando o singleton da tela tabuleiro
		TelaTabuleiro tt = TelaTabuleiro.getTelaTabuleiro();
		
		//chamando o método do tabuleiro que é recuperado via a tela tabuleiro e realiza as alterações na tela e usa o repaint para exibir elas
		tt.t.repaintExe((int)s.obsGet(0), (int)s.obsGet(1), (String)s.obsGet(2), (String)s.obsGet(3), (String)s.obsGet(4));
		tt.repaint();
	}
	
	public void showErrorInsufficientPlayers() {
		JOptionPane.showMessageDialog(null, "Não há jogadores sufciente para iniciar o jogo.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showWinner(String name, String objective) {
		String message = name + " ganhou ao " + objective;
		JOptionPane.showMessageDialog(tt, message, "Temos um vencedor!", JOptionPane.INFORMATION_MESSAGE);
		reproduzirSomAsync("assets/sons/palmas.wav");
		
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
		reproduzirSomAsync("assets/sons/comeco.wav");
	}
	
	public void updateAction (String act) {
		tt.t.repaintAction(act);
		tt.repaint();
	}
	
	public void enableSave() {
		tt.b3.setEnabled(true);
	}
}
