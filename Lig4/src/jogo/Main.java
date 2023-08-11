package jogo;

public abstract class Main {

	public static void main(String[] args) {

		Jogo game = new Jogo();
		while (true) {
			game.iniciarJogo();
			game.exibirRanking();
		}
	}
}
