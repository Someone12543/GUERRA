package model;
import java.util.ArrayList;

class Territorio {
	String nome;
	Continente continente;
	int numTropas;
	int corDominando;
	ArrayList<Territorio> paisesLigados;
	
	public Territorio(String nome, Continente continente, int numTropas, ArrayList<Territorio> paisesLigados) {
		this.nome = nome;
		this.continente = continente;
		this.numTropas = numTropas;
		this.paisesLigados = paisesLigados;
	}
}
