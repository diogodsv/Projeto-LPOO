package Lig4;
import java.util.Scanner;

public class Jogo {

	private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Jogo() {
        tabuleiro = new Tabuleiro();
    }
	
    public void iniciarJogo() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Nome do Jogador 1:");
    	String nome1 = sc.nextLine();
    	System.out.println("Nome do Jogador 2:");
    	String nome2 = sc.nextLine();
    	
    	jogador1 = new Jogador(nome1, Cor.AMARELO);
        jogador2 = new Jogador(nome2, Cor.VERMELHO);
        jogadorAtual = jogador1;
    	
    	tabuleiro.inicializarTabuleiro();
        tabuleiro.imprimirTabuleiro();
        boolean vitoria = false;

        while (!vitoria && !tabuleiro.isTabuleiroCheio()) {
            System.out.println(jogadorAtual.getNome() + ", digite a coluna (1-7) para inserir a peça: ");
            int coluna = sc.nextInt()-1;
        

            if (coluna < 0 || coluna >= Tabuleiro.COLUNAS) {
                System.out.println("Coluna inválida. Escolha outra coluna.");
                continue;
            }

            if (tabuleiro.isColunaCheia(coluna)) {
                System.out.println("A coluna está cheia. Escolha outra coluna.");
                continue;
            }

            tabuleiro.inserirPeca(coluna, jogadorAtual);
            vitoria = tabuleiro.verificarVitoria(jogadorAtual);
            tabuleiro.imprimirTabuleiro();

            if (!vitoria) {
                jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
            }
        }

        if (vitoria) {
            System.out.println("Parabéns, " + jogadorAtual.getNome() + "! Você venceu o jogo!");
        } else {
            System.out.println("O jogo terminou em empate.");
        }
    }
    
}
