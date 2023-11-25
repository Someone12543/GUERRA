package controller;

import model.ModelAPI;
import view.ViewAPI;

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
		}
		else
			acao_atual = Turno.values()[acao_atual.ordinal() + 1];
		
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
