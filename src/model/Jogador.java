package model;
import java.util.ArrayList;

class Jogador {
	String nome;
	Cores cor;
	Objetivo obj;
	ArrayList<Troca> mao;
	ArrayList<Territorio> paisesDominados;
	ArrayList<Jogador> jogadoresEliminados;
	int numTropasPosicionar;
	
	public Jogador(String nome, Cores cor) {
		this.nome = nome;
		this.cor = cor;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = new ArrayList<Territorio>();
	}

}
