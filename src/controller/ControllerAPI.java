package controller;

import model.ModelAPI;
import view.ViewAPI;

public class ControllerAPI {
	
	public static void main(String[] args) {
		ViewAPI view = ViewAPI.getViewAPI();
	}
	
	static ControllerAPI instance;
	
	private ControllerAPI() {
		
	}
	
	public ControllerAPI getControllerAPI() {
		if(instance == null)
			instance = new ControllerAPI();
		return instance;
	}
	
	public boolean startGame()
	{
		ModelAPI game = ModelAPI.getModelAPI();
		ViewAPI view = ViewAPI.getViewAPI();
		
		game.addPlayer("Augur Bolas", 0);
		game.addPlayer("Junior", 3);
		game.setupGame();
		return true;
	}
}
