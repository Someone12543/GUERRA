package model;

import java.awt.Image;

class Objetivo {
	String descricao;
	int id;
	Image toDisplay;
	
	public Objetivo(int id, Image _ref)
	{
		this.id = id;
		this.toDisplay = _ref;
		switch(id)
		{
		case 1:
			this.descricao = "Conquistar na totalidade a Asia e a Africa";
			break;
		case 2:
			this.descricao = "Conquistar na totalidade Asia e America do Sul";
			break;
		case 3:
			this.descricao = "Conquistar na totalidade a America do Norte e a Africa";
			break;
		case 4:
			this.descricao = "Conquistar na totalidade a America do Norte e a Oceania";
			break;
		case 5:
			this.descricao = "Conquistar na totalidade a Europa, a Oceania e mais um continente a sua escolha";
			break;
		case 6:
			this.descricao = "Conquistar na totalidade a Europa, a America do Sul e mais um continente a sua escolha";
			break;
		case 7:
			this.descricao = "Conquistar 18 territorios com pelo menos 2 exercitos em cada";
			break;
		case 8:
			this.descricao = "Destruir todos os exércitos Amarelo";
			break;
		case 9:
			this.descricao = "Destruir todos os exércitos Azul";
			break;
		case 10:
			this.descricao = "Destruir todos os exércitos Branco";
			break;
		case 11:
			this.descricao = "Destruir todos os exércitos Verde";
			break;
		case 12:
			this.descricao = "Destruir todos os exércitos Vermelho";
			break;
		case 13:
			this.descricao = "Destruir todos os exércitos Preto";
			break;
		default:
			this.descricao = "Conquistar 24 territorios a sua escolha";
		}
	}
}
