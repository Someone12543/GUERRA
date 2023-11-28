package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JogadorTests {
	static Jogador p1;
	static Jogador p2;
	static Territorio t1, t2, t3, t4;
	static ModelAPI game;
	
	@BeforeAll
	static void setup() 
	{
		p1 = new Jogador("Jorge", Cores.Amarelo);
		p2 = new Jogador("Jefferson", Cores.Azul);
		t1 = new Territorio("A", null);
		t2 = new Territorio("B", null);
		t3 = new Territorio("C", null);
		t4 = new Territorio("D", null);
		
		game = ModelAPI.getModelAPI();
		game.listaJogadores.add(p1);
		game.listaJogadores.add(p2);
		
		p1.numTropasPosicionar = 5;
		
		t1.corDominando = p1.cor;
		p1.paisesDominados.add(t1);
		
		t2.corDominando = p1.cor;
		p1.paisesDominados.add(t2);
		
		t3.corDominando = p1.cor;
		p1.paisesDominados.add(t3);
		
		t4.corDominando = p2.cor;
		p2.paisesDominados.add(t4);
	}
	
	@Test
	void posicionarTropasTerritorioNaoDominado() {
		assertFalse(p1.posicionarTropas(t4, 3, null));
	}
	
	@Test
	void posicionarTropasQtdErrada() {
		assertFalse(p1.posicionarTropas(t1, -10, null));
	}
	
	@Test
	void posicionarTropasQtdInsuficiente() {
		assertFalse(p1.posicionarTropas(t1, 7, null));
	}
	
	@Test
	void posicionarTropasOk() {
		int expectedNumTropas = t1.numTropas + 4;
		assertTrue(p1.posicionarTropas(t1, 4, null));
		assertEquals(expectedNumTropas, t1.numTropas);
	}
	
	@Test
	void testBonusPieceLessThan3() {
		int expected = 3;
		assertEquals(expected, p2.bonusPiece());
	}
	
	@Test
	void testBonusPieceMoreThan3() {
		int expected = 4;
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);
		p1.paisesDominados.add(null);

		assertEquals(expected, p1.bonusPiece());
	}

}
