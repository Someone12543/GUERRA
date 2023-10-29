package model;

import controller.ControllerAPI;
import java.util.ArrayList;
import java.util.Collections;

public class ModelAPI {
	
	static ModelAPI instance;
	
	ArrayList<Continente> listaContinente;
	ArrayList<Jogador> listaJogadores;
	ArrayList<Objetivo> deckObjetivos;
	ArrayList<Troca> deckTroca;
	
	private ModelAPI()
	{
		this.listaContinente = new ArrayList<Continente>();
		this.listaJogadores = new ArrayList<Jogador>();
		this.deckObjetivos = new ArrayList<Objetivo>();
		this.deckTroca = new ArrayList<Troca>();
	}
	
	public static ModelAPI getModelAPI()
	{
		if (instance == null)
			instance = new ModelAPI();
		return instance;
	}
	
	public boolean addPlayer(String nome, int cor)
	{
		Jogador newPlayer = new Jogador(nome, Cores.values()[cor]);
		listaJogadores.add(newPlayer);
		return true;
	}

	public Troca drawTrade()
	{
		if (deckTroca.size() == 0)
			return null;
		Troca obj = deckTroca.get(deckTroca.size() - 1);
		deckTroca.remove(obj);
		return obj;
	}
	
	public int bonusPiece(Jogador j){
		int numPecas = j.paisesDominados.size()/2;
		if (numPecas < 3){
			numPecas = 3;
		}
		return numPecas;
	}

	public int bonusPiece(Jogador j, Continente continente){
		for (Territorio t : continente.paises){
			if (!(j.paisesDominados.contains(t))){
				return 0;
			}
		}
		return continente.bonus;
	}
	
	public void setupGame()
	{
		setupContinents(listaContinente);
		setupCards();
		
		drawObjectives();
		rafflePlayers();
		raffleTerritory();
	}
	
	public boolean validateTrade(Troca carta1, Troca carta2, Troca carta3)
	{
		if (carta1.simbolo == Simbolo.Coringa || carta2.simbolo == Simbolo.Coringa || carta3.simbolo == Simbolo.Coringa)
			return true;
		
		if (carta1.simbolo == carta2.simbolo) {
			if (carta2.simbolo == carta3.simbolo)
				return true;
		}
		else if (carta2.simbolo != carta3.simbolo && carta1.simbolo != carta3.simbolo)
			return true;
			
		return false;
	}

	void drawObjectives()
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
	}
	
	boolean existPlayerColor(int cor) 
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
	
	void rafflePlayers()
	{
		Collections.shuffle(listaJogadores);
	}
	
	void raffleTerritory()
	{
		Troca card;
		int id = 0;
		
		while((card = drawTrade()) != null)
		{
			if (card.simbolo != Simbolo.Coringa) {
				card.representa.numTropas = 1;
				card.representa.corDominando = listaJogadores.get(id).cor;
				listaJogadores.get(id).paisesDominados.add(card.representa);
			}
			listaJogadores.get(id).mao.add(card);
			id++;
			if (id >= listaJogadores.size())
				id = 0;
 		}
		
		for(Jogador j : listaJogadores)
			for(Troca t : j.mao)
			{
				deckTroca.add(t);
				j.mao.remove(t);
			}
		
		Collections.shuffle(deckTroca);
	}
	
	boolean trade(Jogador id, Troca c1, Troca c2, Troca c3) {
		if (validateTrade(c1, c2, c3)) {
			ArrayList<Troca> temp = new ArrayList<Troca>();
			
			id.mao.remove(c1);
			id.mao.remove(c2);
			id.mao.remove(c3);
			
			temp.add(c1);
			temp.add(c2);
			temp.add(c3);
			
			Collections.shuffle(temp);
			
			deckTroca.add(0, c1);
			deckTroca.add(0, c2);
			deckTroca.add(0, c3);
			
			int x;
			char n = ControllerAPI.getControllerAPI().troca_atual++;
			
			if (n < 6) x = 2 + n;
			else x = 5 * (n - 3);
			
			
			id.numTropasPosicionar += x;
			
			return true;
		}
		
		return false;
	}
	
	boolean setupCards()
	{
		//remover loop para adicionar as imagens de cada
		for (int i = 0; i <= 13; i++)
			deckObjetivos.add(new Objetivo(i, null));
		
		Collections.shuffle(deckObjetivos);
		
		for(Continente c : listaContinente)
			for(Territorio p : c.paises)
				deckTroca.add(new Troca(p, null, null));
		
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
		deckTroca.add(new Troca(null, Simbolo.Coringa, null));
		deckTroca.add(new Troca(null, Simbolo.Coringa, null));
		
		Collections.shuffle(deckTroca);
		return true;
	}
	
	boolean setupContinents(ArrayList<Continente> listCont) 
	{
		listCont.add(new Continente("África", Continentes.AFRICA, 3));
		listCont.add(new Continente("América do Norte", Continentes.AMNORTE, 5));
		listCont.add(new Continente("América do Sul", Continentes.AMSUL, 2));
		listCont.add(new Continente("Ásia", Continentes.ASIA, 7));
		listCont.add(new Continente("Europa", Continentes.EUROPA, 5));
		listCont.add(new Continente("Oceania", Continentes.OCEANIA, 2));
		
		
		setupPaises(listCont);
		
		return true;
	}
	
	boolean setupPaises(ArrayList<Continente> listCont)
	{
		Territorio AfSul = null, Ang = null, Argel = null, Egi = null, Nig = null, Som = null,
		Ala = null, Calg = null, Cali = null, Gro = null, Mex = null, NY = null, Que = null,
		Tex = null, Van = null, Argen = null, Bra = null, Peru = null, Ven = null, ArSau = null,
		Ban = null, Caz = null, Chi = null, CorNor = null, CorSul = null, Est = null, Indi = null,
		Ira = null, Iraq = null, Jap = null, Jor = null, Let = null, Mon = null,
		Paq = null, Rus = null, Sib = null, Sir = null, Tai = null, Tur = null,
		Esp = null, Fra = null, Ita = null, Pol = null, ReiUni = null, Rom = null,
		Sue = null, Ucr = null, Aus = null, Indo = null, NZ = null, Per = null;
		
		for (Continente c : listCont) {
			switch(c.tipo)
			{
			case AFRICA:
				c.paises.add(AfSul = new Territorio("África do Sul", c));
				c.paises.add(Ang = new Territorio("Angola", c));
				c.paises.add(Argel = new Territorio("Argélia", c));
				c.paises.add(Egi = new Territorio("Egito", c));
				c.paises.add(Nig = new Territorio("Nigéria", c));
				c.paises.add(Som = new Territorio("Somália", c));
				break;
			case AMNORTE:
				c.paises.add(Ala = new Territorio("Alasca", c));
				c.paises.add(Calg = new Territorio("Calgary", c));
				c.paises.add(Cali = new Territorio("Califórnia", c));
				c.paises.add(Gro = new Territorio("Groelândia", c));
				c.paises.add(Mex = new Territorio("México", c));
				c.paises.add(NY = new Territorio("Nova York", c));
				c.paises.add(Que = new Territorio("Quebec", c));
				c.paises.add(Tex = new Territorio("Texas", c));
				c.paises.add(Van = new Territorio("Vancouver", c));
				break;
			case AMSUL:
				c.paises.add(Argen = new Territorio("Argentina", c));
				c.paises.add(Bra = new Territorio("Brasil", c));
				c.paises.add(Peru = new Territorio("Peru", c));
				c.paises.add(Ven = new Territorio("Venezuela", c));
				break;
			case ASIA:
				c.paises.add(ArSau = new Territorio("Arábia Saudita", c));
				c.paises.add(Ban = new Territorio("Bangladesh", c));
				c.paises.add(Caz = new Territorio("Cazaquistão", c));
				c.paises.add(Chi = new Territorio("China", c));
				c.paises.add(CorNor = new Territorio("Coréia do Norte", c));
				c.paises.add(CorSul = new Territorio("Coréia do Sul", c));
				c.paises.add(Est = new Territorio("Estônia", c));
				c.paises.add(Indi = new Territorio("Índia", c));
				c.paises.add(Ira = new Territorio("Irã", c));
				c.paises.add(Iraq = new Territorio("Iraque", c));
				c.paises.add(Jap = new Territorio("Japão", c));
				c.paises.add(Jor = new Territorio("Jordânia", c));
				c.paises.add(Let = new Territorio("Letônia", c));
				c.paises.add(Mon = new Territorio("Mongólia", c));
				c.paises.add(Paq = new Territorio("Paquistão", c));
				c.paises.add(Rus = new Territorio("Russía", c));
				c.paises.add(Sib = new Territorio("Sibéria", c));
				c.paises.add(Sir = new Territorio("Síria", c));
				c.paises.add(Tai = new Territorio("Tailândia", c));
				c.paises.add(Tur = new Territorio("Turquia", c));
				break;
			case EUROPA:
				c.paises.add(Esp = new Territorio("Espanha", c));
				c.paises.add(Fra = new Territorio("França", c));
				c.paises.add(Ita = new Territorio("Itália", c));
				c.paises.add(Pol = new Territorio("Polônia", c));
				c.paises.add(ReiUni = new Territorio("Reino Unido", c));
				c.paises.add(Rom = new Territorio("Romênia", c));
				c.paises.add(Sue = new Territorio("Suécia", c));
				c.paises.add(Ucr = new Territorio("Ucrânia", c));
				break;
			case OCEANIA:
				c.paises.add(Aus = new Territorio("Austrália", c));
				c.paises.add(Indo = new Territorio("Indonésia", c));
				c.paises.add(NZ = new Territorio("Nova Zelândia", c));
				c.paises.add(Per = new Territorio("Perth", c));
				break;
			default:
				return false;
			}
		}
			
		// AMNORTE
		
		Ala.paisesLigados.add(Calg);
		Ala.paisesLigados.add(Van);
		Ala.paisesLigados.add(Sib);
		
		Calg.paisesLigados.add(Ala);
		Calg.paisesLigados.add(Van);
		Calg.paisesLigados.add(Gro);
		
		Gro.paisesLigados.add(Calg);
		Gro.paisesLigados.add(Que);
		Gro.paisesLigados.add(ReiUni);
		
		Van.paisesLigados.add(Ala);
		Van.paisesLigados.add(Calg);
		Van.paisesLigados.add(Que);
		Van.paisesLigados.add(Cali);
		Van.paisesLigados.add(Tex);
		
		Que.paisesLigados.add(Gro);
		Que.paisesLigados.add(Van);
		Que.paisesLigados.add(Tex);
		Que.paisesLigados.add(NY);
		
		Cali.paisesLigados.add(Van);
		Cali.paisesLigados.add(Tex);
		Cali.paisesLigados.add(Mex);
		
		Tex.paisesLigados.add(Van);
		Tex.paisesLigados.add(Que);
		Tex.paisesLigados.add(Cali);
		Tex.paisesLigados.add(NY);
		Tex.paisesLigados.add(Mex);
		
		NY.paisesLigados.add(Que);
		NY.paisesLigados.add(Tex);
		
		Mex.paisesLigados.add(Cali);
		Mex.paisesLigados.add(Tex);
		Mex.paisesLigados.add(Ven);
		
		// AMSUL
		
		Ven.paisesLigados.add(Mex);
		Ven.paisesLigados.add(Bra);
		Ven.paisesLigados.add(Peru);
		
		Bra.paisesLigados.add(Ven);
		Bra.paisesLigados.add(Peru);
		Bra.paisesLigados.add(Argen);
		Bra.paisesLigados.add(Nig);
		
		Peru.paisesLigados.add(Ven);
		Peru.paisesLigados.add(Bra);
		Peru.paisesLigados.add(Argen);
		
		Argen.paisesLigados.add(Bra);
		Argen.paisesLigados.add(Peru);
		
		// EUROPA
		
		ReiUni.paisesLigados.add(Gro);
		ReiUni.paisesLigados.add(Fra);
		
		Sue.paisesLigados.add(Fra);
		Sue.paisesLigados.add(Ita);
		Sue.paisesLigados.add(Est);
		Sue.paisesLigados.add(Let);
		
		Esp.paisesLigados.add(Fra);
		Esp.paisesLigados.add(Argel);
		
		Fra.paisesLigados.add(ReiUni);
		Fra.paisesLigados.add(Sue);
		Fra.paisesLigados.add(Esp);
		Fra.paisesLigados.add(Ita);
		
		Ita.paisesLigados.add(Sue);
		Ita.paisesLigados.add(Fra);
		Ita.paisesLigados.add(Pol);
		Ita.paisesLigados.add(Rom);
		Ita.paisesLigados.add(Argel);
		
		Pol.paisesLigados.add(Ita);
		Pol.paisesLigados.add(Rom);
		Pol.paisesLigados.add(Ucr);
		Pol.paisesLigados.add(Let);
		
		Ucr.paisesLigados.add(Pol);
		Ucr.paisesLigados.add(Rom);
		Ucr.paisesLigados.add(Let);
		Ucr.paisesLigados.add(Tur);
		
		Rom.paisesLigados.add(Ita);
		Rom.paisesLigados.add(Pol);
		Rom.paisesLigados.add(Ucr);
		Rom.paisesLigados.add(Egi);
		
		// AFRICA

		Argel.paisesLigados.add(Egi);
		Argel.paisesLigados.add(Nig);
		Argel.paisesLigados.add(Esp);
		Argel.paisesLigados.add(Ita);
		
		Egi.paisesLigados.add(Argel);
		Egi.paisesLigados.add(Nig);
		Egi.paisesLigados.add(Som);
		Egi.paisesLigados.add(Rom);
		Egi.paisesLigados.add(Jor);
		
		Nig.paisesLigados.add(Argel);
		Nig.paisesLigados.add(Egi);
		Nig.paisesLigados.add(Som);
		Nig.paisesLigados.add(Ang);
		Nig.paisesLigados.add(Bra);
		
		Som.paisesLigados.add(Egi);
		Som.paisesLigados.add(Nig);
		Som.paisesLigados.add(Ang);
		Som.paisesLigados.add(AfSul);
		Som.paisesLigados.add(ArSau);
		
		Ang.paisesLigados.add(Nig);
		Ang.paisesLigados.add(Som);
		Ang.paisesLigados.add(AfSul);
		
		AfSul.paisesLigados.add(Ang);
		AfSul.paisesLigados.add(Som);
		
		// ASIA
		
		Est.paisesLigados.add(Sue);
		Est.paisesLigados.add(Let);
		Est.paisesLigados.add(Rus);
		
		Rus.paisesLigados.add(Est);
		Rus.paisesLigados.add(Let);
		Rus.paisesLigados.add(Caz);
		Rus.paisesLigados.add(Sib);
		
		Sib.paisesLigados.add(Rus);
		Sib.paisesLigados.add(Caz);
		Sib.paisesLigados.add(Ala);
		
		Let.paisesLigados.add(Est);
		Let.paisesLigados.add(Rus);
		Let.paisesLigados.add(Caz);
		Let.paisesLigados.add(Tur);
		Let.paisesLigados.add(Sue);
		Let.paisesLigados.add(Pol);
		Let.paisesLigados.add(Ucr);
		
		Caz.paisesLigados.add(Rus);
		Caz.paisesLigados.add(Sib);
		Caz.paisesLigados.add(Let);
		Caz.paisesLigados.add(Tur);
		Caz.paisesLigados.add(Chi);
		Caz.paisesLigados.add(Mon);
		Caz.paisesLigados.add(Jap);
		
		Tur.paisesLigados.add(Let);
		Tur.paisesLigados.add(Caz);
		Tur.paisesLigados.add(Chi);
		Tur.paisesLigados.add(Sir);
		Tur.paisesLigados.add(Paq);
		Tur.paisesLigados.add(Ucr);
		
		Chi.paisesLigados.add(Caz);
		Chi.paisesLigados.add(Tur);
		Chi.paisesLigados.add(Mon);
		Chi.paisesLigados.add(Paq);
		Chi.paisesLigados.add(CorNor);
		Chi.paisesLigados.add(CorSul);
		Chi.paisesLigados.add(Indi);
		
		Mon.paisesLigados.add(Caz);
		Mon.paisesLigados.add(Chi);
		Mon.paisesLigados.add(Jap);
		
		Jap.paisesLigados.add(Caz);
		Jap.paisesLigados.add(Mon);
		Jap.paisesLigados.add(CorNor);

		Sir.paisesLigados.add(Tur);
		Sir.paisesLigados.add(Paq);
		Sir.paisesLigados.add(Jor);
		Sir.paisesLigados.add(Iraq);
		Sir.paisesLigados.add(Ira);
		
		Paq.paisesLigados.add(Tur);
		Paq.paisesLigados.add(Chi);
		Paq.paisesLigados.add(Sir);
		Paq.paisesLigados.add(Ira);
		Paq.paisesLigados.add(Indi);
		
		CorNor.paisesLigados.add(Chi);
		CorNor.paisesLigados.add(Jap);
		CorNor.paisesLigados.add(CorSul);
		
		CorSul.paisesLigados.add(Chi);
		CorSul.paisesLigados.add(CorNor);
		CorSul.paisesLigados.add(Indi);
		CorSul.paisesLigados.add(Ban);
		CorSul.paisesLigados.add(Tai);
		
		Jor.paisesLigados.add(Sir);
		Jor.paisesLigados.add(Iraq);
		Jor.paisesLigados.add(ArSau);
		Jor.paisesLigados.add(Egi);
		
		Iraq.paisesLigados.add(Sir);
		Iraq.paisesLigados.add(Jor);
		Iraq.paisesLigados.add(Ira);
		Iraq.paisesLigados.add(ArSau);
		
		Ira.paisesLigados.add(Sir);
		Ira.paisesLigados.add(Paq);
		Ira.paisesLigados.add(Iraq);

		ArSau.paisesLigados.add(Jor);
		ArSau.paisesLigados.add(Iraq);
		ArSau.paisesLigados.add(Som);
		
		Indi.paisesLigados.add(Paq);
		Indi.paisesLigados.add(Chi);
		Indi.paisesLigados.add(CorSul);
		Indi.paisesLigados.add(Ban);
		Indi.paisesLigados.add(Indo);
		
		Ban.paisesLigados.add(CorSul);
		Ban.paisesLigados.add(Indi);
		Ban.paisesLigados.add(Tai);
		Ban.paisesLigados.add(Indo);
		
		Tai.paisesLigados.add(CorSul);
		Tai.paisesLigados.add(Ban);
		
		// OCEANIA
		
		Indo.paisesLigados.add(Indi);
		Indo.paisesLigados.add(Ban);
		Indo.paisesLigados.add(Aus);
		Indo.paisesLigados.add(NZ);
		
		Per.paisesLigados.add(Aus);
		
		Aus.paisesLigados.add(Indo);
		Aus.paisesLigados.add(Per);
		Aus.paisesLigados.add(NZ);
		
		NZ.paisesLigados.add(Indo);
		NZ.paisesLigados.add(Aus);
		
		return true;
		
	}

}
