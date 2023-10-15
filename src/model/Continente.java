package model;
import java.util.ArrayList;

class Continente {
	String nome;
	Continentes tipo;
	ArrayList<Territorio> paises;
	int bonus;
	
	public Continente(String nome, Continentes tipo, ArrayList<Territorio> paises, int bonus) {
		this.nome = nome;
		this.tipo = tipo;
		this.paises = paises;
		this.bonus = bonus;
	}
	
	public enum Continentes
	{
		AFRICA, AMNORTE, AMSUL, ASIA, EUROPA, OCEANIA;
	}
}
