package model;
import java.util.ArrayList;

class Continente {
	String nome;
	
	//Continente equivalente do enum Continentes
	Continentes tipo;
	
	//lista de territorios do continente
	ArrayList<Territorio> paises;
	
	//bonus de peças que o continente da se tiver capturado todo ele
	int bonus;
	
	public Continente(String nome, Continentes tipo, int bonus) {
		this.nome = nome;
		this.tipo = tipo;
		this.paises = new ArrayList<Territorio>();
		this.bonus = bonus;
	}
	
	//funcao que checa se o jogador j capturou todo o continente, se sim da as pecas bonus
	int bonusPiece(Jogador j){
		for (Territorio t : this.paises){
			if (!(j.paisesDominados.contains(t))){
				return 0;
			}
		}
		return this.bonus;
	}
}
