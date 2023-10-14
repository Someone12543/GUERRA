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
	
	public static boolean addPlayer(int cor)
	{
		Jogador newPlayer = new Jogador(Jogador.Cores.values()[cor], null, new ArrayList<Territorio>());
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
		deckTroca.get(0).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(1).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(2).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(3).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(4).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(5).simbolo = Troca.Simbolo.Quadrado;
		
		//america do norte
		deckTroca.get(6).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(7).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(8).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(9).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(10).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(11).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(12).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(13).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(14).simbolo = Troca.Simbolo.Triangulo;
		
		//america do sul
		deckTroca.get(15).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(16).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(17).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(18).simbolo = Troca.Simbolo.Triangulo;
		
		//asia
		deckTroca.get(19).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(20).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(21).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(22).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(23).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(24).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(25).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(26).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(27).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(28).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(29).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(30).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(31).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(32).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(33).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(34).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(35).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(36).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(37).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(38).simbolo = Troca.Simbolo.Triangulo;
		
		//europa
		deckTroca.get(39).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(40).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(41).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(42).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(43).simbolo = Troca.Simbolo.Circulo;
		deckTroca.get(44).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(45).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(46).simbolo = Troca.Simbolo.Circulo;
		
		//oceania
		deckTroca.get(47).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(48).simbolo = Troca.Simbolo.Triangulo;
		deckTroca.get(49).simbolo = Troca.Simbolo.Quadrado;
		deckTroca.get(50).simbolo = Troca.Simbolo.Circulo;
		
		//coringas
		deckTroca.add(new Troca(null, Troca.Simbolo.Coringa.ordinal(), null));
		deckTroca.add(new Troca(null, Troca.Simbolo.Coringa.ordinal(), null));
		
		Collections.shuffle(deckTroca);
		return true;
	}
	
	private static boolean setupContinents(ArrayList<Continente> listCont) 
	{
		listCont.add(new Continente("África", Continente.Continentes.AFRICA, new ArrayList<Territorio>()));
		listCont.add(new Continente("América do Norte", Continente.Continentes.AMNORTE, new ArrayList<Territorio>()));
		listCont.add(new Continente("América do Sul", Continente.Continentes.AMSUL, new ArrayList<Territorio>()));
		listCont.add(new Continente("Ásia", Continente.Continentes.ASIA, new ArrayList<Territorio>()));
		listCont.add(new Continente("Europa", Continente.Continentes.EUROPA, new ArrayList<Territorio>()));
		listCont.add(new Continente("Oceania", Continente.Continentes.OCEANIA, new ArrayList<Territorio>()));
		
		for (Continente c : listCont)
			setupPaises(c);
		
		return true;
	}
	
	private static boolean setupPaises(Continente c)
	{
		switch(c.tipo.ordinal())
		{
		case 0:
			c.paises.add(new Territorio("África do Sul", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Angola", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Argélia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Egito", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Nigéria", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Somália", c, 0, new ArrayList<Territorio>()));
			return true;
		case 1:
			c.paises.add(new Territorio("Alasca", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Calgary", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Califórnia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Groelândia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("México", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Nova York", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Quebec", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Texas", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Vancouver", c, 0, new ArrayList<Territorio>()));
			return true;
		case 2:
			c.paises.add(new Territorio("Argentina", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Brasil", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Peru", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Venezuela", c, 0, new ArrayList<Territorio>()));
			return true;
		case 3:
			c.paises.add(new Territorio("Arábia Saudita", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Bangladesh", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Cazaquistão", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("China", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Coréia do Norte", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Coréia do Sul", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Estônia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Índia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Irã", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Iraque", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Japão", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Jordânia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Letônia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Mongólia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Paquistão", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Russía", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Sibéria", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Síria", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Tailândia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Turquia", c, 0, new ArrayList<Territorio>()));
			return true;
		case 4:
			c.paises.add(new Territorio("Espanha", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("França", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Itália", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Polônia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Reino Unido", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Romênia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Suécia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Ucrânia", c, 0, new ArrayList<Territorio>()));
			return true;
		case 5:
			c.paises.add(new Territorio("Austrália", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Indonésia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Nova Zelândia", c, 0, new ArrayList<Territorio>()));
			c.paises.add(new Territorio("Perth", c, 0, new ArrayList<Territorio>()));
			return true;
		default:
			return false;
		}
	}
}