package controller;

import model.ModelAPI;
import view.ViewAPI;
import java.io.*;

//Nossa fachada para o pacote Controller que também é um singleton e onde está nossa main
public class ControllerAPI {
	
	// main preparando imagens e iniciando o controller
	public static void main(String[] args) {
		getControllerAPI();
		try {
			ModelAPI.setupImages();
		} catch (IOException e) {
			System.out.println("Não foi possível carregar os arquivos!");
			System.exit(2);
		}
	}
	
	//singleton
	static ControllerAPI instance;
	
	public int troca_atual;
	Turno acao_atual;
	
	//variaveis para pegar singletons das outras fachadas
	ModelAPI game;
	ViewAPI view;
	
	private ControllerAPI() {
		this.view = ViewAPI.getViewAPI();
		this.acao_atual = Turno.PosTropa;
	}
	
	
	//get do singleton
	public static ControllerAPI getControllerAPI() {
		if(instance == null)
			instance = new ControllerAPI();
		return instance;
	}
	
	public boolean startGame()
	{
		this.troca_atual = 1;
		this.game = ModelAPI.getModelAPI();
		if(this.game.setupGame()) {
			startAction();
			return true;
		}
		
		//erro para o caso de nao ter jogadores suficientes para iniciar o jogo 
		view.showErrorInsufficientPlayers();
		return false;
	}
	
	public void endGame() {
		this.game.finishGame();
		this.game = null;
	}

	//Preparando a proxima acao
	public void nextAction() {
		//check para saber se o jogador add todas as tropas que precisava
		if (this.acao_atual == Turno.PosTropa) {
			if (!game.verifyNextTurn()) return;
		}
		
		//dando as cartas pro jogador e habilitando o save
		if (this.acao_atual == Turno.MovTropa) {
			game.giveCardToPlayer();
			game.nextPlayerToPlay();
			acao_atual = Turno.PosTropa;
			view.enableSave();
		}
		else {
			acao_atual = Turno.values()[acao_atual.ordinal() + 1];
		}
			

		
		startAction();
	}
	
	//auto-explicativa
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
			
			troca_atual = Integer.parseInt(ln);
			acao_atual = Turno.PosTropa;
			view.updateAction(getAcaoStr());
			
			game = ModelAPI.getModelAPI();
			
			game.loadGame(inputStream);
			
		}
		catch(IOException e) { 
			System.out.print(e.getMessage());
			game.finishGame();
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		ViewAPI.getViewAPI().openTabuleiro();
		
		startAction();
	}
	
	//Chamar as funcoes necessarias do modelAPI para cada caso de tipo de acao do turno
	void startAction() {
		switch (acao_atual) {
			case PosTropa:
				game.giveBonuses();
				break;
			case Ataque:
				if (game.check1stTurn()) {
					this.acao_atual = Turno.MovTropa;
					nextAction();
				}
				break;
			case MovTropa:
				game.updateTroops();
				break;
		}
	}
	
	//caputrando o numero do turno via ordinal do enum
	public int getTurno() {
		return acao_atual.ordinal();
	}
	
	//devolvendo o tipo de acao em formato de String para ser exibida na tela
	public String getAcaoStr() {
		if (acao_atual == Turno.Ataque) {
			return "Ataque";
		}
		if (acao_atual == Turno.MovTropa) {
			return "Movimentar";
		}
		return "Posicionar";
	}
}
