package model;

import java.awt.Image;

class Troca extends Carta {
	Territorio representa;
	Simbolo simbolo;
	
	public Troca(Territorio representa, int simbolo, Image a)
	{
		this.representa = representa;
		this.simbolo = Simbolo.values()[simbolo];
	}
	
	enum Simbolo
	{
		Triangulo, Quadrado, Circulo, Coringa;
	}
}
