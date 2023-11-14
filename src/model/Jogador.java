package model;
import java.awt.Image;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

class Jogador {
	String nome;
	Cores cor;
	Objetivo obj;
	ArrayList<Troca> mao;
	ArrayList<Territorio> paisesDominados;
	ArrayList<Jogador> jogadoresEliminados;
	int numTropasPosicionar;
	boolean dominouPaisTurno;
	
	public Jogador(String nome, Cores cor) {
		this.nome = nome;
		this.cor = cor;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = new ArrayList<Territorio>();
		this.dominouPaisTurno = false;
	}
	
	boolean posicionarTropas(Territorio pais, int qtd) {
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
		
		pais.numTropas += qtd;
		
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
		
		return true;
	}
	
	boolean atacarTerritorio(Territorio aliado, Territorio inimigo) {
		if (aliado.corDominando != this.cor)
			return false;
		
		if (inimigo.corDominando == this.cor)
			return false;
		
		if (aliado.numTropas < 2)
			return false;
		
		int qtdatk;
		int qtddef;
		int lostatk;
		int lostdef;
		int i;
		SecureRandom rand = new SecureRandom();
		
		ArrayList<Integer> listatk = new ArrayList<Integer>();
		ArrayList<Integer> listdef = new ArrayList<Integer>();
		ArrayList<Image> atkimage = new ArrayList<Image>();
		ArrayList<Image> defimage = new ArrayList<Image>();
		
		while (aliado.numTropas != 1 || inimigo.numTropas != 0) {
			qtdatk = aliado.numTropas - 1 > 2? 3 : aliado.numTropas - 1;
			qtddef = inimigo.numTropas > 2? 3 : inimigo.numTropas;
			
			for(i = 0; i < qtdatk; i++) {
				listatk.add(rand.nextInt(6) + 1);
				listatk.get(i); // para futuramente adicionar na lista de imagens 
			}

			for(i = 0; i < qtddef; i++) {
				listdef.add(rand.nextInt(6) + 1);
				listdef.get(i); // para futuramente adicionar na lista de imagens 
			}
			
			Collections.sort(listatk, Collections.reverseOrder());
			Collections.sort(listdef, Collections.reverseOrder());
			
			lostatk = lostdef = 0;
			
			for(i = 0; i < qtdatk && i < qtddef; i++) {
				if (listatk.get(i) > listdef.get(i)) lostdef++;
				else lostatk++;
			}
			
			aliado.numTropas -= lostatk;
			inimigo.numTropas -= lostdef;
			
			//display resultados
			//wait x sec
		}
		
		if (inimigo.numTropas == 0) {
			qtdatk = aliado.numTropas - 1 > 2? 3 : aliado.numTropas - 1;
			
			inimigo.corDominando = aliado.corDominando;
			
			inimigo.numTropas += qtdatk;
			aliado.numTropas -= qtdatk;
			this.dominouPaisTurno = true;
		}
		
		
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
