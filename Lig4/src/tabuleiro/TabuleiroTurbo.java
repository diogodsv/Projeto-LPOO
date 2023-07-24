package tabuleiro;

import jogador.Cor;
import jogador.Jogador;
import jogador.Peca;
import jogo.ValorAtributoInvalidoException;

public class TabuleiroTurbo extends Tabuleiro {

    public void inserirPeca(int coluna, Jogador jogador) {
        if (jogador == null) {
            throw new ValorAtributoInvalidoException("O jogador não pode ser nulo.");
        }
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
        alterarPecaVizinha(linha, coluna - 1, jogador);
        alterarPecaVizinha(linha, coluna + 1, jogador);
    }

    public void alterarPecaVizinha(int linha, int coluna, Jogador jogador) {
        Peca[][] grid = getGrid();
        int linhas = getLinhas();
        int colunas = getColunas();

        if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas && grid[linha][coluna] != null) {
            Peca pecaVizinha = new Peca(jogador);
            pecaVizinha.setCor(jogador.getCor());
            grid[linha][coluna] = pecaVizinha;
        }
    }

    @Override
    public int verificarVitoria() {
        Peca peca1 = getPeca1();
        Peca peca2 = getPeca2();

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

}