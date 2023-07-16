package tabuleiro;

import jogador.Cor;
import jogador.Jogador;
import jogador.Peca;

public class TabuleiroTurboMaluco extends TabuleiroTurbo {

    public void inserirPeca(int coluna, Jogador jogador) {
        Peca[][] grid = getGrid();

        int linha = getLinhas() - 1;
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

            alterarPecasVizinhas(linha, coluna, jogador);
        }
    }

    public void alterarPecasVizinhas(int linha, int coluna, Jogador jogador) {
        int nivel = getNivel();
        if (nivel == 1) {
            alterarPecasVizinhasHorizontais(linha, coluna, jogador);
            alterarPecasVizinhasVerticais(linha, coluna, jogador);
        } else if (nivel == 2) {
            alterarPecasVizinhasHorizontais(linha, coluna, jogador);
            alterarPecasVizinhasVerticais(linha, coluna, jogador);
            alterarPecasVizinhasDiagonaisAscendentes(linha, coluna, jogador);
        } else if (nivel == 3) {
            alterarPecasVizinhasHorizontais(linha, coluna, jogador);
            alterarPecasVizinhasVerticais(linha, coluna, jogador);
            alterarPecasVizinhasDiagonaisAscendentes(linha, coluna, jogador);
            alterarPecasVizinhasDiagonaisDescendentes(linha, coluna, jogador);
        }
    }

    public void alterarPecasVizinhasHorizontais(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha, coluna - 1, jogador);
        alterarPecaVizinha(linha, coluna + 1, jogador);
    }

    public void alterarPecasVizinhasVerticais(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha - 1, coluna, jogador);
        alterarPecaVizinha(linha + 1, coluna, jogador);
    }

    public void alterarPecasVizinhasDiagonaisAscendentes(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha + 1, coluna - 1, jogador);
        alterarPecaVizinha(linha - 1, coluna + 1, jogador);
    }

    public void alterarPecasVizinhasDiagonaisDescendentes(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha - 1, coluna - 1, jogador);
        alterarPecaVizinha(linha + 1, coluna + 1, jogador);
    }
}
