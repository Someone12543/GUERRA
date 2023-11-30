package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContinenteTests {
	static Jogador p1;
	static Continente c;
	static Territorio t1;
	
	@BeforeAll
	static void setup() {
		p1 = new Jogador("Jorge", Cores.Amarelo);
		c = new Continente("A", null, 3);
		t1 = new Territorio("A", c);
		c.paises.add(t1);
	}
	
	@Test
	void testBonusPieceContinenteNotDominated() {
		int expected = 0;
		p1.paisesDominados.clear();
		
		assertEquals(expected, c.bonusPiece(p1));
	}
	
	@Test
	void testBonusPieceContinenteDominated() {
		int expected = 3;
		p1.paisesDominados.add(t1);
		
		assertEquals(expected, c.bonusPiece(p1));
	}
}
