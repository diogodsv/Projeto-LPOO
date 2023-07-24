package tabuleiro;

import jogador.Jogador;
import jogador.Peca;

public interface ITabuleiro {
	
	public void inicializarTabuleiro();
	public boolean isColunaCheia(int coluna);
	public void inserirPeca(int coluna, Jogador jogador);
	public boolean verificarVitoriaVertical(Peca peca, String codigo);
	public boolean verificarVitoriaHorizontal(Peca peca, String codigo);
	public boolean verificarVitoriaDiagonalAscendente(Peca peca, String codigo);
	public boolean verificarVitoriaDiagonalDescendente(Peca peca, String codigo);
	public int verificarVitoria();
	public boolean isTabuleiroCheio();
	public void imprimirTabuleiro();
	
}
