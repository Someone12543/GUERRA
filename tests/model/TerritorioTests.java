package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TerritorioTests {
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
		p1.paisesDominados.add(t1);
		
		t2.corDominando = p1.cor;
		p1.paisesDominados.add(t2);
		
		t3.corDominando = p1.cor;
		p1.paisesDominados.add(t3);
		
		t4.corDominando = p2.cor;
		p2.paisesDominados.add(t4);

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
		assertFalse(t4.moverTropas(p1.cor, t1, 1));
	}

	@Test
	void moverTropaPaisDestinoErrado() {
		assertFalse(t1.moverTropas(p1.cor, t4, 1));
	}

	@Test
	void moverTropaQtdInsuficiente() {
		assertFalse(t1.moverTropas(p1.cor, t2, 3));
	}

	@Test
	void moverTropaSemFronteira() {
		assertFalse(t1.moverTropas(p1.cor, t3, 1));
	}

	@Test
	void moverTropaOk() {
		t1.numTropas = 3; t1.numTropasPodeMover = 1;
		t2.numTropas = 3; t2.numTropasPodeMover = 1;
		t3.numTropas = 1; t3.numTropasPodeMover = 0;
		
		int expectedNumTropasT1 = t1.numTropas - 1;
		int expectedNumTropasPodeMoverT1 = t1.numTropasPodeMover - 1;
		int expectedNumTropasT2 = t2.numTropas + 1;
		
		assertTrue(t1.moverTropas(p1.cor, t2, 1));
		assertEquals(expectedNumTropasT1, t1.numTropas);
		assertEquals(expectedNumTropasPodeMoverT1, t1.numTropasPodeMover);
		assertEquals(expectedNumTropasT2, t2.numTropas);
	}
	
	@Test
	void atacarTerritorioOrigemErrado() {
		assertFalse(t4.atacarTerritorio(p1.cor, t1, null, null));
	}
	
	@Test
	void atacarTerritorrioPaisDestinoErrado() {
		assertFalse(t1.atacarTerritorio(p1.cor, t2, null, null));
	}
	
	@Test
	void atacarTerritorioQtdInsuficiente() {
		assertFalse(t3.atacarTerritorio(p1.cor, t4, null, null));
	}
	
	@Test
	void atacarTerritorioOkWonAtk() {
		t1.numTropas = 4;
		t2.numTropas = 3;
		t3.numTropas = 1;
		t4.numTropas = 1;
		
		Integer[] atk = {6, 6, 6};
		Integer[] def = {1, 0, 0};
		
		assertTrue(t1.atacarTerritorio(p1.cor, t4, atk, def));
		assertEquals(p1.cor, t4.corDominando);
		assertEquals(3, t4.numTropas);
	}
	
	@Test
	void atacarTerritorioOkWonDef() {
		t1.numTropas = 4;
		t2.numTropas = 3;
		t3.numTropas = 1;
		t4.corDominando = Cores.Azul;
		t4.numTropas = 1;
		
		Integer[] atk = {6, 6, 6};
		Integer[] def = {6, 0, 0};
		
		assertTrue(t1.atacarTerritorio(p1.cor, t4, atk, def));
		assertEquals(3, t1.numTropas);
	}
}
