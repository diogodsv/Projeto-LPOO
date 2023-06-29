package Lig4;

public class Tabuleiro {
	public static final int COLUNAS = 7;
    public static final int LINHAS = 6;
    protected Peca[][] grid;
    protected Peca peca1;
	protected Peca peca2;

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
        	if(jogador.getCor() == Cor.AMARELO) {
        		grid[linha][coluna] = new Peca(jogador);
                peca1 = grid[linha][coluna];
        	} else {
        		grid[linha][coluna] = new Peca(jogador);
                peca2 = grid[linha][coluna];
        	}
            
        }
    }
    
    public boolean verificarVitoriaVertical(Peca peca, String codigo) {
        for(int i = 0; i < LINHAS - 3; i++) {
            for(int j = 0; j < COLUNAS; j++) {
                if (peca != null && grid[i][j] != null) {
                    if(grid[i][j].getJogador().getCor().getCodigo().equals(codigo) && 
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

    public boolean verificarVitoriaHorizontal(Peca peca, String codigo) {
        for(int i = 0; i < LINHAS; i++) {
            for(int j = 0; j < COLUNAS - 3; j++) {
                if (peca != null && grid[i][j] != null &&
                   (grid[i][j + 1] != null && grid[i][j + 2] != null && grid[i][j + 3] != null)) {
                    if((grid[i][j].getJogador().getCor().getCodigo().equals(codigo) && 
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

    public boolean verificarVitoriaDiagonalDescendente(Peca peca, String codigo) {
        for (int i = 0; i < LINHAS - 3; i++) {
            for (int j = 0; j < COLUNAS - 3; j++) {
                if (peca!= null && grid[i][j] != null &&
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

 /*   public class TabuleiroTurbo extends Tabuleiro {

    
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
            grid[linha][coluna].getJogador().setCor(jogador.getCor());
        }
    }
}
*/
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