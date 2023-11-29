package view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Tabuleiro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image source, bg;
	ArrayList<Exercito> listaExercitos;
	String acao = "Posicionar";
	String corPlayer = "Azul";
	String jogName = "Moao";
	
	//Criação do painel do tabuleiro
	//criamos todos os exércitos a serem desenhados na tela
	public Tabuleiro() {
		try {
			bg = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_fundo.png"));
			source = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_mapa copy.png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//inserindo coordenadas de cada pais
		Map<String, ArrayList<Float>> coordenadas = new HashMap<>();
		ArrayList<Float> alascaCoord = new ArrayList<>();
        alascaCoord.add(7.5f);
        alascaCoord.add(9.25f);
        coordenadas.put("Alasca", alascaCoord);
        ArrayList<Float> calgaryCoord = new ArrayList<>();
        calgaryCoord.add(13.0f);
        calgaryCoord.add(9.75f);
        coordenadas.put("Calgary", calgaryCoord);
        ArrayList<Float> groCoord = new ArrayList<>();
        groCoord.add(22.0f);
        groCoord.add(7.5f);
        coordenadas.put("Groelândia", groCoord);
        ArrayList<Float> vanCoord = new ArrayList<>();
        vanCoord.add(14.0f);
        vanCoord.add(13.5f);
        coordenadas.put("Vancouver", vanCoord);
        ArrayList<Float> qCoord = new ArrayList<>();
        qCoord.add(20.5f);
        qCoord.add(12.25f);
        coordenadas.put("Quebec", qCoord);
        ArrayList<Float> calCoord = new ArrayList<>();
        calCoord.add(9.0f);
        calCoord.add(17.0f);
        coordenadas.put("Califórnia", calCoord);
        ArrayList<Float> texCoord = new ArrayList<>();
        texCoord.add(11.75f);
        texCoord.add(18.25f);
        coordenadas.put("Texas", texCoord);
        ArrayList<Float> nyCoord = new ArrayList<>();
        nyCoord.add(15.0f);
        nyCoord.add(18.25f);
        coordenadas.put("Nova York", nyCoord);
        ArrayList<Float> mexCoord = new ArrayList<>();
        mexCoord.add(10.5f);
        mexCoord.add(24.75f);
        coordenadas.put("México", mexCoord);
        ArrayList<Float> venCoord = new ArrayList<>();
        venCoord.add(14.0f);
        venCoord.add(29.0f);
        coordenadas.put("Venezuela", venCoord);
        ArrayList<Float> brCoord = new ArrayList<>();
        brCoord.add(19.5f);
        brCoord.add(30.25f);
        coordenadas.put("Brasil", brCoord);
        ArrayList<Float> perCoord = new ArrayList<>();
        perCoord.add(16.5f);
        perCoord.add(32.75f);
        coordenadas.put("Peru", perCoord);
        ArrayList<Float> argCoord = new ArrayList<>();
        argCoord.add(19.25f);
        argCoord.add(37.5f);
        coordenadas.put("Argentina", argCoord);
        ArrayList<Float> ruCoord = new ArrayList<>();
        ruCoord.add(31.75f);
        ruCoord.add(13.5f);
        coordenadas.put("Reino Unido", ruCoord);
        ArrayList<Float> suCoord = new ArrayList<>();
        suCoord.add(35.5f);
        suCoord.add(10.75f);
        coordenadas.put("Suécia", suCoord);
        ArrayList<Float> poCoord = new ArrayList<>();
        poCoord.add(38.75f);
        poCoord.add(15.0f);
        coordenadas.put("Polônia", poCoord);
        ArrayList<Float> ucCoord = new ArrayList<>();
        ucCoord.add(40.75f);
        ucCoord.add(16.25f);
        coordenadas.put("Ucrânia", ucCoord);
        ArrayList<Float> romCoord = new ArrayList<>();
        romCoord.add(39.25f);
        romCoord.add(18.0f);
        coordenadas.put("Romênia", romCoord);
        ArrayList<Float> itaCoord = new ArrayList<>();
        itaCoord.add(36.5f);
        itaCoord.add(16.25f);
        coordenadas.put("Itália", itaCoord);
        ArrayList<Float> frCoord = new ArrayList<>();
        frCoord.add(34.0f);
        frCoord.add(16.25f);
        coordenadas.put("França", frCoord);
        ArrayList<Float> espCoord = new ArrayList<>();
        espCoord.add(30.75f);
        espCoord.add(18.75f);
        coordenadas.put("Espanha", espCoord);
        ArrayList<Float> argeCoord = new ArrayList<>();
        argeCoord.add(31.0f);
        argeCoord.add(24.75f);
        coordenadas.put("Argélia", argeCoord);
        ArrayList<Float> nigCoord = new ArrayList<>();
        nigCoord.add(33.5f);
        nigCoord.add(29.25f);
        coordenadas.put("Nigéria", nigCoord);
        ArrayList<Float> egeCoord = new ArrayList<>();
        egeCoord.add(38.25f);
        egeCoord.add(26.25f);
        coordenadas.put("Egito", egeCoord);
        ArrayList<Float> somCoord = new ArrayList<>();
        somCoord.add(42.0f);
        somCoord.add(32.75f);
        coordenadas.put("Somália", somCoord);
        ArrayList<Float> agCoord = new ArrayList<>();
        agCoord.add(37.75f);
        agCoord.add(34.0f);
        coordenadas.put("Angola", agCoord);
        ArrayList<Float> afCoord = new ArrayList<>();
        afCoord.add(39.0f);
        afCoord.add(38.0f);
        coordenadas.put("África do Sul", afCoord);
        ArrayList<Float> estCoord = new ArrayList<>();
        estCoord.add(47.0f);
        estCoord.add(10.0f);
        coordenadas.put("Estônia", estCoord);
        ArrayList<Float> letCoord = new ArrayList<>();
        letCoord.add(47.0f);
        letCoord.add(13.5f);
        coordenadas.put("Letônia", letCoord);
        ArrayList<Float> rusCoord = new ArrayList<>();
        rusCoord.add(53.25f);
        rusCoord.add(10.25f);
        coordenadas.put("Russía", rusCoord);
        ArrayList<Float> sibCoord = new ArrayList<>();
        sibCoord.add(60.0f);
        sibCoord.add(10.0f);
        coordenadas.put("Sibéria", sibCoord);
        ArrayList<Float> cazCoord = new ArrayList<>();
        cazCoord.add(58.5f);
        cazCoord.add(15.25f);
        coordenadas.put("Cazaquistão", cazCoord);
        ArrayList<Float> tuCoord = new ArrayList<>();
        tuCoord.add(48.75f);
        tuCoord.add(16.5f);
        coordenadas.put("Turquia", tuCoord);
        ArrayList<Float> monCoord = new ArrayList<>();
        monCoord.add(56.0f);
        monCoord.add(17.75f);
        coordenadas.put("Mongólia", monCoord);
        ArrayList<Float> japCoord = new ArrayList<>();
        japCoord.add(63.75f);
        japCoord.add(19.0f);
        coordenadas.put("Japão", japCoord);
        ArrayList<Float> sirCoord = new ArrayList<>();
        sirCoord.add(46.5f);
        sirCoord.add(20.0f);
        coordenadas.put("Síria", sirCoord);
        ArrayList<Float> paqCoord = new ArrayList<>();
        paqCoord.add(50.75f);
        paqCoord.add(22.5f);
        coordenadas.put("Paquistão", paqCoord);
        ArrayList<Float> chiCoord = new ArrayList<>();
        chiCoord.add(54.0f);
        chiCoord.add(20.5f);
        coordenadas.put("China", chiCoord);
        ArrayList<Float> cnCoord = new ArrayList<>();
        cnCoord.add(57.0f);
        cnCoord.add(21.25f);
        coordenadas.put("Coréia do Norte", cnCoord);
        ArrayList<Float> csCoord = new ArrayList<>();
        csCoord.add(56.5f);
        csCoord.add(23.0f);
        coordenadas.put("Coréia do Sul", csCoord);
        ArrayList<Float> jorCoord = new ArrayList<>();
        jorCoord.add(42.0f);
        jorCoord.add(24.5f);
        coordenadas.put("Jordânia", jorCoord);
        ArrayList<Float> iraqCoord = new ArrayList<>();
        iraqCoord.add(45.75f);
        iraqCoord.add(23.25f);
        coordenadas.put("Iraque", iraqCoord);
        ArrayList<Float> iraCoord = new ArrayList<>();
        iraCoord.add(48.5f);
        iraCoord.add(23.75f);
        coordenadas.put("Irã", iraCoord);
        ArrayList<Float> araCoord = new ArrayList<>();
        araCoord.add(45.75f);
        araCoord.add(27.5f);
        coordenadas.put("Arábia Saudita", araCoord);
        ArrayList<Float> indCoord = new ArrayList<>();
        indCoord.add(53.75f);
        indCoord.add(25.5f);
        coordenadas.put("Índia", indCoord);
        ArrayList<Float> banCoord = new ArrayList<>();
        banCoord.add(57.0f);
        banCoord.add(25.75f);
        coordenadas.put("Bangladesh", banCoord);
        ArrayList<Float> taiCoord = new ArrayList<>();
        taiCoord.add(60.5f);
        taiCoord.add(25.25f);
        coordenadas.put("Tailândia", taiCoord);
        ArrayList<Float> indoCoord = new ArrayList<>();
        indoCoord.add(60.25f);
        indoCoord.add(34.25f);
        coordenadas.put("Indonésia", indoCoord);
        ArrayList<Float> austCoord = new ArrayList<>();
        austCoord.add(58.75f);
        austCoord.add(40.75f);
        coordenadas.put("Austrália", austCoord);
        ArrayList<Float> pertCoord = new ArrayList<>();
        pertCoord.add(54.75f);
        pertCoord.add(40.0f);
        coordenadas.put("Perth", pertCoord);
        ArrayList<Float> nzCoord = new ArrayList<>();
        nzCoord.add(62.75f);
        nzCoord.add(43.25f);
        coordenadas.put("Nova Zelândia", nzCoord);
        
		this.listaExercitos = new ArrayList<Exercito>();
		
		//as coordenadas estavam em formato de quadrados do mapa, aqui elas sao passadas para o formato de pixel e colocadas no exercito que vai para a lista
		for (Map.Entry<String, ArrayList<Float>> entry : coordenadas.entrySet()) {
            ArrayList<Float> valores = entry.getValue();
            listaExercitos.add(new Exercito((937*valores.get(0)/68)-20, (703*valores.get(1)/52)-16, 0, entry.getKey()));
        }
	}
	
	//Re-implementação do método painComponent
	//desenha todos os exércitos na tela,
	//o indicador de fase/jogador da vez
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bg, 0, 0, 937, 700, null);
		g2d.drawImage(source, 0, 0, 937, 700,null);
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		
		for (Exercito e : listaExercitos) {
			switch(e.color) {
			case 0:
				g2d.setPaint(Color.YELLOW);
				break;
			case 1:
				g2d.setPaint(Color.BLUE);
				break;
			case 2:
				g2d.setPaint(Color.WHITE);
				break;
			case 3:
				g2d.setPaint(Color.GREEN);
				break;
			case 4:
				g2d.setPaint(Color.RED);
				break;
			case 5:
				g2d.setPaint(Color.BLACK);
				break;
			default:
				g2d.setPaint(Color.GRAY);
			}
			
			//aumentando o tamanho do exercito se forem mais de 9
			if (e.number > 9) {
				e.elip = new Ellipse2D.Double(e.x, e.y, 25, 25);
			}else {
				e.elip = new Ellipse2D.Double(e.x, e.y, 20, 20);
			}
			
			g2d.fill(e.elip);			
			
			g2d.setPaint(Color.DARK_GRAY);
			g2d.draw(e.elip);
			
			if (e.color != 5)
				g2d.setPaint(Color.BLACK);
			else
				g2d.setPaint(Color.WHITE);
			
			//diminuindo a fonte caso o numero de exercitos passe de 99
			Font originalFont = g.getFont();
            Font newFont = originalFont.deriveFont(originalFont.getSize() * 0.65f); // Reduza o tamanho da fonte em 20%
            if (e.number > 99) {
                g.setFont(newFont);
            }
			g2d.drawString(Integer.toString(e.number), e.x + e.w/2 - (e.number < 9 ? 5 : 8), e.y + e.h/2 + (e.number < 9 ? 8 : 10)); //esse -5 e + 8 foi no olhômetro
			g.setFont(originalFont);
		}
		
		//adicionando um retangulo no mapa para indicar a cor do jogador da vez e a ação que é pra ser tomada
		switch(corPlayer) {
		case "Azul":
			g2d.setPaint(Color.BLUE);
			break;
		case "Amarelo":
			g2d.setPaint(Color.YELLOW);
			break;
		case "Branco":
			g2d.setPaint(Color.WHITE);
			break;
		case "Verde":
			g2d.setPaint(Color.GREEN);
			break;
		case "Vermelho":
			g2d.setPaint(Color.RED);
			break;
		case "Preto":
			g2d.setPaint(Color.BLACK);
			break;
		default:
			g2d.setPaint(Color.GRAY);
		} // Cor do retângulo
	    int rectWidth = Math.max(200, (int)jogName.length()*200/17); // Largura do retângulo
	    int rectHeight = 35; // Altura do retângulo
	    int rectX = (int) ((getWidth() - rectWidth) / 2 -(8.5*(200/rectWidth)) - 2.5 + 11); // Posição X do retângulo (centralizado)
	    int rectY = getHeight() - rectHeight - 100; // Posição Y do retângulo (30 pixels acima do fundo)

	    g2d.fillRect(rectX, rectY, rectWidth, rectHeight+20);
	    
	    // Adiciona borda cinza ao retângulo
	    g2d.setPaint(Color.GRAY); // Cor da borda
	    g2d.drawRect(rectX, rectY, rectWidth, rectHeight+20);

	    // Adiciona texto no retângulo
	    if (corPlayer != "Preto") {
	    	g2d.setPaint(Color.BLACK); // Cor do texto
	    }else {
	    	g2d.setPaint(Color.WHITE);
	    }
	    g2d.setFont(new Font("Arial", Font.BOLD, 18)); // Fonte do texto
	    String texto = "Turno: " + acao;
	    int textX = rectX + rectWidth / 2 - g2d.getFontMetrics().stringWidth(texto) / 2; // Posição X do texto (centralizado no retângulo)
	    int textY = rectY + rectHeight / 2 + g2d.getFontMetrics().getHeight() / 4; // Posição Y do texto (centralizado verticalmente no retângulo)

	    g2d.drawString(texto, textX, textY);
	    textX = rectX + rectWidth / 2 - g2d.getFontMetrics().stringWidth(jogName) / 2;
	    g2d.drawString(jogName, textX, textY+20);
	}
	
	//métodos que sao chamados pela viewAPI para atualizar as infos do mapa com as infos do observer
	public void updateExe(int color, int number, String nome, String colorJog, String jogName) {
		for (Exercito e: listaExercitos) {
			if (nome.equals(e.nome)) {
				e.color = color;
				e.number = number;
				break;
			}
		}
		corPlayer = colorJog;
		this.jogName = jogName;
	}
	
	void repaintAction(String action) {
		acao = action;
	}
	
}
