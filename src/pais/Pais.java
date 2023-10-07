package pais;
import java.util.List;

public class Pais {
	private String nome;
	private String pertenceContinente;
	private int numTropas;
	private int numTropasPodeMover;
	private int corDominando;
	private List<Pais> paisesLigados;
	
	public Pais(String nome, String pertenceContinente, int numTropas, List<Pais> paisesLigados, int numTropasPodeMover) {
		this.nome = nome;
		this.pertenceContinente = pertenceContinente;
		this.numTropas = numTropas;
		this.paisesLigados = paisesLigados;
		this.numTropasPodeMover = numTropasPodeMover;
	}
	
	public String getNome() {
		return nome;
	}

	public String getPertenceContinente() {
		return pertenceContinente;
	}

	public int getNumTropas() {
		return numTropas;
	}

	public void setNumTropas(int numTropas) {
		this.numTropas = numTropas;
	}
	
	public int getCorDominando() {
		return corDominando;
	}
	
	public void setCorDominando(int corDominando) {
		this.corDominando = corDominando;
	}
	
	public List<Pais> getPaisesLigados() {
		return paisesLigados;
	}
	
	public void setPaisesLigados(List<Pais> paisesLigados) {
		this.paisesLigados = paisesLigados;
	}
	
	public int getNumTropasPodeMover() {
		return numTropasPodeMover;
	}
	
	public void setNumTropasPodeMover(int numTropasPodeMover) {
		this.numTropasPodeMover = numTropasPodeMover;
	}
	
}
