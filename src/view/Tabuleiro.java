package view;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Tabuleiro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image source, bg;
	ImageIcon nextAction, rollDices;
	ArrayList<Exercito> listaExercitos;
	
	public Tabuleiro() {
		try {
			bg = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_fundo.png"));
			source = ImageIO.read(new File("assets/tabuleiro/war_tabuleiro_mapa copy.png"));
			nextAction = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnProxJogada.png")));
			rollDices = new ImageIcon(ImageIO.read(new File("assets/botoes/war_btnJogarDados.png")));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//inserindo coordenadas de cada pais
		Map<String, ArrayList<Integer>> coordenadas = new HashMap<>();
		ArrayList<Integer> alascaCoord = new ArrayList<>();
        alascaCoord.add(7);
        alascaCoord.add(10);
        coordenadas.put("Alasca", alascaCoord);
        ArrayList<Integer> calgaryCoord = new ArrayList<>();
        calgaryCoord.add(13);
        calgaryCoord.add(10);
        coordenadas.put("Calgary", calgaryCoord);
        ArrayList<Integer> groCoord = new ArrayList<>();
        groCoord.add(23);
        groCoord.add(8);
        coordenadas.put("Groelândia", groCoord);
        ArrayList<Integer> vanCoord = new ArrayList<>();
        vanCoord.add(13);
        vanCoord.add(13);
        coordenadas.put("Vancouver", vanCoord);
        ArrayList<Integer> qCoord = new ArrayList<>();
        qCoord.add(18);
        qCoord.add(14);
        coordenadas.put("Quebec", qCoord);
        ArrayList<Integer> calCoord = new ArrayList<>();
        calCoord.add(8);
        calCoord.add(18);
        coordenadas.put("Califórnia", calCoord);
        ArrayList<Integer> texCoord = new ArrayList<>();
        texCoord.add(12);
        texCoord.add(18);
        coordenadas.put("Texas", texCoord);
        ArrayList<Integer> nyCoord = new ArrayList<>();
        nyCoord.add(15);
        nyCoord.add(18);
        coordenadas.put("Nova York", nyCoord);
        ArrayList<Integer> mexCoord = new ArrayList<>();
        mexCoord.add(8);
        mexCoord.add(23);
        coordenadas.put("México", mexCoord);
        ArrayList<Integer> venCoord = new ArrayList<>();
        venCoord.add(14);
        venCoord.add(29);
        coordenadas.put("Venezuela", venCoord);
        ArrayList<Integer> brCoord = new ArrayList<>();
        brCoord.add(19);
        brCoord.add(29);
        coordenadas.put("Brasil", brCoord);
        ArrayList<Integer> perCoord = new ArrayList<>();
        perCoord.add(16);
        perCoord.add(36);
        coordenadas.put("Peru", perCoord);
        ArrayList<Integer> argCoord = new ArrayList<>();
        argCoord.add(19);
        argCoord.add(38);
        coordenadas.put("Argentina", argCoord);
        ArrayList<Integer> ruCoord = new ArrayList<>();
        ruCoord.add(31);
        ruCoord.add(11);
        coordenadas.put("Reino Unido", ruCoord);
        ArrayList<Integer> suCoord = new ArrayList<>();
        suCoord.add(35);
        suCoord.add(11);
        coordenadas.put("Suécia", suCoord);
        ArrayList<Integer> poCoord = new ArrayList<>();
        poCoord.add(39);
        poCoord.add(14);
        coordenadas.put("Polônia", poCoord);
        ArrayList<Integer> ucCoord = new ArrayList<>();
        ucCoord.add(40);
        ucCoord.add(16);
        coordenadas.put("Ucrânia", ucCoord);
        ArrayList<Integer> romCoord = new ArrayList<>();
        romCoord.add(39);
        romCoord.add(18);
        coordenadas.put("Romênia", romCoord);
        ArrayList<Integer> itaCoord = new ArrayList<>();
        itaCoord.add(35);
        itaCoord.add(18);
        coordenadas.put("Itália", itaCoord);
        ArrayList<Integer> frCoord = new ArrayList<>();
        frCoord.add(32);
        frCoord.add(17);
        coordenadas.put("França", frCoord);
        ArrayList<Integer> espCoord = new ArrayList<>();
        espCoord.add(30);
        espCoord.add(19);
        coordenadas.put("Espanha", espCoord);
        ArrayList<Integer> argeCoord = new ArrayList<>();
        argeCoord.add(30);
        argeCoord.add(25);
        coordenadas.put("Argélia", argeCoord);
        ArrayList<Integer> nigCoord = new ArrayList<>();
        nigCoord.add(30);
        nigCoord.add(29);
        coordenadas.put("Nigéria", nigCoord);
        ArrayList<Integer> egeCoord = new ArrayList<>();
        egeCoord.add(37);
        egeCoord.add(27);
        coordenadas.put("Egito", egeCoord);
        ArrayList<Integer> somCoord = new ArrayList<>();
        somCoord.add(42);
        somCoord.add(33);
        coordenadas.put("Somália", somCoord);
        ArrayList<Integer> agCoord = new ArrayList<>();
        agCoord.add(38);
        agCoord.add(34);
        coordenadas.put("Angola", agCoord);
        ArrayList<Integer> afCoord = new ArrayList<>();
        afCoord.add(38);
        afCoord.add(39);
        coordenadas.put("África do Sul", afCoord);
        ArrayList<Integer> estCoord = new ArrayList<>();
        estCoord.add(46);
        estCoord.add(10);
        coordenadas.put("Estônia", estCoord);
        ArrayList<Integer> letCoord = new ArrayList<>();
        letCoord.add(46);
        letCoord.add(13);
        coordenadas.put("Letônia", letCoord);
        ArrayList<Integer> rusCoord = new ArrayList<>();
        rusCoord.add(54);
        rusCoord.add(10);
        coordenadas.put("Russía", rusCoord);
        ArrayList<Integer> sibCoord = new ArrayList<>();
        sibCoord.add(60);
        sibCoord.add(10);
        coordenadas.put("Sibéria", sibCoord);
        ArrayList<Integer> cazCoord = new ArrayList<>();
        cazCoord.add(59);
        cazCoord.add(15);
        coordenadas.put("Cazaquistão", cazCoord);
        ArrayList<Integer> tuCoord = new ArrayList<>();
        tuCoord.add(47);
        tuCoord.add(17);
        coordenadas.put("Turquia", tuCoord);
        ArrayList<Integer> monCoord = new ArrayList<>();
        monCoord.add(59);
        monCoord.add(18);
        coordenadas.put("Mongólia", monCoord);
        ArrayList<Integer> japCoord = new ArrayList<>();
        japCoord.add(64);
        japCoord.add(18);
        coordenadas.put("Japão", japCoord);
        ArrayList<Integer> sirCoord = new ArrayList<>();
        sirCoord.add(45);
        sirCoord.add(20);
        coordenadas.put("Síria", sirCoord);
        ArrayList<Integer> paqCoord = new ArrayList<>();
        paqCoord.add(50);
        paqCoord.add(20);
        coordenadas.put("Paquistão", paqCoord);
        ArrayList<Integer> chiCoord = new ArrayList<>();
        chiCoord.add(53);
        chiCoord.add(20);
        coordenadas.put("China", chiCoord);
        ArrayList<Integer> cnCoord = new ArrayList<>();
        cnCoord.add(58);
        cnCoord.add(21);
        coordenadas.put("Coréia do Norte", cnCoord);
        ArrayList<Integer> csCoord = new ArrayList<>();
        csCoord.add(58);
        csCoord.add(23);
        coordenadas.put("Coréia do Sul", csCoord);
        ArrayList<Integer> jorCoord = new ArrayList<>();
        jorCoord.add(43);
        jorCoord.add(24);
        coordenadas.put("Jordânia", jorCoord);
        ArrayList<Integer> iraqCoord = new ArrayList<>();
        iraqCoord.add(46);
        iraqCoord.add(24);
        coordenadas.put("Iraque", iraqCoord);
        ArrayList<Integer> iraCoord = new ArrayList<>();
        iraCoord.add(49);
        iraCoord.add(24);
        coordenadas.put("Irã", iraCoord);
        ArrayList<Integer> araCoord = new ArrayList<>();
        araCoord.add(46);
        araCoord.add(28);
        coordenadas.put("Arábia Saudita", araCoord);
        ArrayList<Integer> indCoord = new ArrayList<>();
        indCoord.add(54);
        indCoord.add(27);
        coordenadas.put("Índia", indCoord);
        ArrayList<Integer> banCoord = new ArrayList<>();
        banCoord.add(57);
        banCoord.add(26);
        coordenadas.put("Bangladesh", banCoord);
        ArrayList<Integer> taiCoord = new ArrayList<>();
        taiCoord.add(60);
        taiCoord.add(25);
        coordenadas.put("Tailândia", taiCoord);
        ArrayList<Integer> indoCoord = new ArrayList<>();
        indoCoord.add(60);
        indoCoord.add(34);
        coordenadas.put("Indonésia", indoCoord);
        ArrayList<Integer> austCoord = new ArrayList<>();
        austCoord.add(60);
        austCoord.add(41);
        coordenadas.put("Austrália", austCoord);
        ArrayList<Integer> pertCoord = new ArrayList<>();
        pertCoord.add(55);
        pertCoord.add(41);
        coordenadas.put("Perth", pertCoord);
        ArrayList<Integer> nzCoord = new ArrayList<>();
        nzCoord.add(62);
        nzCoord.add(44);
        coordenadas.put("Nova Zelândia", nzCoord);
        
		this.listaExercitos = new ArrayList<Exercito>();
		
		for (Map.Entry<String, ArrayList<Integer>> entry : coordenadas.entrySet()) {
            ArrayList<Integer> valores = entry.getValue();
            listaExercitos.add(new Exercito((1024*valores.get(0)/68)-20, (700*valores.get(1)/52)-16, 0, entry.getKey()));
        }
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bg, 0, 0, 1024, 700, null);
		g2d.drawImage(source, 0, 0, 1024, 700,null);
		
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
			g2d.fill(e.elip);			
			
			g2d.setPaint(Color.DARK_GRAY);
			g2d.draw(e.elip);
			
			if (e.color != 5)
				g2d.setPaint(Color.BLACK);
			else
				g2d.setPaint(Color.WHITE);
			
			g2d.drawString(Integer.toString(e.number), e.x + e.w/2 - 5, e.y + e.h/2 + 8); //esse -5 e + 8 foi no olhômetro
		}
	}
	
	public void repaintExe(int color, int number, String nome) {
		for (Exercito e: listaExercitos) {
			if (nome.equals(e.nome)) {
				e.color = color;
				e.number = number;
				break;
			}
		}
	}
	
}
