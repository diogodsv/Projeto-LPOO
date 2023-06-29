package Lig4;

public class Peca {

    private Jogador jogador;
    private Cor cor;

    public Peca(Jogador jogador) {
        this.jogador = jogador;
        this.cor = jogador.getCor();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
