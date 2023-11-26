package model;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

class Territorio {
	String nome;
	Continente continente;
	int numTropas; //num de tropas totais do territorio
	int numTropasPodeMover; //num de tropas que podem ser movidas do territorio
	Cores corDominando;
	ArrayList<Territorio> paisesLigados; //paises que o territorio está ligado com
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		this.continente = continente;
		this.numTropas = 0;
		this.numTropasPodeMover = 0;
		this.paisesLigados = new ArrayList<Territorio>();
	}
	
	boolean moverTropas(Cores cor, Territorio paisDestino, int qtd) {
		if (this.corDominando != cor) {
			System.out.println("O paisOrigem não pertence ao Jogador");
			return false;
		}
		
		if (paisDestino.corDominando != cor) {
			System.out.println("O paisDestino não pertence ao Jogador");
			return false;
		}
		
		if (this.numTropasPodeMover - qtd < 0 || this.numTropas - qtd < 1) {
			System.out.println("O paisOrigem não possui tantas tropas para mover");
			return false;
		}
		
		if (!(this.paisesLigados.contains(paisDestino))) {
			System.out.println("Os paises não estão ligados");
			return false;
		}
		
		this.numTropas -=  qtd;
		this.numTropasPodeMover -= qtd;
		
		paisDestino.numTropas += qtd;
		
		return true;
	}
	
boolean atacarTerritorio(Cores cor, Territorio inimigo) {
		
		if (this.corDominando != cor)
			return false;
		
		if (inimigo.corDominando == cor)
			return false;
		
		if (this.numTropas < 2)
			return false;
		
		int qtdAtk;
		int qtdDef;
		int lostAtk;
		int lostDef;
		int i;
		ModelAPI mod = ModelAPI.getModelAPI();
		
		SecureRandom rand = new SecureRandom();
		
		ArrayList<Integer> listAtk = new ArrayList<Integer>();
		ArrayList<Integer> listDef = new ArrayList<Integer>();
		ImageIcon atkImage = null, defImage = null;
		ArrayList<ImageIcon> atkImages = new ArrayList<ImageIcon>();
		ArrayList<ImageIcon> defImages = new ArrayList<ImageIcon>();
		
		qtdAtk = this.numTropas - 1 > 2? 3 : this.numTropas - 1;
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
		
		mod.atkImages = atkImages;
		mod.defImages = defImages;
		
		lostAtk = lostDef = 0;
		
		for(i = 0; i < qtdAtk && i < qtdDef; i++) {
			if (listAtk.get(i) > listDef.get(i)) lostDef++;
			else lostAtk++;
		}
		
		this.numTropas -= lostAtk;
		inimigo.numTropas -= lostDef;
		
		if (inimigo.numTropas == 0) {
			for (Jogador j : mod.listaJogadores) {
				if (j.cor == inimigo.corDominando) {
					j.paisesDominados.remove(inimigo);
				}
			}
			
			for (Jogador j : mod.listaJogadores) {
				if (j.cor == this.corDominando) {
					j.paisesDominados.add(inimigo);
				}
			}
			
			inimigo.corDominando = cor;
			
			int temp = this.numTropas - 1 > 2? 3 : this.numTropas - 1;
			inimigo.numTropas = temp;
			this.numTropas -= temp;
		}
		
		return true;
	}
}
