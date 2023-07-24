package jogador;

import jogo.ValorAtributoInvalidoException;

public class Jogador {
    private String nome;
    private Cor cor;

    public Jogador(String nome, Cor cor) {
        if (nome == null || nome.isEmpty()) {
            throw new ValorAtributoInvalidoException("O nome do jogador não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        if (cor == null) {
            throw new ValorAtributoInvalidoException("Cor do jogador não pode ser nula.");
        }
        this.cor = cor;
    }
}
