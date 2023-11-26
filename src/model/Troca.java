package model;

import java.awt.Image;

//classes para as cartas de troca
class Troca {
	Territorio representa; //territorio que a carta representa
	Simbolo simbolo; //simbolo da carta
	Image toDisplay; //imagem da carta
	
	public Troca(Territorio representa, Simbolo simbolo, Image _ref)
	{
		this.representa = representa;
		this.simbolo = simbolo;
		this.toDisplay = _ref;
	}
}
