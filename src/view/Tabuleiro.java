package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ControllerAPI;
import model.ModelAPI;

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
        alascaCoord.add(12);
        alascaCoord.add(18);
        coordenadas.put("Alasca", alascaCoord);
        ArrayList<Integer> calgaryCoord = new ArrayList<>();
        calgaryCoord.add(23);
        calgaryCoord.add(20);
        coordenadas.put("Calgary", calgaryCoord);
        ArrayList<Integer> groCoord = new ArrayList<>();
        groCoord.add(41);
        groCoord.add(14);
        coordenadas.put("Groelândia", groCoord);
        ArrayList<Integer> vanCoord = new ArrayList<>();
        vanCoord.add(20);
        vanCoord.add(23);
        coordenadas.put("Groelândia", vanCoord);
        ArrayList<Integer> qCoord = new ArrayList<>();
        qCoord.add(34);
        qCoord.add(24);
        coordenadas.put("Quebec", qCoord);
        ArrayList<Integer> calCoord = new ArrayList<>();
        calCoord.add(16);
        calCoord.add(32);
        coordenadas.put("Califórnia", calCoord);
        ArrayList<Integer> texCoord = new ArrayList<>();
        texCoord.add(22);
        texCoord.add(32);
        coordenadas.put("Texas", texCoord);
        ArrayList<Integer> nyCoord = new ArrayList<>();
        nyCoord.add(30);
        nyCoord.add(32);
        coordenadas.put("Nova York", nyCoord);
        ArrayList<Integer> mexCoord = new ArrayList<>();
        mexCoord.add(16);
        mexCoord.add(46);
        coordenadas.put("México", mexCoord);
        ArrayList<Integer> venCoord = new ArrayList<>();
        venCoord.add(22);
        venCoord.add(52);
        coordenadas.put("Venezuela", venCoord);
        ArrayList<Integer> brCoord = new ArrayList<>();
        brCoord.add(34);
        brCoord.add(54);
        coordenadas.put("Brasil", brCoord);
        ArrayList<Integer> perCoord = new ArrayList<>();
        perCoord.add(28);
        perCoord.add(66);
        coordenadas.put("Peru", perCoord);
        ArrayList<Integer> argCoord = new ArrayList<>();
        argCoord.add(28);
        argCoord.add(82);
        coordenadas.put("Argentina", argCoord);
        ArrayList<Integer> ruCoord = new ArrayList<>();
        ruCoord.add(37);
        ruCoord.add(24);
        coordenadas.put("Reino Unido", ruCoord);
        ArrayList<Integer> suCoord = new ArrayList<>();
        suCoord.add(53);
        suCoord.add(22);
        coordenadas.put("Suécia", suCoord);
        ArrayList<Integer> poCoord = new ArrayList<>();
        poCoord.add(54);
        poCoord.add(28);
        coordenadas.put("Polônia", poCoord);
        ArrayList<Integer> ucCoord = new ArrayList<>();
        ucCoord.add(58);
        ucCoord.add(33);
        coordenadas.put("Ucrânia", ucCoord);
        ArrayList<Integer> romCoord = new ArrayList<>();
        romCoord.add(54);
        romCoord.add(39);
        coordenadas.put("Romênia", romCoord);
        ArrayList<Integer> itaCoord = new ArrayList<>();
        itaCoord.add(54);
        itaCoord.add(27);
        coordenadas.put("Itália", itaCoord);
        ArrayList<Integer> frCoord = new ArrayList<>();
        frCoord.add(46);
        frCoord.add(28);
        coordenadas.put("França", frCoord);
        ArrayList<Integer> espCoord = new ArrayList<>();
        espCoord.add(40);
        espCoord.add(32);
        coordenadas.put("Espanha", espCoord);
        ArrayList<Integer> argeCoord = new ArrayList<>();
        argeCoord.add(40);
        argeCoord.add(44);
        coordenadas.put("Argélia", argeCoord);
        ArrayList<Integer> nigCoord = new ArrayList<>();
        nigCoord.add(40);
        nigCoord.add(56);
        coordenadas.put("Nigéria", nigCoord);
        ArrayList<Integer> egeCoord = new ArrayList<>();
        egeCoord.add(54);
        egeCoord.add(55);
        coordenadas.put("Egito", egeCoord);
        ArrayList<Integer> somCoord = new ArrayList<>();
        somCoord.add(58);
        somCoord.add(69);
        coordenadas.put("Somália", somCoord);
        ArrayList<Integer> agCoord = new ArrayList<>();
        agCoord.add(54);
        agCoord.add(66);
        coordenadas.put("Angola", agCoord);
        ArrayList<Integer> afCoord = new ArrayList<>();
        afCoord.add(56);
        afCoord.add(74);
        coordenadas.put("África do Sul", afCoord);
        ArrayList<Integer> estCoord = new ArrayList<>();
        estCoord.add(73);
        estCoord.add(22);
        coordenadas.put("Estônia", estCoord);
        ArrayList<Integer> letCoord = new ArrayList<>();
        letCoord.add(73);
        letCoord.add(30);
        coordenadas.put("Letônia", letCoord);
        ArrayList<Integer> rusCoord = new ArrayList<>();
        rusCoord.add(89);
        rusCoord.add(22);
        coordenadas.put("Russía", rusCoord);
        ArrayList<Integer> sibCoord = new ArrayList<>();
        sibCoord.add(105);
        sibCoord.add(22);
        coordenadas.put("Sibéria", sibCoord);
        ArrayList<Integer> cazCoord = new ArrayList<>();
        cazCoord.add(99);
        cazCoord.add(28);
        coordenadas.put("Cazaquistão", cazCoord);
        ArrayList<Integer> tuCoord = new ArrayList<>();
        tuCoord.add(76);
        tuCoord.add(33);
        coordenadas.put("Turquia", tuCoord);
        ArrayList<Integer> monCoord = new ArrayList<>();
        monCoord.add(103);
        monCoord.add(35);
        coordenadas.put("Mongólia", monCoord);
        ArrayList<Integer> japCoord = new ArrayList<>();
        japCoord.add(117);
        japCoord.add(35);
        coordenadas.put("Japão", japCoord);
        ArrayList<Integer> sirCoord = new ArrayList<>();
        sirCoord.add(66);
        sirCoord.add(41);
        coordenadas.put("Síria", sirCoord);
        ArrayList<Integer> paqCoord = new ArrayList<>();
        paqCoord.add(80);
        paqCoord.add(41);
        coordenadas.put("Paquistão", paqCoord);
        ArrayList<Integer> chiCoord = new ArrayList<>();
        chiCoord.add(90);
        chiCoord.add(41);
        coordenadas.put("China", chiCoord);
        ArrayList<Integer> cnCoord = new ArrayList<>();
        cnCoord.add(98);
        cnCoord.add(44);
        coordenadas.put("Coréia do Norte", cnCoord);
        ArrayList<Integer> csCoord = new ArrayList<>();
        csCoord.add(98);
        csCoord.add(48);
        coordenadas.put("Coréia do Sul", csCoord);
        ArrayList<Integer> jorCoord = new ArrayList<>();
        jorCoord.add(62);
        jorCoord.add(50);
        coordenadas.put("Jordânia", jorCoord);
        ArrayList<Integer> iraqCoord = new ArrayList<>();
        iraqCoord.add(72);
        iraqCoord.add(50);
        coordenadas.put("Iraque", iraqCoord);
        ArrayList<Integer> iraCoord = new ArrayList<>();
        iraCoord.add(79);
        iraCoord.add(49);
        coordenadas.put("Iraque", iraCoord);
        ArrayList<Integer> araCoord = new ArrayList<>();
        araCoord.add(67);
        araCoord.add(59);
        coordenadas.put("Arábia Saudita", araCoord);
        ArrayList<Integer> indCoord = new ArrayList<>();
        indCoord.add(83);
        indCoord.add(59);
        coordenadas.put("Índia", indCoord);
        ArrayList<Integer> banCoord = new ArrayList<>();
        banCoord.add(91);
        banCoord.add(59);
        coordenadas.put("Bangladesh", banCoord);
        ArrayList<Integer> taiCoord = new ArrayList<>();
        taiCoord.add(98);
        taiCoord.add(59);
        coordenadas.put("Tailândia", taiCoord);
        ArrayList<Integer> indoCoord = new ArrayList<>();
        indoCoord.add(98);
        indoCoord.add(79);
        coordenadas.put("Indonésia", indoCoord);
        ArrayList<Integer> austCoord = new ArrayList<>();
        austCoord.add(98);
        austCoord.add(95);
        coordenadas.put("Austrália", austCoord);
        ArrayList<Integer> pertCoord = new ArrayList<>();
        pertCoord.add(84);
        pertCoord.add(95);
        coordenadas.put("Perth", pertCoord);
        ArrayList<Integer> nzCoord = new ArrayList<>();
        nzCoord.add(110);
        nzCoord.add(95);
        coordenadas.put("Nova Zelândia", nzCoord);
        for (Map.Entry<String, ArrayList<Integer>> entry : coordenadas.entrySet()) {
            ArrayList<Integer> valores = entry.getValue();
            valores.set(0, 1024*valores.get(0)/127);
            valores.set(1, 768*valores.get(1)/91);
        }
        
        
		this.listaExercitos = new ArrayList<Exercito>();
		
		for (Map.Entry<String, ArrayList<Integer>> entry : coordenadas.entrySet()) {
            ArrayList<Integer> valores = entry.getValue();
            listaExercitos.add(new Exercito(valores.get(0), valores.get(1), 0));
        }
		
		JButton proxJog = new JButton(nextAction);
		JButton jogaDad = new JButton(rollDices);
		
		proxJog.setMargin(new Insets(0,0,0,0));
		proxJog.setContentAreaFilled(false);
		proxJog.setBorder(null);
		proxJog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ControllerAPI.getControllerAPI().nextAction();
			}
		});
		
		jogaDad.setMargin(new Insets(0,0,0,0));
		jogaDad.setContentAreaFilled(false);
		jogaDad.setBorder(null);
		jogaDad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ControllerAPI.getControllerAPI().attack();
			}
		});
		
		add(jogaDad);
		add(proxJog);
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
	
}
