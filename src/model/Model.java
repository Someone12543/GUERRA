package model;

import java.util.ArrayList;

public class Model {
	
	public static ArrayList<Continente> listaContinente = new ArrayList<Continente>();
	
	public static boolean setupGame()
	{
		setupContinents(listaContinente);
		
		return true;
	}
	
	public static String mock()
	{
		return listaContinente.get(0).getNome();
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
		switch(c.getType().ordinal())
		{
		case 0:
			c.insertPais(new Territorio("África do Sul", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Angola", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Argélia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Egito", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Nigéria", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Somália", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 1:
			c.insertPais(new Territorio("Alasca", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Calgary", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Califórnia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Groelândia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("México", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Nova York", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Quebec", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Texas", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Vancouver", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 2:
			c.insertPais(new Territorio("Argentina", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Brasil", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Peru", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Venezuela", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 3:
			c.insertPais(new Territorio("Arábia Saudita", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Bangladesh", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Cazaquistão", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("China", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Coréia do Norte", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Coréia do Sul", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Estônia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Índia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Irã", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Iraque", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Japão", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Jordânia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Letônia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Mongólia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Paquistão", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Russía", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Sibéria", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Síria", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Tailândia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Turquia", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 4:
			c.insertPais(new Territorio("Espanha", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("França", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Itália", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Polônia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Reino Unido", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Romênia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Suécia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Ucrânia", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		case 5:
			c.insertPais(new Territorio("Austrália", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Indonésia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Nova Zelândia", c, 0, new ArrayList<Territorio>(), 0));
			c.insertPais(new Territorio("Perth", c, 0, new ArrayList<Territorio>(), 0));
			return true;
		default:
			return false;
		}
	}

}