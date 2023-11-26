package model;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

class Jogador {
	String nome;
	Cores cor; //cor do jogador no enum
	Objetivo obj; //obj do jogador
	ArrayList<Troca> mao; //cartas do jogador
	ArrayList<Territorio> paisesDominados;
	ArrayList<Cores> jogadoresEliminados; //cores do jogadores que o jogador eliminou
	int numTropasPosicionar; //numero de tropas que o jogador tem para posicionar
	int[] numTropasContinentes = new int[6]; //numero de tropas de bonus dos continentes do jogador para posicionar
	boolean dominouPaisTurno;
	boolean primeiraJogada;
	
	public Jogador(String nome, Cores cor) {
		this.nome = nome;
		this.cor = cor;
		this.mao = new ArrayList<Troca>();
		this.paisesDominados = new ArrayList<Territorio>();
		this.jogadoresEliminados = new ArrayList<Cores>();
		this.numTropasPosicionar = 0;
		this.dominouPaisTurno = false;
		this.primeiraJogada = true;
	}
	
	// metodo para posicionar tropas
	boolean posicionarTropas(Territorio pais, int qtd, Continentes cont) {
		if (pais.corDominando != this.cor) {
			System.out.println("O pais não pertence ao Jogador");
			return false;
		}
		
		if (qtd <= 0) {
			System.out.println("Não se pode posicionar menos que 1 tropa");
			return false;
		}
		
		
		if (cont == null) {
			if (qtd > this.numTropasPosicionar) {
				System.out.println("Tropas insuficientes");
				return false;
			}
			
			pais.numTropas += qtd;
			this.numTropasPosicionar -= qtd;
		}
		else {
			int temp = this.numTropasContinentes[cont.ordinal()];
			
			if (temp == 0) {
				System.out.println("Sem tropas para distribuir nesse continente.");
				return false;
			}
			
			if (qtd > temp) {
				System.out.println("Tropas insuficientes");
				return false;
			}
			

			pais.numTropas += qtd;
			this.numTropasContinentes[cont.ordinal()] -= qtd;
			
		}
		
		//notificando via observer os observadores que houve uma mudança na quantidade de tropas do pais
		ModelAPI.getModelAPI().prepareNotify(pais);
		
		return true;
	}
	
	
	
	
	int bonusPiece(){
		int numPecas = this.paisesDominados.size()/2;
		if (numPecas < 3){
			numPecas = 3;
		}
		return numPecas;
	}
}
