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
}
