package model;

import controller.ControllerAPI;
import view.ViewAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import observer.*;

public class ModelAPI implements Subject{
	
	static ModelAPI instance;
	
	static ArrayList<Image> cardImages;
	static ArrayList<Image> objectiveImages;
	static ArrayList<ImageIcon> atkImages;
	static ArrayList<ImageIcon> defImages;
	
	ArrayList<Continente> listaContinente;
	ArrayList<Jogador> listaJogadores;
	ArrayList<Objetivo> deckObjetivos;
	ArrayList<Troca> deckTroca;
	ArrayList<Observer> observadores;
	ArrayList<Object> paramsForObserver;
	
	private ModelAPI()
	{
		this.listaContinente = new ArrayList<Continente>();
		this.listaJogadores = new ArrayList<Jogador>();
		this.deckObjetivos = new ArrayList<Objetivo>();
		this.deckTroca = new ArrayList<Troca>();
		this.observadores = new ArrayList<Observer>();
		this.paramsForObserver = new ArrayList<Object>();
	}
	
	public static ModelAPI getModelAPI()
	{
		if (instance == null)
			instance = new ModelAPI();
		return instance;
	}
	
	public static void setupImages() throws IOException{
		cardImages = new ArrayList<Image>();
		objectiveImages = new ArrayList<Image>();
		
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_africadosul.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_angola.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_argelia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_egito.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_nigeria.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_af_somalia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_alasca.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_calgary.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_california.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_groelandia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_mexico.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_novayork.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_quebec.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_texas.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_an_vancouver.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_arabiasaudita.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_bangladesh.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_cazaquistao.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_china.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_coreiadonorte.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_coreiadosul.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_estonia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_india.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_ira.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_iraque.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_japao.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_jordania.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_letonia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_mongolia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_paquistao.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_russia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_siberia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_siria.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_tailandia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_as_turquia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_asl_argentina.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_asl_brasil.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_asl_peru.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_asl_venezuela.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_espanha.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_franca.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_italia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_polonia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_reinounido.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_romenia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_suecia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_eu_ucrania.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_oc_australia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_oc_indonesia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_oc_novazelandia.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_oc_perth.png")));
		cardImages.add(ImageIO.read(new File("assets/cartas/trocas/war_carta_coringa.png")));
		
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_01.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_02.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_03.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_04.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_05.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_06.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_07.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_08.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_09.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_10.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_11.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_12.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_13.jpg")));
		objectiveImages.add(ImageIO.read(new File("assets/cartas/objetivos/obj_14.jpg")));
	}
	
	public void obsAdd(Observer o) {
		observadores.add(o);
	}
	
	public Object obsGet(int i) {
		return paramsForObserver.get(i);
	}
	
	//Nao vai ser util em nenhum momento
	public void obsRemove(Observer o) {
		observadores.remove(o);
	}
	
	public boolean addPlayer(String nome, int cor)
	{
		Jogador newPlayer = new Jogador(nome, Cores.values()[cor]);
		listaJogadores.add(newPlayer);
		
		return true;
	}

	public boolean setupGame()
	{
		if (listaJogadores.size() < 2)
			return false;
		
		observadores.add(ViewAPI.getViewAPI());
		setupContinents(listaContinente);
		setupCards();
		
		drawObjectives();
		rafflePlayers();
		raffleTerritory();
		
		return true;
	}
	
	public boolean existPlayerColor(int cor) 
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
	
	public void giveCardToPlayer() {
		Jogador j = listaJogadores.get(0);
		
		if (j.dominouPaisTurno)
			j.mao.add(drawTrade());
		
		j.dominouPaisTurno = false;
	}
	
	public void nextPlayerToPlay() {
		Jogador j = listaJogadores.get(0);
		listaJogadores.remove(j);
		listaJogadores.add(j);
	}

	public String[] getCurrPlayerTerr() {
		ArrayList<Territorio> lista = listaJogadores.get(0).paisesDominados;
		String[] terrs = new String[lista.size()];
	
		int i = 0;
		
		for (Territorio t : lista) {
			terrs[i++] = t.nome;
		}
	
		return terrs;
	}

	public String[] getFrontierNames(String name) {
		Territorio t = getTerrByName(name);
		String[] terrs = new String[t.paisesLigados.size()];
		int i = 0;
		
		for (Territorio ter : t.paisesLigados) {
			terrs[i++] = ter.nome;
		}
		
		return terrs;
	}
	
	public boolean verifyNextTurn() {
		Jogador j = listaJogadores.get(0);
		
		if (j.numTropasPosicionar != 0) return false;
		
		for (int v : j.numTropasContinentes) {
			if (v != 0) return false;
		}

		return true;
	}
	
	public void giveBonuses() {
		Jogador j = listaJogadores.get(0);
		for (Continente c : listaContinente) {
			j.numTropasContinentes[c.tipo.ordinal()] += c.bonusPiece(j);
		}
		
		j.numTropasPosicionar += j.bonusPiece();
	}

	public boolean attackTerritory(String orig, String dest) {
		Jogador player = listaJogadores.get(0);
		
		if(!player.atacarTerritorio(getTerrByName(orig), getTerrByName(dest))) return false;
		
//		prepareNotify(orig);
//		prepareNotify(dest);
		
		Jogador morto = null;
		
		for (Jogador j : listaJogadores) {
			if (j.paisesDominados.size() == 0)
				morto = j;
		}

		if(morto != null) {
			listaJogadores.remove(morto);
		
			player.jogadoresEliminados.add(morto.cor);
			if(player.obj.verificaObj(player, listaContinente)){
				ViewAPI.getViewAPI().showWinner(player.nome, player.obj.descricao);
				return true;
			}
			else {
				for (Jogador j : listaJogadores) {
					if (j != player && j.obj.id - 8 == morto.cor.ordinal()) {//verifica se outro player tinha que eliminar o morto
						j.obj = new Objetivo14(null); //se sim, substitui seu objetivo
						if(j.obj.verificaObj(j, listaContinente)) {
							ViewAPI.getViewAPI().showWinner(j.nome, j.obj.descricao);
							return true;
						}
						break;
					}
				}
			}
		}
		
		if(player.obj.verificaObj(player, listaContinente))
			ViewAPI.getViewAPI().showWinner(player.nome, player.obj.descricao);
		return true;
	}

	public boolean positionTroops(String t, int qtd, boolean cont) {
		Territorio terr = getTerrByName(t);
		Jogador j = listaJogadores.get(0);
		
		
		if (cont) {
			Continentes c = terr.continente.tipo;
			if (!hasAllTerrCont(c)) return false;
			if (!j.posicionarTropas(terr, qtd, c)) return false;	
		}
		else {
			if (!j.posicionarTropas(terr, qtd, null)) return false;
		}
		
		
		
		return true;
	}
	
	public void finishGame() {
		instance = null;
	}
	
	public void restartGame() {
		for (Jogador j : listaJogadores) {
			j.paisesDominados.clear();
			j.mao.clear();
			j.numTropasPosicionar = 0;
		}
		
		listaContinente = new ArrayList<Continente>();
		deckObjetivos = new ArrayList<Objetivo>();
		deckTroca = new ArrayList<Troca>();	
		observadores = new ArrayList<Observer>();
		
		observadores.add(ViewAPI.getViewAPI());
		setupContinents(listaContinente);
		setupCards();
		
		drawObjectives();
		rafflePlayers();
		raffleTerritory();
	}
	
	public void saveGame(PrintWriter outputStream) {
		outputStream.println(listaJogadores.size());
		for (Jogador j : listaJogadores) {
			outputStream.printf("%s;%d;%d;%d;\n", j.nome, j.cor.ordinal(), j.obj.id, j.numTropasPosicionar);
			
			outputStream.println(j.paisesDominados.size());
			for (Territorio t : j.paisesDominados)
				outputStream.printf("%s;%d;%d;\n", t.nome, t.numTropas, t.numTropasPodeMover);
			
			outputStream.println(j.mao.size());
			for (Troca t : j.mao) {
				if (t.representa != null)
					outputStream.println(t.representa.nome);
				else
					outputStream.println("Coringa");
			}
			
			outputStream.println(j.jogadoresEliminados.size());
			for (Cores c : j.jogadoresEliminados)
				outputStream.println(c.ordinal());
		}
	}
	
	public void loadGame(BufferedReader inputStream) throws IOException {
		Jogador j;
		Territorio t;
		Troca c;
		Cores cor;
		
		String ln = inputStream.readLine(), infos[];
		int numJ = Integer.parseInt(ln), numP, numT, numC;
		
		observadores.add(ViewAPI.getViewAPI());
		setupContinents(listaContinente);
		setupCards();
		
		for (int i = 0; i < numJ; i++) {
			ln = inputStream.readLine();
			infos = ln.split(";");
			j = createPlayer(infos[0], Integer.parseInt(infos[1]));
			switch (Integer.parseInt(infos[2])) {
				case 1: j.obj = new Objetivo1(ModelAPI.objectiveImages.get(0)); break;
				case 2: j.obj = new Objetivo2(ModelAPI.objectiveImages.get(1)); break;
				case 3: j.obj = new Objetivo3(ModelAPI.objectiveImages.get(2)); break;
				case 4: j.obj = new Objetivo4(ModelAPI.objectiveImages.get(3)); break;
				case 5: j.obj = new Objetivo5(ModelAPI.objectiveImages.get(4)); break;
				case 6: j.obj = new Objetivo6(ModelAPI.objectiveImages.get(5)); break;
				case 7:	j.obj = new Objetivo7(ModelAPI.objectiveImages.get(6)); break;
				case 8:	j.obj = new Objetivo8(ModelAPI.objectiveImages.get(7)); break;
				case 9:	j.obj = new Objetivo9(ModelAPI.objectiveImages.get(8)); break;
				case 10: j.obj = new Objetivo10(ModelAPI.objectiveImages.get(9)); break;
				case 11: j.obj = new Objetivo11(ModelAPI.objectiveImages.get(10)); break;
				case 12: j.obj = new Objetivo12(ModelAPI.objectiveImages.get(11)); break;
				case 13: j.obj = new Objetivo13(ModelAPI.objectiveImages.get(12)); break;
				case 14: j.obj = new Objetivo14(ModelAPI.objectiveImages.get(13)); break;
			}
			j.numTropasPosicionar = Integer.parseInt(infos[3]);
			
			ln = inputStream.readLine();
			numP = Integer.parseInt(ln);
			for(int k = 0; k < numP; k++) {
				ln = inputStream.readLine();
				infos = ln.split(";");
				t = getTerrByName(infos[0]);
				t.corDominando = j.cor;
				t.numTropas = Integer.parseInt(infos[1]);
				t.numTropasPodeMover = Integer.parseInt(infos[2]);
				prepareNotify(t);
			}
			
			ln = inputStream.readLine();
			numT = Integer.parseInt(ln);
			for (int k = 0; k < numT; k++) {
				ln = inputStream.readLine();
				c = getCardByName(ln);
				j.mao.add(c);
			}
			
			ln = inputStream.readLine();
			numC = Integer.parseInt(ln);
			for (int k = 0; k < numC; k++) {
				ln = inputStream.readLine();
				cor = Cores.values()[Integer.parseInt(ln)];
				j.jogadoresEliminados.add(cor);
			}
		}
	}

	public ArrayList<ImageIcon> getAtkImages() {
		return atkImages;
	}
	
	public ArrayList<ImageIcon> getDefImages() {
		return defImages;
	}
	
	//Debug
	public void printPlayingPlayer() {
		System.out.print(listaJogadores.get(0).nome);
	}
	
	Jogador createPlayer(String nome, int cor)
	{
		Jogador newPlayer = new Jogador(nome, Cores.values()[cor]);
		listaJogadores.add(newPlayer);
		
		return newPlayer;
	}
	
 	Troca drawTrade()
	{
		if (deckTroca.size() == 0)
			return null;
		Troca obj = deckTroca.get(deckTroca.size() - 1);
		deckTroca.remove(obj);
		return obj;
	}
	
 	void prepareNotify(Territorio ter) {
 		paramsForObserver.add(0, ter.corDominando.ordinal());
		paramsForObserver.add(1, ter.numTropas);
		paramsForObserver.add(2, ter.nome);
		for (Observer obs: observadores) {
			obs.notify(getModelAPI());
		}
		paramsForObserver.clear();
 	}
 	
	boolean validateTrade(Troca c1, Troca c2, Troca c3)
	{
		if (c1.simbolo == Simbolo.Coringa || c2.simbolo == Simbolo.Coringa || c3.simbolo == Simbolo.Coringa)
			return true;
		
		if (c1.simbolo == c2.simbolo) {
			if (c2.simbolo == c3.simbolo)
				return true;
		}
		else if (c2.simbolo != c3.simbolo && c1.simbolo != c3.simbolo)
			return true;
			
		return false;
	}
	
	boolean verifiesObjective() {
		Jogador j = listaJogadores.get(0);
		return j.obj.verificaObj(j, listaContinente);
	}

	void drawObjectives()
	{
		Objetivo obj;
		
		for (Jogador j : listaJogadores)
		{
			obj = deckObjetivos.get(deckObjetivos.size() - 1);
			deckObjetivos.remove(obj);
			
			if (obj.id >= 8 && obj.id != 14) // se destruir exercito especifico
			{
				if (obj.id - 8 == j.cor.ordinal()) // se voce mesmo
				{
					obj = new Objetivo14(ModelAPI.objectiveImages.get(13)); // entao troca objetivo
				}
			}
			
			j.obj = obj;
		}
	}

	void rafflePlayers()
	{
		Collections.shuffle(listaJogadores);
	}
	
	void raffleTerritory()
	{
		Jogador j1;
		Troca card;
		int id = 0;
		
		while((card = drawTrade()) != null)
		{
			j1 = listaJogadores.get(id);
			j1.mao.add(card);
			
			if (card.simbolo != Simbolo.Coringa) {
				card.representa.numTropas = 1;
				card.representa.corDominando = j1.cor;
				j1.paisesDominados.add(card.representa);
				id++;
				prepareNotify(card.representa);
			}
			
			if (id >= listaJogadores.size())
				id = 0;
 		}
		
		for(Jogador j : listaJogadores) {
			for(Troca t : j.mao)
				deckTroca.add(t);
			
			j.mao.clear();
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
			
			deckTroca.add(0, temp.get(0));
			deckTroca.add(0, temp.get(1));
			deckTroca.add(0, temp.get(2));
			
			for (Troca c : temp) { //bonus de possuir o territorio da carta
				if(id.paisesDominados.contains(c.representa)) {
					c.representa.numTropas += 2;
					c.representa.numTropasPodeMover += 2;
				}
			}
			
			int x;
			char n = ControllerAPI.getControllerAPI().troca_atual++;
			
			if (n < 6) x = 2 + n;
			else x = 5 * (n - 3);
			
			
			id.numTropasPosicionar += x;
			
			return true;
		}
		
		return false;
	}
	
	private Territorio getTerrByName(String name) {
        for (Continente c : listaContinente) {
            for (Territorio t : c.paises) {
                if (t.nome.equals(name)) 
                	return t;
            }
        }
        return null;
    }
	
	private boolean hasAllTerrCont(Continentes cont) {
		Jogador j = listaJogadores.get(0);
		
		for (Continente c : listaContinente) {
			if (c.tipo == cont) {
				for (Territorio t : c.paises) {
					if (!j.paisesDominados.contains(t)) return false;
				}
			}
		}
		
		return true;
	}
	
	private Troca getCardByName(String name) {
		for(Troca t : deckTroca) {
			if (t.representa == null) { 
				if (name.equals("Coringa")) {
					deckTroca.remove(t);
					return t;
				}
			}
			else {
				if (t.representa.nome.equals(name)) {
					deckTroca.remove(t);
					return t;
				}
			}
		}
		return null;
	}
	
	boolean setupCards()
	{
		//remover loop para adicionar as imagens de cada
//		for (int i = 0; i <= 13; i++)
//			deckObjetivos.add(new Objetivo(i, null));
		
		deckObjetivos.add(new Objetivo1(ModelAPI.objectiveImages.get(0)));
		deckObjetivos.add(new Objetivo2(ModelAPI.objectiveImages.get(1)));
		deckObjetivos.add(new Objetivo3(ModelAPI.objectiveImages.get(2)));
		deckObjetivos.add(new Objetivo4(ModelAPI.objectiveImages.get(3)));
		deckObjetivos.add(new Objetivo5(ModelAPI.objectiveImages.get(4)));
		deckObjetivos.add(new Objetivo6(ModelAPI.objectiveImages.get(5)));
		deckObjetivos.add(new Objetivo7(ModelAPI.objectiveImages.get(6)));
		if (existPlayerColor(0))
			deckObjetivos.add(new Objetivo8(ModelAPI.objectiveImages.get(7)));
		if (existPlayerColor(1))
			deckObjetivos.add(new Objetivo9(ModelAPI.objectiveImages.get(8)));
		if (existPlayerColor(2))
			deckObjetivos.add(new Objetivo10(ModelAPI.objectiveImages.get(9)));
		if (existPlayerColor(3))
			deckObjetivos.add(new Objetivo11(ModelAPI.objectiveImages.get(10)));
		if (existPlayerColor(4))
			deckObjetivos.add(new Objetivo12(ModelAPI.objectiveImages.get(11)));
		if (existPlayerColor(5))
			deckObjetivos.add(new Objetivo13(ModelAPI.objectiveImages.get(12)));
		deckObjetivos.add(new Objetivo14(ModelAPI.objectiveImages.get(13)));
		
		Collections.shuffle(deckObjetivos);
		
		int i = 0;
		for(Continente c : listaContinente)
			for(Territorio p : c.paises) {
				deckTroca.add(new Troca(p, null, ModelAPI.cardImages.get(i)));
				i++;
			}
		
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
		deckTroca.add(new Troca(null, Simbolo.Coringa, ModelAPI.cardImages.get(51)));
		deckTroca.add(new Troca(null, Simbolo.Coringa, ModelAPI.cardImages.get(51)));
		
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
