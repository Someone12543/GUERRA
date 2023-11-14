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
	
	int bonusPiece(Jogador j){
		for (Territorio t : this.paises){
			if (!(j.paisesDominados.contains(t))){
				return 0;
			}
		}
		return this.bonus;
	}
}
