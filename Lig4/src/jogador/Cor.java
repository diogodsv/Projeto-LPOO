package jogador;

import jogo.ValorAtributoInvalidoException;

public class Cor {
    public static final Cor AMARELO = new Cor("Amarelo", "A");
    public static final Cor VERMELHO = new Cor("Vermelho", "V");

    private final String nome;
    private final String codigo;

    public Cor(String nome, String codigo) {
        if (nome == null || codigo == null || nome.isEmpty() || codigo.isEmpty()) {
            throw new ValorAtributoInvalidoException("Nome e código da cor não podem ser nulos ou vazios.");
        }
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
