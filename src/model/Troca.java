package model;

import java.awt.Image;

class Troca {
	Territorio representa;
	Simbolo simbolo;
	Image toDisplay;
	
	public Troca(Territorio representa, int simbolo, Image _ref)
	{
		this.representa = representa;
		this.simbolo = Simbolo.values()[simbolo];
		this.toDisplay = _ref;
	}
	
	enum Simbolo
	{
		Triangulo, Quadrado, Circulo, Coringa;
	}
}
