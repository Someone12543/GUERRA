package model;

import java.awt.Image;

class Troca {
	Territorio representa;
	Simbolo simbolo;
	Image toDisplay;
	
	public Troca(Territorio representa, Simbolo simbolo, Image _ref)
	{
		this.representa = representa;
		this.simbolo = simbolo;
		this.toDisplay = _ref;
	}
}
