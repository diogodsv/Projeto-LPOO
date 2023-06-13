package Lig4;
import java.util.Scanner;

public class Jogo {

	private Tabuleiro board = new Tabuleiro();
	private Jogador player = new Jogador();
	private Peca piece = new Peca();
	
	//checa se uma coluna está cheia ou não
	public boolean colunaCheia(int coluna) {
		if(board.getGrid()[0][coluna-1] == " X " || board.getGrid()[0][coluna-1] == " O ") {
			return true;
		} else {
			return false;
		}
	}
	
	//retorna a linha do tabuleiro onde a próxima casa disponível está
	public int casaDisponivel(int coluna) {
		int linha = 5;
		boolean livre = false;
		while(linha >= 0 && !livre) {
			if(board.getGrid()[linha][coluna] == " X " || board.getGrid()[linha][coluna] == " O ") {
				linha--;
			} else {
				livre = true;
			}
		}
		return linha;
	}
	
	//coloca uma peça na coluna escolhida
	public void colocarPeca() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player " + player.getTurno() + ", selecione a coluna desejada (1-7):");
		int input = scan.nextInt();
		
		while(input < 1 || input > 7 || colunaCheia(input)) {
			System.out.println("Coluna inválida, escolha outra");
			input = scan.nextInt();
		}
		
		int indexColuna = input - 1;
		piece.setTipoDaPeca(player.getTurno());
		board.getGrid()[casaDisponivel(indexColuna)][indexColuna] = piece.getTipoDaPeca();
		board.displayGrid();
		player.trocarTurno();
	}
	
	//inicia o jogo
	public void jogar() {
		board.newGrid();
		board.displayGrid();
		
		//loop for temporário para testes
		for(int i = 0; i < 6; i++) {
			colocarPeca();
		}
	}
}
