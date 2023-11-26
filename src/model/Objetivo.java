package model;

import java.awt.Image;
import java.util.ArrayList;

//classe abstrata Objetivo que sera herdada por cada tipo de objetivo
abstract class Objetivo {
	String descricao; //descrição do objetivo
	int id; //identificador dele, seu numero
	Image toDisplay; //imagem do objetivo
	
	//metodo para ser implementado por cada classe objetivo diferente para informar se o objetivo foi concluido
	abstract boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente);
	
	//metodo que é usado por outros objetivos para verificar se o jogador atual conquistou os continentes da listaContinente
	boolean verificaConquista(Jogador atual, ArrayList<Continentes> continentes, ArrayList<Continente> listaContinente) {
		ArrayList<Territorio> territoriosObj = new ArrayList<>();
		for(Continentes nome: continentes) {
			for (Continente c: listaContinente) {
				if(c.tipo == nome) {
					territoriosObj.addAll(c.paises);
					break;
				}
			}
		}
		
		for(Territorio t: territoriosObj) {
			if(!(atual.paisesDominados.contains(t))) {
				return false;
			}
		}
		
		return true;
	}
}

class Objetivo1 extends Objetivo{
	public Objetivo1(Image _ref) {
		this.id = 1;
		this.descricao = "Conquistar na totalidade a Asia e a Africa";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.AFRICA);
		continentes.add(Continentes.ASIA);
		return verificaConquista(atual, continentes, listaContinente);
	}	
}

class Objetivo2 extends Objetivo{
	public Objetivo2(Image _ref) {
		this.id = 2;
		this.descricao = "Conquistar na totalidade Asia e America do Sul";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.AMSUL);
		continentes.add(Continentes.ASIA);
		return verificaConquista(atual, continentes, listaContinente);
	}	
}

class Objetivo3 extends Objetivo{
	public Objetivo3(Image _ref) {
		this.id = 3;
		this.descricao = "Conquistar na totalidade a America do Norte e a Africa";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.AFRICA);
		continentes.add(Continentes.AMNORTE);
		return verificaConquista(atual, continentes, listaContinente);
	}	
}

class Objetivo4 extends Objetivo{
	public Objetivo4(Image _ref) {
		this.id = 4;
		this.descricao = "Conquistar na totalidade a America do Norte e a Oceania";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.AMNORTE);
		continentes.add(Continentes.OCEANIA);
		return verificaConquista(atual, continentes, listaContinente);
	}	
}

class Objetivo5 extends Objetivo{
	public Objetivo5(Image _ref) {
		this.id = 5;
		this.descricao = "Conquistar na totalidade a Europa, a Oceania e mais um continente a sua escolha";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.EUROPA);
		continentes.add(Continentes.OCEANIA);
		
		//há varias combinações de continentes que o jogador pode conquistar para concluir este objetivo
		//esses for loops testam se alguma delas foi concluida
		ArrayList<ArrayList<Continentes>> combinacoes = new ArrayList<>();
		for(Continentes t: Continentes.values()) {
			if(t != Continentes.EUROPA && t != Continentes.OCEANIA) {
				ArrayList<Continentes> combValida = new ArrayList<>(continentes);
				combValida.add(t);
				combinacoes.add(combValida);
			}
		}
		
		for(ArrayList<Continentes> comb: combinacoes) {
			if (verificaConquista(atual, comb, listaContinente)) {
				return true;
			}
		}
		
		return false;
	}
}

class Objetivo6 extends Objetivo{
	public Objetivo6(Image _ref) {
		this.id = 6;
		this.descricao = "Conquistar na totalidade a Europa, a America do Sul e mais um continente a sua escolha";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		ArrayList<Continentes> continentes = new ArrayList<>();
		continentes.add(Continentes.EUROPA);
		continentes.add(Continentes.AMSUL);
		
		//há varias combinações de continentes que o jogador pode conquistar para concluir este objetivo
		//esses for loops testam se alguma delas foi concluida
		ArrayList<ArrayList<Continentes>> combinacoes = new ArrayList<>();
		for(Continentes t: Continentes.values()) {
			if(t != Continentes.EUROPA && t != Continentes.AMSUL) {
				ArrayList<Continentes> combValida = new ArrayList<>(continentes);
				combValida.add(t);
				combinacoes.add(combValida);
			}
		}
		
		for(ArrayList<Continentes> comb: combinacoes) {
			if (verificaConquista(atual, comb, listaContinente)) {
				return true;
			}
		}
		
		return false;
	}
}

class Objetivo7 extends Objetivo{
	public Objetivo7(Image _ref) {
		this.id = 7;
		this.descricao = "Conquistar 18 territorios com pelo menos 2 exercitos em cada";
		this.toDisplay = _ref;
	}
	
	//funcao para ver quantos territorios o jogador possui que tenham mais de 1 exercito, caso sejam mais de 18 retorna true
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		int counter = 0;
		for(Territorio t: atual.paisesDominados) {
			if (t.numTropas >= 2) {
				counter +=1 ;
			}
		}
		if (counter >= 18) {
			return true;
		}
		return false;
	}
}

class Objetivo8 extends Objetivo{
	public Objetivo8(Image _ref) {
		this.id = 8;
		this.descricao = "Destruir todos os exércitos Amarelo (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Amarelo) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo9 extends Objetivo{
	public Objetivo9(Image _ref) {
		this.id = 9;
		this.descricao = "Destruir todos os exércitos Azul (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Azul) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo10 extends Objetivo{
	public Objetivo10(Image _ref) {
		this.id = 10;
		this.descricao = "Destruir todos os exércitos Branco (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Branco) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo11 extends Objetivo{
	public Objetivo11(Image _ref) {
		this.id = 11;
		this.descricao = "Destruir todos os exércitos Verde (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Verde) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo12 extends Objetivo{
	public Objetivo12(Image _ref) {
		this.id = 12;
		this.descricao = "Destruir todos os exércitos Vermelho (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Vermelho) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo13 extends Objetivo{
	public Objetivo13(Image _ref) {
		this.id = 13;
		this.descricao = "Destruir todos os exércitos Preto (Se ja tiver sido destruido o objetivo passa a ser conquistar 24 territorios)";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		for(Cores ini: atual.jogadoresEliminados) {
			if(ini == Cores.Preto) {
				return true;
			}
		}
		return false;
	}
}

class Objetivo14 extends Objetivo{
	public Objetivo14(Image _ref) {
		this.id = 14;
		this.descricao = "Conquistar 24 territorios a sua escolha";
		this.toDisplay = _ref;
	}
	boolean verificaObj(Jogador atual, ArrayList<Continente> listaContinente) {
		if (atual.paisesDominados.size() >= 24) {
			return true;
		}
		return false;
	}
}

