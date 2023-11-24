package controller;

import model.ModelAPI;
import view.ViewAPI;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
//			startAction();
			return true;
		}
		
		view.showErrorInsufficientPlayers();
		return false;
	}
	
	public void endGame() {
		this.game.finishGame();
		this.game = null;
	}
	
//	public void nextAction() {
//		if (this.acao_atual == Turno.MovTropa) {
//			game.giveCardToPlayer();
//			game.nextPlayerToPlay();
//			acao_atual = Turno.PosTropa;
//		}
//		else
//			acao_atual = Turno.values()[acao_atual.ordinal() + 1];
		
//		startAction();
//	}
	
//	void startAction() {
//		game.printPlayingPlayer();
//		switch(acao_atual) {
//			case PosTropa:
//				game.giveBonuses();
//				System.out.print(" posicionar!\n");
//				break;
//			case Ataque:
//				//faz nada
//				System.out.print(" atacar!\n");
//				break;
//			case MovTropa:
//				//nada tambem
//				System.out.print(" mover!\n");
//				break;
//		}
//	}
	
	public void saveGame() throws IOException{
		PrintWriter outputStream = null;
		LocalDateTime metadata = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
		String filename = "WarGame - " + metadata.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).replace(':', '-') + ".txt";
		
		try {
		outputStream = new PrintWriter(filename);
		
		outputStream.printf("%c;%d;\n", troca_atual, acao_atual.ordinal());
		
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
	
	public void loadGame(String filename) throws IOException {
		BufferedReader inputStream = null;
		String ln, input[];
		
		try {
			inputStream = new BufferedReader(new FileReader(filename));
			
			ln = inputStream.readLine();
			
			input = ln.split(";");
			
			troca_atual = input[0].charAt(0);
			acao_atual = Turno.values()[input[1].charAt(0) - '0'];
			
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
	}
}
