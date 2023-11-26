package model;
import java.util.ArrayList;

class Territorio {
	String nome;
	Continente continente;
	int numTropas;
	int numTropasPodeMover;
	Cores corDominando;
	ArrayList<Territorio> paisesLigados;
	
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
	
	boolean atacarTerritorio(Cores cor, Territorio inimigo, Integer[] atk, Integer[] def) {
		if (this.corDominando != cor)
			return false;
		
		if (inimigo.corDominando == cor)
			return false;
		
		if (this.numTropas < 2)
			return false;
		
		int lostAtk;
		int lostDef;
		int i;
		ModelAPI mod = ModelAPI.getModelAPI();
		
		lostAtk = lostDef = 0;
		
		for(i = 0; i < 3 && (atk[i] != 0 && def[i] != 0); i++) {
			if (atk[i] > def[i]) lostDef++;
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
