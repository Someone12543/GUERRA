package jogador;
import pais.Pais;
import java.util.List;

public class Jogador {
	private int cor;
	private List<Pais> paisesDominados;
	
	public Jogador(int cor, List<Pais> paisesDominados) {
		this.cor = cor;
		this.paisesDominados = paisesDominados;
	}
	
	public boolean moverTropas(Pais paisOrigem, Pais paisDestino, int qtd) {
		if (paisOrigem.getCorDominando() != cor) {
			System.out.println("O paisOrigem não pertence ao Jogador");
			return false;
		}
		
		if (paisDestino.getCorDominando() != cor) {
			System.out.println("O paisDestino não pertence ao Jogador");
			return false;
		}
		
		if (paisOrigem.getNumTropas()-qtd < 1 || paisOrigem.getNumTropasPodeMover()-qtd < 0) {
			System.out.println("O paisOrigem não possui tantas tropas para mover");
			return false;
		}
		
		if (!(paisOrigem.getPaisesLigados().contains(paisDestino))) {
			System.out.println("Os paises não estam ligados");
			return false;
		}
		
		paisOrigem.setNumTropas(paisOrigem.getNumTropas()-qtd);
		paisOrigem.setNumTropasPodeMover(paisOrigem.getNumTropasPodeMover()-qtd);
		
		paisDestino.setNumTropas(paisDestino.getNumTropas()+qtd);
		
		return true;
	}
	
	
	public int getCor() {
		return cor;
	}

	public void setCor(int cor) {
		this.cor = cor;
	}

	public List<Pais> getPaisesDominados() {
		return paisesDominados;
	}

	public void setPaisesDominados(List<Pais> paisesDominados) {
		this.paisesDominados = paisesDominados;
	}

	
}
