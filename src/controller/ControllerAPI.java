package controller;

import model.ModelAPI;

public class ControllerAPI {
	
	public boolean startGame()
	{
		ModelAPI game = ModelAPI.getModelAPI();
		game.addPlayer("Augur Bolas", 0);
		game.addPlayer("Junior", 3);
		game.setupGame();
		game.drawObjectives();
		return true;
	}
}
