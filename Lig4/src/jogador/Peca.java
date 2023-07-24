package jogador;

import jogo.ValorAtributoInvalidoException;

public class Peca {

    private Jogador jogador;
    private Cor cor;

    public Peca(Jogador jogador) {
        if (jogador == null) {
            throw new ValorAtributoInvalidoException("O jogador da peça não pode ser nulo.");
        }
        this.jogador = jogador;
        this.cor = jogador.getCor();
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        if (jogador == null) {
            throw new ValorAtributoInvalidoException("Jogador não pode ser nulo.");
        }
        this.jogador = jogador;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        if (cor == null) {
            throw new ValorAtributoInvalidoException("Cor não pode ser nulo.");
        }
        this.cor = cor;
    }
}
