package jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jogador.Cor;
import jogador.Jogador;
import jogador.PecaGUI;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroTurbo;
import tabuleiro.TabuleiroTurboMaluco;

public class Jogo extends JFrame implements ActionListener, MouseListener {
	
	private JPanel titulo;
	private JPanel menu;
	private JPanel contrape;
	private JPanel leste;
	private JPanel oeste;
	private JPanel ranking;
	private JPanel nomesPanel;
	private JPanel tabGUI;
	private JPanel coluna1;
	private JPanel coluna2;
	private JPanel coluna3;
	private JPanel coluna4;
	private JPanel coluna5;
	private JPanel coluna6;
	private JPanel coluna7;
	private JPanel centro;
	private JLabel nomes;
	private JLabel cabecalho;
	private JLabel labels[];
	private JButton botaoJogar;
	private JButton botaoSair;
	private JButton classico;
	private JButton turbo;
	private JButton turboMaluco;
	private JButton maluco;
	private JButton malucoBeleza;
	private JButton malucoNoPedaco;
	private JButton salvar1;
	private JButton salvar2;
	private JButton jogarDeNovo;
	private JButton botaoSair2;
	private JTextField playername1;
	private JTextField playername2;
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Jogador jogador1; 
	private Jogador jogador2; 
	private Jogador jogadorAtual;
	private int coluna;
	private boolean ativado1;
	private boolean ativado2;
	private List<Jogador> winners = new ArrayList<>();
	
	public Jogo(){
		titulo = new JPanel();
		menu = new JPanel();
		contrape = new JPanel();
		leste = new JPanel();
		oeste = new JPanel();
		ranking = criarRanking();
		nomesPanel = criarNomesPanel();
		tabGUI = criarTabGUI();
		ativado1 = false;
		ativado2 = false;
		labels = new JLabel[10];
		
		titulo.setPreferredSize(new Dimension(200, 200));
		contrape.setPreferredSize(new Dimension(200, 50));
		leste.setPreferredSize(new Dimension(200, 100));
		oeste.setPreferredSize(new Dimension(200, 100));
		
		titulo.setBackground(new Color(148, 11, 217));
		menu.setBackground(new Color(148, 11, 217));
		menu.setLayout(new GridLayout(3, 1, 0, 20));
		contrape.setBackground(new Color(148, 11, 217));
		leste.setBackground(new Color(148, 11, 217));
		oeste.setBackground(new Color(148, 11, 217));
		
		nomes = new JLabel();
		nomes.setText("Diogo Vasconcelos & Lyssa Rodrigues");
		nomes.setForeground(Color.white);
		nomes.setFont(new Font("Consolas", Font.ITALIC, 20));
		nomes.setHorizontalAlignment(JLabel.CENTER);
		
		cabecalho = new JLabel();
		cabecalho.setText("LIG 4");
		cabecalho.setForeground(Color.white);
		cabecalho.setFont(new Font("Consolas", Font.BOLD, 50));
		cabecalho.setHorizontalAlignment(JLabel.CENTER);
		
		botaoJogar = new JButton("JOGAR");
		botaoSair = new JButton("SAIR");
		JButton teste = new JButton();
		
		criarBotoes(botaoJogar, teste, botaoSair);
		
		classico = new JButton("CLÁSSICO");
		turbo = new JButton("TURBO");
		turboMaluco = new JButton("TURBO MALUCO");
		
		criarBotoes(classico, turbo, turboMaluco);
		
		maluco = new JButton("MALUCO");
		malucoBeleza = new JButton("MALUCO BELEZA");
		malucoNoPedaco = new JButton("MALUCO NO PEDAÇO");
		
		criarBotoes(maluco, malucoBeleza, malucoNoPedaco);
		
		titulo.add(cabecalho);
		menu.add(botaoJogar);
		menu.add(botaoSair);
		contrape.add(nomes);
		
		this.setTitle("Lig 4");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.ORANGE);
		this.setLocationRelativeTo(null);
		
		this.add(titulo, BorderLayout.NORTH);
		this.add(menu, BorderLayout.CENTER);
		this.add(contrape, BorderLayout.SOUTH);
		this.add(leste, BorderLayout.EAST);
		this.add(oeste, BorderLayout.WEST);
	}
	
	public void criarBotoes(JButton botao1, JButton botao2, JButton botao3) {
		botao1.setFocusable(false);
		botao2.setFocusable(false);
		botao3.setFocusable(false);
		
		botao1.setFont(new Font("Consolas", Font.BOLD, 20));
		botao2.setFont(new Font("Consolas", Font.BOLD, 20));
		botao3.setFont(new Font("Consolas", Font.BOLD, 20));
		
		botao1.setForeground(Color.black);
		botao2.setForeground(Color.black);
		botao3.setForeground(Color.black);
		
		botao1.setBackground(Color.white);
		botao2.setBackground(Color.white);
		botao3.setBackground(Color.white);
		
		botao1.setBorder(BorderFactory.createEtchedBorder());
		botao2.setBorder(BorderFactory.createEtchedBorder());
		botao3.setBorder(BorderFactory.createEtchedBorder());
		
		botao1.addActionListener(this);
		botao2.addActionListener(this);
		botao3.addActionListener(this);
	}
	
	public JPanel criarRanking() {
		JPanel ranking = new JPanel();
		ranking.setBackground(new Color(148, 11, 217));
		
		JLabel textoRanking = new JLabel();
        textoRanking.setText("Ranking dos vencedores:");
        textoRanking.setForeground(Color.white);
        textoRanking.setFont(new Font("Consolas", Font.PLAIN, 35));
        textoRanking.setBounds(140, 150, 200, 30);
        ranking.add(textoRanking);
		
        jogarDeNovo = new JButton("JOGAR NOVAMENTE");
        botaoSair2 = new JButton("SAIR");
        
        jogarDeNovo.addActionListener(this);
        botaoSair2.addActionListener(this);
        
        jogarDeNovo.setFocusable(false);
        botaoSair2.setFocusable(false);
		
		jogarDeNovo.setFont(new Font("Consolas", Font.BOLD, 20));
		botaoSair2.setFont(new Font("Consolas", Font.BOLD, 20));
		
		jogarDeNovo.setForeground(Color.black);
		botaoSair2.setForeground(Color.black);
		
		jogarDeNovo.setBackground(Color.white);
		botaoSair2.setBackground(Color.white);
		
		jogarDeNovo.setBorder(BorderFactory.createEtchedBorder());
		botaoSair2.setBorder(BorderFactory.createEtchedBorder());
		
		jogarDeNovo.setPreferredSize(new Dimension(200, 50));
		botaoSair2.setPreferredSize(new Dimension(200, 50));
        
        return ranking;
    }
	
	public String[] exibirRanking() {
        Map<String, Integer> playerWins = new HashMap<>();
        for (Jogador winner : winners) {
            String nomeJogador = winner.getNome();
            playerWins.put(nomeJogador, playerWins.getOrDefault(nomeJogador, 0) + 1);
        }

        Map<Integer, List<String>> playersByWins = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : playerWins.entrySet()) {
            int wins = entry.getValue();
            String playerName = entry.getKey();
            playersByWins.computeIfAbsent(wins, k -> new ArrayList<>()).add(playerName);
        }
        
        String[] info = new String[10];
        int rank = 1;
        int i = 0;
        for (Map.Entry<Integer, List<String>> entry : playersByWins.entrySet()) {
            int wins = entry.getKey();
            List<String> players = entry.getValue();

            for (String playerName : players) {
            	info[i] = new String();
            	info[i] = rank + ". " + playerName + " - Vitórias: " + wins;
                rank++;
                i++;
            }
        }
        
        return info;
    }
	
	public JPanel criarNomesPanel() {
		JPanel nomesPanel = new JPanel();
		nomesPanel.setLayout(new GridLayout(2, 2, 10, 100));
		nomesPanel.setBackground(new Color(148, 11, 217));
		
		salvar1 = new JButton("Salvar");
		salvar2 = new JButton("Salvar");
		
		salvar1.setFocusable(false);
		salvar2.setFocusable(false);
		
		salvar1.setFont(new Font("Consolas", Font.BOLD, 20));
		salvar2.setFont(new Font("Consolas", Font.BOLD, 20));
		
		salvar1.setForeground(Color.black);
		salvar2.setForeground(Color.black);
		
		salvar1.setBackground(Color.white);
		salvar2.setBackground(Color.white);
		
		salvar1.setBorder(BorderFactory.createEtchedBorder());
		salvar2.setBorder(BorderFactory.createEtchedBorder());
		
		salvar1.addActionListener(this);
		salvar2.addActionListener(this);
		
		playername1 = new JTextField();
		playername1.setPreferredSize(new Dimension(150, 35));
		playername1.setFont(new Font("Consolas", Font.PLAIN, 25));
		playername1.setText("Nome do jogador 1");
		
		playername2 = new JTextField();
		playername2.setPreferredSize(new Dimension(150, 35));
		playername2.setFont(new Font("Consolas", Font.PLAIN, 25));
		playername2.setText("Nome do jogador 2");
		
		nomesPanel.add(playername1);
		nomesPanel.add(salvar1);
		nomesPanel.add(playername2);
		nomesPanel.add(salvar2);
		
		return nomesPanel;
	}
	
	public JPanel criarTabGUI() {
		JPanel tabGUI = new JPanel();
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(1, 7));
		
		coluna1 = new JPanel();
		coluna2 = new JPanel();
		coluna3 = new JPanel();
		coluna4 = new JPanel();
		coluna5 = new JPanel();
		coluna6 = new JPanel();
		coluna7 = new JPanel();
		
		criarColunas(coluna1, 0);
		criarColunas(coluna2, 1);
		criarColunas(coluna3, 2);
		criarColunas(coluna4, 3);
		criarColunas(coluna5, 4);
		criarColunas(coluna6, 5);
		criarColunas(coluna7, 6);
		
		tabGUI.setLayout(new BorderLayout());
		tabGUI.add(centro, BorderLayout.CENTER);
		
		return tabGUI;
	}
	
	public void criarColunas(JPanel colunaPanel, int coluna) {
		
		colunaPanel.setBackground(Color.blue);
		colunaPanel.setLayout(new GridLayout(6, 1));
		for (int i = 0; i < 6; i++) {
			if(tabuleiro.getGrid()[i][coluna] == null) {
				PecaGUI peca = new PecaGUI(Color.white);
				colunaPanel.add(peca);
			} else if(tabuleiro.getGrid()[i][coluna].getCor().getCodigo().equals("A")) {
				PecaGUI peca = new PecaGUI(Color.yellow);
				colunaPanel.add(peca);
			} else {
				PecaGUI peca = new PecaGUI(Color.red);
				colunaPanel.add(peca);
			}
        }
		colunaPanel.addMouseListener(this);
		centro.add(colunaPanel);
	}
	
	public void limparTela() {
		remove(menu);
		cabecalho.setText("Digite o nome dos jogadores:");
		leste.setPreferredSize(new Dimension(50, 0));
		oeste.setPreferredSize(new Dimension(50, 0));
		add(nomesPanel);
		revalidate();
		repaint();
	}
	
	public void jogar() {
        tabuleiro.inserirPeca(coluna, jogadorAtual);
        
        recarregarColunas();

        int vitoria = tabuleiro.verificarVitoria();

        if (vitoria == 0 && !tabuleiro.isTabuleiroCheio()) {
        	jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        	cabecalho.setText(jogadorAtual.getNome() + ", selecione uma coluna para inserir a peça");
        	cabecalho.setFont(new Font("Consolas", Font.PLAIN, 20));
        } else {
        	exibirResultado(vitoria);
        }
    }
	
	public void recarregarColunas() {
		centro.remove(coluna1);
        centro.remove(coluna2);
        centro.remove(coluna3);
        centro.remove(coluna4);
        centro.remove(coluna5);
        centro.remove(coluna6);
        centro.remove(coluna7);
        revalidate();
        repaint();
        
        coluna1 = new JPanel();
        coluna2 = new JPanel();
        coluna3 = new JPanel();
        coluna4 = new JPanel();
        coluna5 = new JPanel();
        coluna6 = new JPanel();
        coluna7 = new JPanel();

        criarColunas(coluna1, 0);
        criarColunas(coluna2, 1);
        criarColunas(coluna3, 2);
        criarColunas(coluna4, 3);
        criarColunas(coluna5, 4);
        criarColunas(coluna6, 5);
        criarColunas(coluna7, 6);
        revalidate();
        repaint();
	}
	
	public void exibirResultado(int vitoria) {
		Jogador winner = null;
        if (vitoria == 1) {
        	winner = jogador1;
        	winners.add(winner);
        	fimDeJogo("Parabéns, " + jogador1.getNome() + "! Você venceu o jogo!\n");
        } else if (vitoria == 2) {
        	winner = jogador2;
        	winners.add(winner);
        	fimDeJogo("Parabéns, " + jogador2.getNome() + "! Você venceu o jogo!");
        } else {
        	fimDeJogo("O jogo terminou em empate");
        }
    }
	
	public void fimDeJogo(String mensagem) {
		cabecalho.setText(mensagem);
    	this.remove(tabGUI);
    	tabuleiro.inicializarTabuleiro();
    	recarregarColunas();
    	this.add(ranking);
    	for(int i = 0; i < 10; i++) {
    		labels[i] = new JLabel(exibirRanking()[i]);
    		labels[i].setForeground(Color.white);
            labels[i].setFont(new Font("Consolas", Font.PLAIN, 30));
    		ranking.add(labels[i]);
    	}
    	ranking.add(jogarDeNovo);
        ranking.add(botaoSair2);
    	revalidate();
    	repaint();
	}
	
	public void condicaoParaJogar() {
		if(!tabuleiro.isColunaCheia(coluna)) {
			jogar();
		} else {
			cabecalho.setText("Essa coluna está cheia!");
		}
	}
	
	public void iniciarJogo() {
		tabuleiro.inicializarTabuleiro();
		this.remove(nomesPanel);
		titulo.setPreferredSize(new Dimension(100, 50));
		contrape.setPreferredSize(new Dimension(100, 50));
		leste.setPreferredSize(new Dimension(50, 100));
		oeste.setPreferredSize(new Dimension(50, 100));
		this.add(tabGUI);
		cabecalho.setText(jogadorAtual.getNome() + ", selecione uma coluna para inserir a peça");
		cabecalho.setFont(new Font("Consolas", Font.PLAIN, 20));
        titulo.add(cabecalho);
		revalidate();
		repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botaoJogar) {
			menu.remove(botaoJogar);
			menu.remove(botaoSair);
			contrape.remove(nomes);
			cabecalho.setText("Selecione o modo de jogo:");
			cabecalho.setFont(new Font("Consolas", Font.PLAIN, 25));
			menu.add(classico);
			menu.add(turbo);
			menu.add(turboMaluco);
			revalidate();
			repaint();
		} else if(e.getSource() == botaoSair) {
			System.exit(0);
		} else if(e.getSource() == classico) {
			tabuleiro = new Tabuleiro();
			limparTela();
		} else if(e.getSource() == turbo) {
			tabuleiro = new TabuleiroTurbo();
			limparTela();
		} else if(e.getSource() == turboMaluco) {
			tabuleiro = new TabuleiroTurboMaluco();
			menu.remove(classico);
			menu.remove(turbo);
			menu.remove(turboMaluco);
			cabecalho.setText("Escolha o nível de maluquice:");
			menu.add(maluco);
			menu.add(malucoBeleza);
			menu.add(malucoNoPedaco);
			revalidate();
			repaint();
		} else if(e.getSource() == maluco) {
			tabuleiro.setNivel(1);
			limparTela();
		} else if(e.getSource() == malucoBeleza) {
			tabuleiro.setNivel(2);
			limparTela();
		} else if(e.getSource() == malucoNoPedaco) {
			tabuleiro.setNivel(3);
			limparTela();
		} else if(e.getSource() == salvar1) {
			String nomeSalvo1 = playername1.getText();
			jogador1 = new Jogador(nomeSalvo1, Cor.AMARELO);
			jogadorAtual = jogador1;
			salvar1.setEnabled(false);
			ativado1 = true;
			if(ativado2) {
				ativado1 = false;
				ativado2 = false;
				salvar1.setEnabled(true);
				salvar2.setEnabled(true);
				iniciarJogo();
			}
		} else if(e.getSource() == salvar2) {
			String nomeSalvo2 = playername2.getText();
			jogador2 = new Jogador(nomeSalvo2, Cor.VERMELHO);
			salvar2.setEnabled(false);
			ativado2 = true;
			if(ativado1) {
				ativado1 = false;
				ativado2 = false;
				salvar1.setEnabled(true);
				salvar2.setEnabled(true);
				iniciarJogo();
			}
		} else if(e.getSource() == jogarDeNovo) {
			for(int i = 0; i < 10; i++) {
				ranking.remove(labels[i]);
			}
			this.remove(ranking);
			this.add(menu);
			titulo.setPreferredSize(new Dimension(200, 200));
			contrape.setPreferredSize(new Dimension(200, 50));
			leste.setPreferredSize(new Dimension(200, 100));
			oeste.setPreferredSize(new Dimension(200, 100));
			cabecalho.setText("Selecione o modo de jogo:");
			cabecalho.setFont(new Font("Consolas", Font.PLAIN, 25));
			revalidate();
			repaint();
		} else if(e.getSource() == botaoSair2) {
			System.exit(0);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == coluna1) {
			coluna = 0;
			condicaoParaJogar();
		} else if(e.getSource() == coluna2) {
			coluna = 1;
			condicaoParaJogar();
		} else if(e.getSource() == coluna3) {
			coluna = 2;
			condicaoParaJogar();
		} else if(e.getSource() == coluna4) {
			coluna = 3;
			condicaoParaJogar();
		} else if(e.getSource() == coluna5) {
			coluna = 4;
			condicaoParaJogar();
		} else if(e.getSource() == coluna6) {
			coluna = 5;
			condicaoParaJogar();
		} else if(e.getSource() == coluna7) {
			coluna = 6;
			condicaoParaJogar();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == coluna1) {
			coluna1.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna2) {
			coluna2.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna3) {
			coluna3.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna4) {
			coluna4.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna5) {
			coluna5.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna6) {
			coluna6.setBackground(new Color(29, 18, 122));
		} else if(e.getSource() == coluna7) {
			coluna7.setBackground(new Color(29, 18, 122));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == coluna1) {
			coluna1.setBackground(Color.blue);
		} else if(e.getSource() == coluna2) {
			coluna2.setBackground(Color.blue);
		} else if(e.getSource() == coluna3) {
			coluna3.setBackground(Color.blue);
		} else if(e.getSource() == coluna4) {
			coluna4.setBackground(Color.blue);
		} else if(e.getSource() == coluna5) {
			coluna5.setBackground(Color.blue);
		} else if(e.getSource() == coluna6) {
			coluna6.setBackground(Color.blue);
		} else if(e.getSource() == coluna7) {
			coluna7.setBackground(Color.blue);
		}
		
	}

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        if (tabuleiro == null) {
            throw new ValorAtributoInvalidoException("Tabuleiro não pode ser nulo.");
        }
        this.tabuleiro = tabuleiro;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        if (jogador1 == null) {
            throw new ValorAtributoInvalidoException("Jogador1 não pode ser nulo.");
        }

        if (jogador1.getCor() != Cor.AMARELO && jogador1.getCor() != Cor.VERMELHO) {
            throw new ValorAtributoInvalidoException("Cor inválida para Jogador 1.");
        }
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        if (jogador2 == null) {
            throw new ValorAtributoInvalidoException("Jogador2 não pode ser nulo.");
        }

        if (jogador2.getCor() != Cor.AMARELO && jogador2.getCor() != Cor.VERMELHO) {
            throw new ValorAtributoInvalidoException("Cor inválida para Jogador 2.");
        }
        this.jogador2 = jogador2;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        if (jogadorAtual == null) {
            throw new ValorAtributoInvalidoException("JogadorAtual não pode ser nulo.");
        }

        if (jogadorAtual.getCor() != Cor.AMARELO && jogadorAtual.getCor() != Cor.VERMELHO) {
            throw new ValorAtributoInvalidoException("Cor inválida para JogadorAtual.");
        }
        this.jogadorAtual = jogadorAtual;
    }
}