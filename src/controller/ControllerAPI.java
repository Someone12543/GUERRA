package controller;

import model.ModelAPI;
import view.ViewAPI;

public class ControllerAPI {
	
	public char troca_atual = 1;
	
	public static void main(String[] args) {
		ViewAPI view = ViewAPI.getViewAPI();
	}
	
	static ControllerAPI instance;
	
	private ControllerAPI() {
		
	}
	
	public static ControllerAPI getControllerAPI() {
		if(instance == null)
			instance = new ControllerAPI();
		return instance;
	}
	
	public boolean startGame()
	{
		ModelAPI game = ModelAPI.getModelAPI();
		ViewAPI view = ViewAPI.getViewAPI();
		
		game.setupGame();
		return true;
	}
}
