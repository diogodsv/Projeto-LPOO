package tabuleiro;

import jogador.Cor;
import jogador.Jogador;
import jogador.Peca;
import jogo.ValorAtributoInvalidoException;

public class Tabuleiro implements ITabuleiro {
    protected static final int COLUNAS = 7;
    protected static final int LINHAS = 6;
    protected Peca[][] grid;
    protected Peca peca1;
    protected Peca peca2;
    private int nivel;

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

    @Override
    public boolean isColunaCheia(int coluna) {
        return grid[0][coluna] != null;
    }

    @Override
    public void inserirPeca(int coluna, Jogador jogador) {
        int linha = LINHAS - 1;
        while (linha >= 0 && grid[linha][coluna] != null) {
            linha--;
        }

        if (linha >= 0) {
            if (jogador.getCor() == Cor.AMARELO) {
                grid[linha][coluna] = new Peca(jogador);
                peca1 = grid[linha][coluna];
            } else {
                grid[linha][coluna] = new Peca(jogador);
                peca2 = grid[linha][coluna];
            }

        }
    }

    @Override
    public boolean verificarVitoriaVertical(Peca peca, String codigo) {
        for (int i = 0; i < LINHAS - 3; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (peca != null && grid[i][j] != null) {
                    if (grid[i][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 1][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 2][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 3][j].getJogador().getCor().getCodigo().equals(codigo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean verificarVitoriaHorizontal(Peca peca, String codigo) {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS - 3; j++) {
                if (peca != null && grid[i][j] != null &&
                        (grid[i][j + 1] != null && grid[i][j + 2] != null && grid[i][j + 3] != null)) {
                    if ((grid[i][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i][j + 1].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i][j + 2].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i][j + 3].getJogador().getCor().getCodigo().equals(codigo))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean verificarVitoriaDiagonalAscendente(Peca peca, String codigo) {
        for (int i = 3; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS - 3; j++) {
                if (peca != null && grid[i][j] != null &&
                        grid[i - 1][j + 1] != null &&
                        grid[i - 2][j + 2] != null &&
                        grid[i - 3][j + 3] != null) {
                    if (grid[i][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i - 1][j + 1].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i - 2][j + 2].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i - 3][j + 3].getJogador().getCor().getCodigo().equals(codigo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean verificarVitoriaDiagonalDescendente(Peca peca, String codigo) {
        for (int i = 0; i < LINHAS - 3; i++) {
            for (int j = 0; j < COLUNAS - 3; j++) {
                if (peca != null && grid[i][j] != null &&
                        grid[i + 1][j + 1] != null &&
                        grid[i + 2][j + 2] != null &&
                        grid[i + 3][j + 3] != null) {
                    if (grid[i][j].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 1][j + 1].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 2][j + 2].getJogador().getCor().getCodigo().equals(codigo) &&
                            grid[i + 3][j + 3].getJogador().getCor().getCodigo().equals(codigo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int verificarVitoria() {
        if (peca1 != null && (verificarVitoriaVertical(peca1, "A") ||
                verificarVitoriaHorizontal(peca1, "A") ||
                verificarVitoriaDiagonalAscendente(peca1, "A") ||
                verificarVitoriaDiagonalDescendente(peca1, "A"))) {
            return 1;
        } else if (peca2 != null && (verificarVitoriaVertical(peca2, "V") ||
                verificarVitoriaHorizontal(peca2, "V") ||
                verificarVitoriaDiagonalAscendente(peca2, "V") ||
                verificarVitoriaDiagonalDescendente(peca2, "V"))) {
            return 2;
        }

        return 0;
    }

    @Override
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

    public Peca[][] getGrid() {
        return grid;
    }

    public Peca getPeca1() {
        return peca1;
    }

    public Peca getPeca2() {
        return peca2;
    }

    public int getColunas() {
        return COLUNAS;
    }

    public int getLinhas() {
        return LINHAS;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel < 1 || nivel > 3) {
            throw new ValorAtributoInvalidoException("Nível de maluquice inválido. Deve ser um valor entre 1 e 3.");
        }
        this.nivel = nivel;
    }

}