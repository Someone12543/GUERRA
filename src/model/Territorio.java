package model;
import java.util.ArrayList;

public class Territorio {
	private String nome;
	private Continente continente;
	private int numTropas;
	private int numTropasPodeMover;
	private int corDominando;
	private ArrayList<Territorio> paisesLigados;
	
	public Territorio(String nome, Continente continente, int numTropas, ArrayList<Territorio> paisesLigados, int numTropasPodeMover) {
		this.nome = nome;
		this.continente = continente;
		this.numTropas = numTropas;
		this.paisesLigados = paisesLigados;
		this.numTropasPodeMover = numTropasPodeMover;
	}
	
	public String getNome() {
		return nome;
	}

	public Continente getContinente() {
		return continente;
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
	
	public ArrayList<Territorio> getPaisesLigados() {
		return paisesLigados;
	}
	
	public void setPaisesLigados(ArrayList<Territorio> paisesLigados) {
		this.paisesLigados = paisesLigados;
	}
	
	public int getNumTropasPodeMover() {
		return numTropasPodeMover;
	}
	
	public void setNumTropasPodeMover(int numTropasPodeMover) {
		this.numTropasPodeMover = numTropasPodeMover;
	}
	
}
