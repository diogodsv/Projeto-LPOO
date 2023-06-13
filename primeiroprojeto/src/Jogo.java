import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        jogador1 = new Jogador("Jogador 1", Cor.AMARELO);
        jogador2 = new Jogador("Jogador 2", Cor.VERMELHO);
        jogadorAtual = jogador1;
    }

    public void iniciarJogo() {
        tabuleiro.inicializarTabuleiro();
        boolean vitoria = false;

        while (!vitoria && !tabuleiro.isTabuleiroCheio()) {
            System.out.println("Jogador " + jogadorAtual.getNome() + ", é a sua vez.");
            System.out.print("Digite a coluna (0-6) para inserir a peça: ");
            Scanner sc = new Scanner(System.in);
            int coluna = sc.nextInt();
        

            if (coluna < 0 || coluna >= Tabuleiro.COLUNAS) {
                System.out.println("Coluna inválida. Escolha outra coluna.");
                continue;
            }

            if (tabuleiro.isColunaCheia(coluna)) {
                System.out.println("A coluna está cheia. Escolha outra coluna.");
                continue;
            }

            tabuleiro.inserirPeca(coluna, jogadorAtual);
            vitoria = tabuleiro.verificarVitoria(jogadorAtual);
            tabuleiro.imprimirTabuleiro();

            if (!vitoria) {
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            }
        }

        if (vitoria) {
            System.out.println("Parabéns, Jogador " + jogadorAtual.getNome() + "! Você venceu o jogo!");
        } else {
            System.out.println("O jogo terminou em empate.");
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}

class Tabuleiro {
    public static final int COLUNAS = 7;
    public static final int LINHAS = 6;
    private Peca[][] grid;

    public Tabuleiro() {
        grid = new Peca[LINHAS][COLUNAS];
    }

    public void inicializarTabuleiro() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                grid[i][j] = null;
            }
        }
    }

    public boolean isColunaCheia(int coluna) {
        return grid[0][coluna] != null;
    }

    public void inserirPeca(int coluna, Jogador jogador) {
        int linha = LINHAS - 1;
        while (linha >= 0 && grid[linha][coluna] != null) {
            linha--;
        }

        if (linha >= 0) {
            grid[linha][coluna] = new Peca(jogador);
        }
    }

    public boolean verificarVitoria(Jogador jogador) {
        // aqui e pra colocar logica para verificar a vitoria no jogo
        // retornar true se o jogador vencer, caso contrario, retorna false
        return false;
    }

    public boolean isTabuleiroCheio() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTabuleiro() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (grid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j].getJogador().getCor().getCodigo() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }
}

class Peca {
    private Jogador jogador;

    public Peca(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogador getJogador() {
        return jogador;
    }
}

class Jogador {
    private String nome;
    private Cor cor;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }
}

class Cor {
    public static final Cor AMARELO = new Cor("Amarelo", "A");
    public static final Cor VERMELHO = new Cor("Vermelho", "V");

    private String nome;
    private String codigo;

    private Cor(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
