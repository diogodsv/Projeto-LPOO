package tabuleiro;

import jogador.Cor;
import jogador.Jogador;
import jogador.Peca;

public class TabuleiroTurbo extends Tabuleiro {

    public void inserirPeca(int coluna, Jogador jogador) {
        Peca[][] grid = getGrid();
        int linha = getLinhas() - 1;
        while (linha >= 0 && grid[linha][coluna] != null) {
            linha--;
        }

        if (linha >= 0) {
            if (jogador.getCor() == Cor.AMARELO) {
                grid[linha][coluna] = new Peca(jogador);
            } else {
                grid[linha][coluna] = new Peca(jogador);
            }

            alterarPecasVizinhas(linha, coluna, jogador);
        }
    }

    public void alterarPecasVizinhas(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha, coluna - 1, jogador);
        alterarPecaVizinha(linha, coluna + 1, jogador);
    }

    public void alterarPecaVizinha(int linha, int coluna, Jogador jogador) {
        Peca[][] grid = getGrid();
        if (linha >= 0 && linha < getLinhas() && coluna >= 0 && coluna < getColunas() && grid[linha][coluna] != null) {
            Peca pecaVizinha = new Peca(jogador);
            pecaVizinha.setCor(jogador.getCor());
            grid[linha][coluna] = pecaVizinha;
        }
    }
}
