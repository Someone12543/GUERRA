package model;

import java.util.ArrayList;
import java.util.Collections;

public class ModelAPI {
	
	public static ArrayList<Continente> listaContinente = new ArrayList<Continente>();
	public static ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
	public static ArrayList<Objetivo> deckObjetivos = new ArrayList<Objetivo>();
	public static ArrayList<Troca> deckTroca = new ArrayList<Troca>();
	
	public static boolean setupGame()
	{
		setupContinents(listaContinente);
		setupCards();
		
		return true;
	}
	
	public static boolean drawObjectives()
	{
		Objetivo obj;
		
		for (Jogador j : listaJogadores)
		{
			obj = deckObjetivos.get(deckObjetivos.size() - 1);
			deckObjetivos.remove(obj);
			
			if (obj.id >= 8) // se destruir exercito especifico
			{
				if (obj.id - 8 == j.cor.ordinal() || !existPlayerColor(obj.id - 8)) // se voce mesmo ou se nao existe
				{
					obj = new Objetivo(0, null); // entao troca objetivo
				}
			}
			
			j.obj = obj;
		}
		
		return true;
	}
	
	public static Troca drawTrade()
	{
		Troca obj = deckTroca.get(deckTroca.size() - 1);
		deckTroca.remove(obj);
		return obj;
	}
	
	private static boolean existPlayerColor(int cor) 
	{
		for (Jogador k : listaJogadores) // checa cada jogador existente
		{
			if(k.cor.ordinal() == cor) // se existe a cor
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean addPlayer(String nome, int cor)
	{
		Jogador newPlayer = new Jogador(nome, Cores.values()[cor]);
		listaJogadores.add(newPlayer);
		return true;
	}
	
	public static String mock()
	{
		return listaContinente.get(0).nome;
	}
	
	private static boolean setupCards()
	{
		//remover loop para adicionar as imagens de cada
		for (int i = 0; i <= 13; i++)
			deckObjetivos.add(new Objetivo(i, null));
		
		Collections.shuffle(deckObjetivos);
		
		for(Continente c : listaContinente)
			for(Territorio p : c.paises)
				deckTroca.add(new Troca(p, 0, null));
		
		//africa
		deckTroca.get(0).simbolo = Simbolo.Triangulo;
		deckTroca.get(1).simbolo = Simbolo.Quadrado;
		deckTroca.get(2).simbolo = Simbolo.Circulo;
		deckTroca.get(3).simbolo = Simbolo.Triangulo;
		deckTroca.get(4).simbolo = Simbolo.Circulo;
		deckTroca.get(5).simbolo = Simbolo.Quadrado;
		
		//america do norte
		deckTroca.get(6).simbolo = Simbolo.Triangulo;
		deckTroca.get(7).simbolo = Simbolo.Circulo;
		deckTroca.get(8).simbolo = Simbolo.Quadrado;
		deckTroca.get(9).simbolo = Simbolo.Circulo;
		deckTroca.get(10).simbolo = Simbolo.Quadrado;
		deckTroca.get(11).simbolo = Simbolo.Quadrado;
		deckTroca.get(12).simbolo = Simbolo.Circulo;
		deckTroca.get(13).simbolo = Simbolo.Triangulo;
		deckTroca.get(14).simbolo = Simbolo.Triangulo;
		
		//america do sul
		deckTroca.get(15).simbolo = Simbolo.Quadrado;
		deckTroca.get(16).simbolo = Simbolo.Circulo;
		deckTroca.get(17).simbolo = Simbolo.Triangulo;
		deckTroca.get(18).simbolo = Simbolo.Triangulo;
		
		//asia
		deckTroca.get(19).simbolo = Simbolo.Circulo;
		deckTroca.get(20).simbolo = Simbolo.Circulo;
		deckTroca.get(21).simbolo = Simbolo.Circulo;
		deckTroca.get(22).simbolo = Simbolo.Quadrado;
		deckTroca.get(23).simbolo = Simbolo.Quadrado;
		deckTroca.get(24).simbolo = Simbolo.Triangulo;
		deckTroca.get(25).simbolo = Simbolo.Circulo;
		deckTroca.get(26).simbolo = Simbolo.Triangulo;
		deckTroca.get(27).simbolo = Simbolo.Quadrado;
		deckTroca.get(28).simbolo = Simbolo.Triangulo;
		deckTroca.get(29).simbolo = Simbolo.Circulo;
		deckTroca.get(30).simbolo = Simbolo.Quadrado;
		deckTroca.get(31).simbolo = Simbolo.Quadrado;
		deckTroca.get(32).simbolo = Simbolo.Triangulo;
		deckTroca.get(33).simbolo = Simbolo.Circulo;
		deckTroca.get(34).simbolo = Simbolo.Triangulo;
		deckTroca.get(35).simbolo = Simbolo.Quadrado;
		deckTroca.get(36).simbolo = Simbolo.Quadrado;
		deckTroca.get(37).simbolo = Simbolo.Triangulo;
		deckTroca.get(38).simbolo = Simbolo.Triangulo;
		
		//europa
		deckTroca.get(39).simbolo = Simbolo.Circulo;
		deckTroca.get(40).simbolo = Simbolo.Triangulo;
		deckTroca.get(41).simbolo = Simbolo.Quadrado;
		deckTroca.get(42).simbolo = Simbolo.Triangulo;
		deckTroca.get(43).simbolo = Simbolo.Circulo;
		deckTroca.get(44).simbolo = Simbolo.Triangulo;
		deckTroca.get(45).simbolo = Simbolo.Quadrado;
		deckTroca.get(46).simbolo = Simbolo.Circulo;
		
		//oceania
		deckTroca.get(47).simbolo = Simbolo.Triangulo;
		deckTroca.get(48).simbolo = Simbolo.Triangulo;
		deckTroca.get(49).simbolo = Simbolo.Quadrado;
		deckTroca.get(50).simbolo = Simbolo.Circulo;
		
		//coringas
		deckTroca.add(new Troca(null, Simbolo.Coringa.ordinal(), null));
		deckTroca.add(new Troca(null, Simbolo.Coringa.ordinal(), null));
		
		Collections.shuffle(deckTroca);
		return true;
	}
	
	private static boolean setupContinents(ArrayList<Continente> listCont) 
	{
		listCont.add(new Continente("África", Continentes.AFRICA, new ArrayList<Territorio>(), 3));
		listCont.add(new Continente("América do Norte", Continentes.AMNORTE, new ArrayList<Territorio>(), 5));
		listCont.add(new Continente("América do Sul", Continentes.AMSUL, new ArrayList<Territorio>(), 2));
		listCont.add(new Continente("Ásia", Continentes.ASIA, new ArrayList<Territorio>(), 7));
		listCont.add(new Continente("Europa", Continentes.EUROPA, new ArrayList<Territorio>(), 5));
		listCont.add(new Continente("Oceania", Continentes.OCEANIA, new ArrayList<Territorio>(), 2));
		
		for (Continente c : listCont)
			setupPaises(c);
		
		return true;
	}
	
	private static boolean setupPaises(Continente c)
	{
		switch(c.tipo.ordinal())
		{
		case 0:
			c.paises.add(new Territorio("África do Sul", c));
			c.paises.add(new Territorio("Angola", c));
			c.paises.add(new Territorio("Argélia", c));
			c.paises.add(new Territorio("Egito", c));
			c.paises.add(new Territorio("Nigéria", c));
			c.paises.add(new Territorio("Somália", c));
			return true;
		case 1:
			c.paises.add(new Territorio("Alasca", c));
			c.paises.add(new Territorio("Calgary", c));
			c.paises.add(new Territorio("Califórnia", c));
			c.paises.add(new Territorio("Groelândia", c));
			c.paises.add(new Territorio("México", c));
			c.paises.add(new Territorio("Nova York", c));
			c.paises.add(new Territorio("Quebec", c));
			c.paises.add(new Territorio("Texas", c));
			c.paises.add(new Territorio("Vancouver", c));
			return true;
		case 2:
			c.paises.add(new Territorio("Argentina", c));
			c.paises.add(new Territorio("Brasil", c));
			c.paises.add(new Territorio("Peru", c));
			c.paises.add(new Territorio("Venezuela", c));
			return true;
		case 3:
			c.paises.add(new Territorio("Arábia Saudita", c));
			c.paises.add(new Territorio("Bangladesh", c));
			c.paises.add(new Territorio("Cazaquistão", c));
			c.paises.add(new Territorio("China", c));
			c.paises.add(new Territorio("Coréia do Norte", c));
			c.paises.add(new Territorio("Coréia do Sul", c));
			c.paises.add(new Territorio("Estônia", c));
			c.paises.add(new Territorio("Índia", c));
			c.paises.add(new Territorio("Irã", c));
			c.paises.add(new Territorio("Iraque", c));
			c.paises.add(new Territorio("Japão", c));
			c.paises.add(new Territorio("Jordânia", c));
			c.paises.add(new Territorio("Letônia", c));
			c.paises.add(new Territorio("Mongólia", c));
			c.paises.add(new Territorio("Paquistão", c));
			c.paises.add(new Territorio("Russía", c));
			c.paises.add(new Territorio("Sibéria", c));
			c.paises.add(new Territorio("Síria", c));
			c.paises.add(new Territorio("Tailândia", c));
			c.paises.add(new Territorio("Turquia", c));
			return true;
		case 4:
			c.paises.add(new Territorio("Espanha", c));
			c.paises.add(new Territorio("França", c));
			c.paises.add(new Territorio("Itália", c));
			c.paises.add(new Territorio("Polônia", c));
			c.paises.add(new Territorio("Reino Unido", c));
			c.paises.add(new Territorio("Romênia", c));
			c.paises.add(new Territorio("Suécia", c));
			c.paises.add(new Territorio("Ucrânia", c));
			return true;
		case 5:
			c.paises.add(new Territorio("Austrália", c));
			c.paises.add(new Territorio("Indonésia", c));
			c.paises.add(new Territorio("Nova Zelândia", c));
			c.paises.add(new Territorio("Perth", c));
			return true;
		default:
			return false;
		}
	}

	public int pecasBonus(Jogador j){
		int numPecas = j.paisesDominados.size()/2;
		if (numPecas < 3){
			numPecas = 3;
		}
		return numPecas;
	}

	public int pecasBonus(Jogador j, Continente continente){
		for (Territorio t : continente.paises){
			if (!(j.paisesDominados.contains(t))){
				return 0;
			}
		}
		return continente.bonus;
	}
}
