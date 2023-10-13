package model;
import java.util.ArrayList;

class Jogador {
	int cor;
	ArrayList<Territorio> paisesDominados;
	
	public Jogador(int cor, ArrayList<Territorio> paisesDominados) {
		this.cor = cor;
		this.paisesDominados = paisesDominados;
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
		
		if (paisOrigem.numTropasPodeMover-qtd < 1 || paisOrigem.numTropasPodeMover-qtd < 0) {
			System.out.println("O paisOrigem não possui tantas tropas para mover");
			return false;
		}
		
		if (!(paisOrigem.paisesLigados.contains(paisDestino))) {
			System.out.println("Os paises não estam ligados");
			return false;
		}
		
		paisOrigem.numTropas = paisOrigem.numTropas - qtd;
		paisOrigem.numTropasPodeMover = paisOrigem.numTropasPodeMover-qtd;
		
		paisDestino.numTropas = paisDestino.numTropas+qtd;
		
		return true;
	}
}