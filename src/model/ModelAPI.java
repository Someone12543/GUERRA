package model;

import java.util.ArrayList;

public class ModelAPI {
	
	public static ArrayList<Continente> listaContinente = new ArrayList<Continente>();
	public static ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
	
	public static boolean setupGame()
	{
		setupContinents(listaContinente);
		
		return true;
	}
	
	public static boolean addPlayer(int cor)
	{
		listaJogadores.add(new Jogador(cor, new ArrayList<Territorio>()));
		return true;
	}
	
	public static String mock()
	{
		return listaContinente.get(0).nome;
	}
	
	private static boolean setupContinents(ArrayList<Continente> listCont) 
	{
		listCont.add(new Continente("África", Continente.Continentes.AFRICA, new ArrayList<Territorio>()));
		setupPaises(listCont.get(0));
		
		listCont.add(new Continente("América do Norte", Continente.Continentes.AMNORTE, new ArrayList<Territorio>()));
		setupPaises(listCont.get(1));
		
		listCont.add(new Continente("América do Sul", Continente.Continentes.AMSUL, new ArrayList<Territorio>()));
		setupPaises(listCont.get(2));
		
		listCont.add(new Continente("Ásia", Continente.Continentes.ASIA, new ArrayList<Territorio>()));
		setupPaises(listCont.get(3));
		
		listCont.add(new Continente("Europa", Continente.Continentes.EUROPA, new ArrayList<Territorio>()));
		setupPaises(listCont.get(4));
		
		listCont.add(new Continente("Oceania", Continente.Continentes.OCEANIA, new ArrayList<Territorio>()));
		setupPaises(listCont.get(5));
		
		return true;
	}
	
	private static boolean setupPaises(Continente c)
	{
		switch(c.tipo.ordinal())
		{
		case 0:
			c.paises.add(new Territorio("África do Sul", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Angola", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Argélia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Egito", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Nigéria", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Somália", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 1:
			c.paises.add(new Territorio("Alasca", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Calgary", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Califórnia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Groelândia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("México", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Nova York", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Quebec", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Texas", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Vancouver", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 2:
			c.paises.add(new Territorio("Argentina", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Brasil", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Peru", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Venezuela", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 3:
			c.paises.add(new Territorio("Arábia Saudita", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Bangladesh", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Cazaquistão", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("China", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Coréia do Norte", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Coréia do Sul", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Estônia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Índia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Irã", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Iraque", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Japão", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Jordânia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Letônia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Mongólia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Paquistão", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Russía", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Sibéria", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Síria", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Tailândia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Turquia", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 4:
			c.paises.add(new Territorio("Espanha", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("França", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Itália", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Polônia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Reino Unido", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Romênia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Suécia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Ucrânia", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 5:
			c.paises.add(new Territorio("Austrália", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Indonésia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Nova Zelândia", c, 0, new ArrayList<Territorio>(), 0));
			c.paises.add(new Territorio("Perth", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		default:
			return false;
		}
	}

}