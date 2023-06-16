package Lig4;

public class Tabuleiro {
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
        System.out.println("1 2 3 4 5 6 7");
    }
}
