package model;
import java.util.ArrayList;

class Continente {
	String nome;
	Continentes tipo;
	ArrayList<Territorio> paises;
	
	public Continente(String nome, Continentes tipo, ArrayList<Territorio> paises) {
		this.nome = nome;
		this.tipo = tipo;
		this.paises = paises;
	}
	
	public enum Continentes
	{
		AFRICA, AMNORTE, AMSUL, ASIA,EUROPA, OCEANIA;
	}
}
