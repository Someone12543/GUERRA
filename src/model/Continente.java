package model;
import java.util.ArrayList;

class Continente {
	String nome;
	Continentes tipo;
	ArrayList<Territorio> paises;
	int bonus;
	
	public Continente(String nome, Continentes tipo, int bonus) {
		this.nome = nome;
		this.tipo = tipo;
		this.paises = new ArrayList<Territorio>();
		this.bonus = bonus;
	}
}
