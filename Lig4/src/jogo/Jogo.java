package jogo;

import java.util.Scanner;

import jogador.Cor;
import jogador.Jogador;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroTurbo;
import tabuleiro.TabuleiroTurboMaluco;

public class Jogo {

    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public void iniciarJogo() {
        Scanner sc = new Scanner(System.in);

        selecionarModoDeJogo(sc);
        obterNomesDosJogadores(sc);

        tabuleiro.inicializarTabuleiro();
        tabuleiro.imprimirTabuleiro();
        int vitoria = 0;

        while (vitoria == 0 && !tabuleiro.isTabuleiroCheio()) {
            System.out.println(jogadorAtual.getNome() + ", digite a coluna (1-7) para inserir a peça: ");
            int coluna = obterColunaValida(sc);

            tabuleiro.inserirPeca(coluna, jogadorAtual);
            tabuleiro.imprimirTabuleiro();

            vitoria = tabuleiro.verificarVitoria();

            if (vitoria == 0) {
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            }
        }

        exibirResultado(vitoria);

        sc.close();
    }

    public int obterColunaValida(Scanner sc) {
        int coluna = -1;
        boolean colunaValida = false;

        while (!colunaValida) {
            if (sc.hasNextInt()) {
                coluna = sc.nextInt() - 1;
                sc.nextLine(); // consumir a quebra de linha pendente
                if (coluna >= 0 && coluna < tabuleiro.getColunas()) {
                    colunaValida = true;
                } else {
                    System.out.println("Coluna inválida. Escolha outra coluna.");
                }
            } else {
                sc.nextLine(); // consumir a entrada invalida
                System.out.println("Entrada inválida. Digite um número de coluna válido.");
            }
        }

        return coluna;
    }

    public String obterNomeValido(Scanner sc, String prompt) {
        String nome;

        do {
            System.out.println(prompt);
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Nome inválido. Digite novamente:");
            }
        } while (nome.isEmpty());

        return nome;
    }

    public void obterNomesDosJogadores(Scanner sc) {
        String nome1 = obterNomeValido(sc, "Nome do Jogador 1:");
        String nome2 = obterNomeValido(sc, "Nome do Jogador 2:");

        jogador1 = new Jogador(nome1, Cor.AMARELO);
        jogador2 = new Jogador(nome2, Cor.VERMELHO);
        jogadorAtual = jogador1;
    }

    public void selecionarModoDeJogo(Scanner sc) {
        int modoDeJogo = 0;
        while (modoDeJogo != 1 && modoDeJogo != 2 && modoDeJogo != 3) {
            System.out.println("Escolha o modo de jogo:");
            System.out.println("[1] CLÁSSICO");
            System.out.println("[2] TURBO");
            System.out.println("[3] TURBO MALUCO");
            if (sc.hasNextInt()) {
                modoDeJogo = sc.nextInt();
                sc.nextLine();
                if (modoDeJogo < 1 || modoDeJogo > 3) {
                    System.out.println("Modo de jogo inválido.");
                }
            } else {
                sc.nextLine();
                System.out.println("Entrada inválida. Digite um número de modo válido.");
            }
        }

        if (modoDeJogo == 1) {
            tabuleiro = new Tabuleiro();
        } else if (modoDeJogo == 2) {
            tabuleiro = new TabuleiroTurbo();
        } else if (modoDeJogo == 3) {
            tabuleiro = new TabuleiroTurboMaluco();
            selecionarNivelDeMaluquice(sc);
        }
    }

    public void selecionarNivelDeMaluquice(Scanner sc) {
        int nivel = 0;
        while (nivel != 1 && nivel != 2 && nivel != 3) {
            System.out.println("Escolha o nível de maluquice:");
            System.out.println("[1] MALUCO");
            System.out.println("[2] MALUCO BELEZA");
            System.out.println("[3] MALUCO NO PEDAÇO");
            if (sc.hasNextInt()) {
                nivel = sc.nextInt();
                sc.nextLine();
                if (nivel < 1 || nivel > 3) {
                    System.out.println("Nível de maluquice inválido.");
                }
            } else {
                sc.nextLine();
                System.out.println("Entrada inválida. Digite um número de modo válido.");
            }
        }

        if (nivel == 1) {
            tabuleiro.setNivel(1);
        } else if (nivel == 2) {
            tabuleiro.setNivel(2);
        } else if (nivel == 3) {
            tabuleiro.setNivel(3);
        }
    }

    public void exibirResultado(int vitoria) {
        if (vitoria == 1) {
            System.out.println("Parabéns, " + jogador1.getNome() + "! Você venceu o jogo!");
        } else if (vitoria == 2) {
            System.out.println("Parabéns, " + jogador2.getNome() + "! Você venceu o jogo!");
        } else {
            System.out.println("O jogo terminou em empate.");
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