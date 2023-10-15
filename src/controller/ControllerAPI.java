package controller;

import model.ModelAPI;

public class ControllerAPI {
	
	public boolean startGame()
	{
		ModelAPI.setupGame();
		ModelAPI.addPlayer("Augur Bolas", 0);
		ModelAPI.drawObjectives();
		return true;
	}
}
