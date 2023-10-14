package model;
import java.util.ArrayList;

class Jogador {
	Cores cor;
	Objetivo obj;
	ArrayList<Troca> mao;
	ArrayList<Territorio> paisesDominados;
	
	public Jogador(Cores cor, Objetivo obj, ArrayList<Territorio> paisesDominados) {
		this.cor = cor;
		this.obj = obj;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = paisesDominados;
	}
	
	public boolean moverTropas(Territorio paisOrigem, Territorio paisDestino, int qtd) {
		if (paisOrigem.corDominando != cor.ordinal()) {
			System.out.println("O paisOrigem não pertence ao Jogador");
			return false;
		}
		
		if (paisDestino.corDominando != cor.ordinal()) {
			System.out.println("O paisDestino não pertence ao Jogador");
			return false;
		}
		
		if (paisOrigem.numTropas - 1 - qtd < 1 || paisOrigem.numTropas - 1 - qtd < 0) {
			System.out.println("O paisOrigem não possui tantas tropas para mover");
			return false;
		}
		
		if (!(paisOrigem.paisesLigados.contains(paisDestino))) {
			System.out.println("Os paises não estam ligados");
			return false;
		}
		
		paisOrigem.numTropas = paisOrigem.numTropas - qtd;
		
		paisDestino.numTropas = paisDestino.numTropas+qtd;
		
		return true;
	}
	
	enum Cores
	{
		Amarelo, Azul, Branco, Verde, Vermelho, Preto;
	}
}