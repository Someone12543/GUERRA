package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ModelAPITests {
	static Troca card1, card2, card3, card4, card5, cardCoringa;
	static ModelAPI game;
	
	@BeforeAll
	static void setup() {
		game = ModelAPI.getModelAPI();
		game.addPlayer("Jorge", Cores.Amarelo.ordinal());
		game.addPlayer("Jefferson", Cores.Azul.ordinal());
		
		try {
		ModelAPI.setupImages();
		} catch (Exception e) {
			System.exit(2);
		}
		game.setupContinents(game.listaContinente);
		game.setupCards();
		
		card1 = new Troca(null, Simbolo.Circulo, null);
		card2 = new Troca(null, Simbolo.Circulo, null);
		card3 = new Troca(null, Simbolo.Circulo, null);
		card4 = new Troca(null, Simbolo.Quadrado, null);
		card5 = new Troca(null, Simbolo.Triangulo, null);
		cardCoringa = new Troca(null, Simbolo.Coringa, null);
	}
	
	@Test
	void testDrawObjectives() {
		game.drawObjectives();
		for(Jogador j : game.listaJogadores)
			assertNotNull(j.obj);
	}
	
	@Test
	void testDrawTrade() {
		assertNotNull(game.drawTrade());
	}
	
	@Test
	void testValidateTradeSameSimbolo() {
		assertTrue(game.validateTrade(card3, card2, card1));
	}
	
	@Test
	void testValidateTradeDiffSimbolo() {
		assertTrue(game.validateTrade(card1, card4, card5));
	}
	
	@Test
	void testValidateTradeCoringa() {
		assertTrue(game.validateTrade(card4, card2, cardCoringa));
	}
	
	@Test
	void testValidateTradeNotOK() {
		assertFalse(game.validateTrade(card1, card2, card4));
	}
}
