package view;

import java.awt.geom.Ellipse2D;

class Exercito {
	Ellipse2D elip;
	int number, color;
	float x, y, w = 20.0f, h = 20.0f;
	String nome;
	
	//Criação de unidade de exército
	//Guardando sua posição no mapa, cor, 
	//quantidade de exércitos e nome do seu respectivo território
	public Exercito(float pos_x, float pos_y, int color, String nome) {
		this.x = pos_x;
		this.y = pos_y;
		this.elip = new Ellipse2D.Double(x, y, w, h);
		this.color = color;
		this.number = 1;
		this.nome = nome;
	}
	
	
}
