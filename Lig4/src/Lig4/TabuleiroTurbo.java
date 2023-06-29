package Lig4;

public class TabuleiroTurbo extends Tabuleiro {

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

            alterarPecasVizinhas(linha, coluna, jogador);
        }
    }

    private void alterarPecasVizinhas(int linha, int coluna, Jogador jogador) {
        alterarPecaVizinha(linha, coluna - 1, jogador);
        alterarPecaVizinha(linha, coluna + 1, jogador);
    }

    private void alterarPecaVizinha(int linha, int coluna, Jogador jogador) {
        if (linha >= 0 && linha < LINHAS && coluna >= 0 && coluna < COLUNAS && grid[linha][coluna] != null) {
            Peca pecaVizinha = new Peca(jogador);
            pecaVizinha.setCor(jogador.getCor());
            grid[linha][coluna] = pecaVizinha;
        }
    }

}
