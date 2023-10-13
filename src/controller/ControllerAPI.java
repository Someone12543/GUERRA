package controller;

import model.ModelAPI;

public class ControllerAPI {
	
	public boolean startGame()
	{
		ModelAPI.setupGame();
		ModelAPI.addPlayer(0);
		ModelAPI.drawObjectives();
		return true;
	}
}
