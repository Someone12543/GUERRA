package model;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

class Jogador {
	String nome;
	Cores cor;
	Objetivo obj;
	ArrayList<Troca> mao;
	ArrayList<Territorio> paisesDominados;
	ArrayList<Cores> jogadoresEliminados;
	int numTropasPosicionar;
	int[] numTropasContinentes = new int[6];
	boolean dominouPaisTurno;
	
	public Jogador(String nome, Cores cor) {
		this.nome = nome;
		this.cor = cor;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = new ArrayList<Territorio>();
		this.jogadoresEliminados = new ArrayList<Cores>();
		this.numTropasPosicionar = 0;
		this.dominouPaisTurno = false;
	}
	
	boolean posicionarTropas(Territorio pais, int qtd, Continentes cont) {
		if (pais.corDominando != this.cor) {
			System.out.println("O pais não pertence ao Jogador");
			return false;
		}
		
		if (qtd <= 0) {
			System.out.println("Não se pode posicionar menos que 1 tropa");
			return false;
		}
		
		if (qtd > this.numTropasPosicionar) {
			System.out.println("Tropas insuficientes");
			return false;
		}
		
		
		if (cont == null) {
			pais.numTropas += qtd;
			this.numTropasPosicionar -= qtd;
		}
		else {
			if (this.numTropasContinentes[cont.ordinal()] == 0) return false; 
		}
			
		ModelAPI.getModelAPI().prepareNotify(pais);
		
		return true;
	}
	
	boolean moverTropas(Territorio paisOrigem, Territorio paisDestino, int qtd) {
		if (paisOrigem.corDominando != this.cor) {
			System.out.println("O paisOrigem não pertence ao Jogador");
			return false;
		}
		
		if (paisDestino.corDominando != this.cor) {
			System.out.println("O paisDestino não pertence ao Jogador");
			return false;
		}
		
		if (paisOrigem.numTropasPodeMover - qtd < 0 || paisOrigem.numTropas - qtd < 1) {
			System.out.println("O paisOrigem não possui tantas tropas para mover");
			return false;
		}
		
		if (!(paisOrigem.paisesLigados.contains(paisDestino))) {
			System.out.println("Os paises não estam ligados");
			return false;
		}
		
		paisOrigem.numTropas = paisOrigem.numTropas - qtd;
		paisOrigem.numTropasPodeMover = paisOrigem.numTropasPodeMover - qtd;
		
		paisDestino.numTropas = paisDestino.numTropas+qtd;
		
		ModelAPI.getModelAPI().prepareNotify(paisOrigem);
		ModelAPI.getModelAPI().prepareNotify(paisDestino);
		
		return true;
	}
	
	boolean atacarTerritorio(Territorio aliado, Territorio inimigo) {
		
		if (aliado.corDominando != this.cor)
			return false;
		
		if (inimigo.corDominando == this.cor)
			return false;
		
		if (aliado.numTropas < 2)
			return false;
		
		int qtdAtk;
		int qtdDef;
		int lostAtk;
		int lostDef;
		int i;
		
		SecureRandom rand = new SecureRandom();
		
		ArrayList<Integer> listAtk = new ArrayList<Integer>();
		ArrayList<Integer> listDef = new ArrayList<Integer>();
		ImageIcon atkImage = null, defImage = null;
		ArrayList<ImageIcon> atkImages = new ArrayList<ImageIcon>();
		ArrayList<ImageIcon> defImages = new ArrayList<ImageIcon>();
		
		qtdAtk = aliado.numTropas - 1 > 2? 3 : aliado.numTropas - 1;
		qtdDef = inimigo.numTropas > 2? 3 : inimigo.numTropas;
		
		for(i = 0; i < qtdAtk; i++) {
			listAtk.add(rand.nextInt(6) + 1);
		}

		for(i = 0; i < qtdDef; i++) {
			listDef.add(rand.nextInt(6) + 1);
		}
			
		Collections.sort(listAtk, Collections.reverseOrder());
		Collections.sort(listDef, Collections.reverseOrder());
		
		for (i = 0; i < qtdAtk; i++) {
			try {
				atkImage = new ImageIcon(ImageIO.read(new File("assets/dados/dado_ataque_" + listAtk.get(i).toString() + ".png")));
			}
			catch (IOException e){
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			atkImages.add(atkImage);
		}
		
		for (i = 0; i < qtdDef; i++) {
			try {
				defImage = new ImageIcon(ImageIO.read(new File("assets/dados/dado_defesa_" + listDef.get(i).toString() + ".png")));
			}
			catch (IOException e){
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			defImages.add(defImage);
		}
		
		ModelAPI.getModelAPI().atkImages = atkImages;
		ModelAPI.getModelAPI().defImages = defImages;
		
		lostAtk = lostDef = 0;
		
		for(i = 0; i < qtdAtk && i < qtdDef; i++) {
			if (listAtk.get(i) > listDef.get(i)) lostDef++;
			else lostAtk++;
		}
		
		aliado.numTropas -= lostAtk;
		inimigo.numTropas -= lostDef;

		ModelAPI.getModelAPI().prepareNotify(aliado);
		ModelAPI.getModelAPI().prepareNotify(inimigo);

		return true;
	}
	
	int bonusPiece(){
		int numPecas = this.paisesDominados.size()/2;
		if (numPecas < 3){
			numPecas = 3;
		}
		return numPecas;
	}
}
