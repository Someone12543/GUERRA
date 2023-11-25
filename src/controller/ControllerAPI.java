package controller;

import model.ModelAPI;
import view.ViewAPI;
import java.io.*;

public class ControllerAPI {
	
	public static void main(String[] args) {
		getControllerAPI();
	}
	
	static ControllerAPI instance;
	public char troca_atual;
	Turno acao_atual;
	ModelAPI game;
	ViewAPI view;
	
	private ControllerAPI() {
		this.view = ViewAPI.getViewAPI();
	}
	
	public static ControllerAPI getControllerAPI() {
		if(instance == null)
			instance = new ControllerAPI();
		return instance;
	}
	
	public boolean startGame()
	{
		this.troca_atual = 1;
		this.acao_atual = Turno.PosTropa;
		this.game = ModelAPI.getModelAPI();
		if(this.game.setupGame()) {
			startAction();
			return true;
		}
		
		view.showErrorInsufficientPlayers();
		return false;
	}
	
	public void endGame() {
		this.game.finishGame();
		this.game = null;
	}

	public void nextAction() {
		if (this.acao_atual == Turno.PosTropa) {
			if (game.verifyNextTurn()) return;
		}

		if (this.acao_atual == Turno.MovTropa) {
			game.giveCardToPlayer();
			game.nextPlayerToPlay();
			acao_atual = Turno.PosTropa;
			view.enableSave();
		}
		else
			acao_atual = Turno.values()[acao_atual.ordinal() + 1];

		
		startAction();
	}
	
	public void saveGame(File file) throws IOException {
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(file);
			
			outputStream.println(troca_atual);
			
			game.saveGame(outputStream);
		}
		catch(IOException e) { 
			System.out.print(e.getMessage());
		}
		finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
	
	public void loadGame(File file) throws IOException {
		BufferedReader inputStream = null;
		String ln;
		
		try {
			inputStream = new BufferedReader(new FileReader(file));
			
			ln = inputStream.readLine();
			
			troca_atual = ln.charAt(0);
			
			game = ModelAPI.getModelAPI();
			
			game.loadGame(inputStream);
			
		}
		catch(IOException e) { 
			System.out.print(e.getMessage());
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		ViewAPI.getViewAPI().openTabuleiro();
		
		startAction();
	}
	
	void startAction() {
		if(acao_atual == Turno.PosTropa) {
			game.giveBonuses();
		}
	}

	public int getTurno() {
		return acao_atual.ordinal();
	}
}
