package model;
import java.util.ArrayList;

class Jogador {
	String nome;
	Cores cor;
	Objetivo obj;
	ArrayList<Troca> mao;
	ArrayList<Territorio> paisesDominados;
	int numTropasPosicionar;
	
	public Jogador(String nome, Cores cor) {
		this.nome = nome;
		this.cor = cor;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = new ArrayList<Territorio>();
	}
	
	public boolean moverTropas(Territorio paisOrigem, Territorio paisDestino, int qtd) {
		if (paisOrigem.corDominando != cor) {
			System.out.println("O paisOrigem não pertence ao Jogador");
			return false;
		}
		
		if (paisDestino.corDominando != cor) {
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
	
	public boolean posicionarTropas(Territorio pais, int qtd) {
		if (pais.corDominando != cor) {
			System.out.println("O pais não pertence ao Jogador");
			return false;
		}
		
		if (qtd <= 0) {
			System.out.println("Não se pode posicionar menos que 1 tropa");
			return false;
		}
		
		if (qtd > numTropasPosicionar) {
			System.out.println("Tropas insuficientes");
			return false;
		}
		
		pais.numTropas += qtd;
		
		return true;
	}
	
	public boolean trocaCarta(Troca carta1, Troca carta2, Troca carta3)
	{
		
		return true;
	}
}
