package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ModelAPITests {
	static Troca card1, card2, card3, card4, card5, cardCoringa;
	
	@BeforeAll
	static void setup() 
	{
		ModelAPI.addPlayer("Jorge", Cores.Amarelo.ordinal());
		ModelAPI.addPlayer("Jefferson", Cores.Azul.ordinal());
		ModelAPI.setupGame();
		
		card1 = new Troca(null, Simbolo.Circulo, null);
		card2 = new Troca(null, Simbolo.Circulo, null);
		card3 = new Troca(null, Simbolo.Circulo, null);
		card4 = new Troca(null, Simbolo.Quadrado, null);
		card5 = new Troca(null, Simbolo.Triangulo, null);
		cardCoringa = new Troca(null, Simbolo.Coringa, null);
	}
	
	@Test
	void testDrawObjectives() {
		ModelAPI.drawObjectives();
		for(Jogador j : ModelAPI.listaJogadores)
			assertNotNull(j.obj);
	}
	
	@Test
	void testDrawTrade() {
		assertNotNull(ModelAPI.drawTrade());
	}
	
	@Test
	void testBonusPieceLessThan3() {
		Jogador p1 = new Jogador("Jorge", Cores.Amarelo);
		int expected = 3;
		assertEquals(expected, ModelAPI.bonusPiece(p1));
	}
	
	@Test
	void testBonusPieceMoreThan3() {
		Jogador p1 = new Jogador("Jorge", Cores.Amarelo);
		int expected = 4;
		
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		
		assertEquals(expected, ModelAPI.bonusPiece(p1));
	}
	
	@Test
	void testBonusPieceContinenteNotDominated() {
		Jogador p1 = new Jogador("Jorge", Cores.Amarelo);
		int expected = 0;
		Continente c = new Continente("A", null, 3);
		Territorio t1 = new Territorio("A", c);
		c.paises.add(t1);
		
		assertEquals(expected, ModelAPI.bonusPiece(p1, c));
	}
	
	@Test
	void testBonusPieceContinenteDominated() {
		Jogador p1 = new Jogador("Jorge", Cores.Amarelo);
		int expected = 3;
		Continente c = new Continente("A", null, 3);
		Territorio t1 = new Territorio("A", c);
		c.paises.add(t1);
		p1.paisesDominados.add(t1);
		
		assertEquals(expected, ModelAPI.bonusPiece(p1, c));
	}
	
	@Test
	void testValidateTradeSameSimbolo() {
		assertTrue(ModelAPI.validateTrade(card3, card2, card1));
	}
	
	@Test
	void testValidateTradeDiffSimbolo() {
		assertTrue(ModelAPI.validateTrade(card1, card4, card5));
	}
	
	@Test
	void testValidateTradeCoringa() {
		assertTrue(ModelAPI.validateTrade(card4, card2, cardCoringa));
	}
	
	@Test
	void testValidateTradeNotOK() {
		assertFalse(ModelAPI.validateTrade(card1, card2, card4));
	}
}
