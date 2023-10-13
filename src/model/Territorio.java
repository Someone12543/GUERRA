package model;
import java.util.ArrayList;

public class Territorio {
	String nome;
	Continente continente;
	int numTropas;
	int numTropasPodeMover;
	int corDominando;
	ArrayList<Territorio> paisesLigados;
	
	public Territorio(String nome, Continente continente, int numTropas, ArrayList<Territorio> paisesLigados, int numTropasPodeMover) {
		this.nome = nome;
		this.continente = continente;
		this.numTropas = numTropas;
		this.paisesLigados = paisesLigados;
		this.numTropasPodeMover = numTropasPodeMover;
	}
}
