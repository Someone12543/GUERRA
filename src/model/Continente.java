package model;
import java.util.ArrayList;

class Continente {
	private String nome;
	private Continentes tipo;
	private ArrayList<Territorio> paises;
	
	public Continente(String nome, Continentes tipo, ArrayList<Territorio> paises) {
		this.nome = nome;
		this.tipo = tipo;
		this.paises = paises;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Continentes getType()
	{
		return tipo;
	}
	
	public void insertPais(Territorio pais){
		paises.add(pais);
	}
	
	public ArrayList<Territorio> getPaises(){
		return paises;
	}
	
	public enum Continentes
	{
		AFRICA, AMNORTE, AMSUL, ASIA,EUROPA, OCEANIA;
	}
}
