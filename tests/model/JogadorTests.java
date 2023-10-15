package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTests {
	static Jogador p1;
	static Jogador p2;
	static Territorio t1, t2, t3, t4;
	
	@BeforeAll
	static void setup() 
	{
		p1 = new Jogador("Jorge", Cores.Amarelo);
		p2 = new Jogador("Jefferson", Cores.Azul);
		t1 = new Territorio("A", null);
		t2 = new Territorio("B", null);
		t3 = new Territorio("C", null);
		t4 = new Territorio("D", null);
		
		p1.numTropasPosicionar = 5;
		
		t1.corDominando = p1.cor;
		t2.corDominando = p1.cor;
		t3.corDominando = p1.cor;
		t4.corDominando = p2.cor;
		
		t1.numTropas = 3; t1.numTropasPodeMover = 1;
		t2.numTropas = 3; t2.numTropasPodeMover = 1;

		t1.paisesLigados.add(t2);
		t1.paisesLigados.add(t4);
		
		t2.paisesLigados.add(t1);
		t2.paisesLigados.add(t3);
		
		t3.paisesLigados.add(t2);
		t3.paisesLigados.add(t4);
		
		t4.paisesLigados.add(t1);
		t4.paisesLigados.add(t3);
	}
	
	@Test
	void moverTropaPaisOrigemErrado() {
		assertFalse(p1.moverTropas(t4, t1, 1));
	}
	
	@Test
	void moverTropaPaisDestinoErrado() {
		assertFalse(p1.moverTropas(t1, t4, 1));
	}
	
	@Test
	void moverTropaQtdInsuficiente() {
		assertFalse(p1.moverTropas(t1, t2, 3));
	}
	
	@Test
	void moverTropaSemFronteira() {
		assertFalse(p1.moverTropas(t1, t3, 1));
	}
	
	@Test
	void moverTropaOk() {
		int expectedNumTropasT1 = t1.numTropas - 1;
		int expectedNumTropasPodeMoverT1 = t1.numTropasPodeMover - 1;
		int expectedNumTropasT2 = t2.numTropas + 1;
		
		assertTrue(p1.moverTropas(t1, t2, 1));
		assertEquals(expectedNumTropasT1, t1.numTropas);
		assertEquals(expectedNumTropasPodeMoverT1, t1.numTropasPodeMover);
		assertEquals(expectedNumTropasT2, t2.numTropas);
	}
	
	@Test
	void posicionarTropasTerritorioNaoDominado() {
		assertFalse(p1.posicionarTropas(t4, 3));
	}
	
	@Test
	void posicionarTropasQtdErrada() {
		assertFalse(p1.posicionarTropas(t1, -10));
	}
	
	@Test
	void posicionarTropasQtdInsuficiente() {
		assertFalse(p1.posicionarTropas(t1, 7));
	}
	
	@Test
	void posicionarTropasOk() {
		int expectedNumTropas = t1.numTropas + 4;
		assertTrue(p1.posicionarTropas(t1, 4));
		assertEquals(expectedNumTropas, t1.numTropas);
	}
	
	@Test
	void trocarCarta() {
		
	}
}
