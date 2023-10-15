package controller;

import model.ModelAPI;

public class ControllerAPI {
	
	public boolean startGame()
	{
		ModelAPI.addPlayer("Augur Bolas", 0);
		ModelAPI.addPlayer("Junior", 3);
		ModelAPI.setupGame();
		ModelAPI.drawObjectives();
		return true;
	}
}
