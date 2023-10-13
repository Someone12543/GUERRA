package controller;

import model.ModelAPI;

public class ControllerAPI {
	
	public boolean startGame()
	{
		ModelAPI.addPlayer(0);
		ModelAPI.setupGame();
		return true;
	}
}
