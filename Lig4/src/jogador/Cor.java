package jogador;

public class Cor {
    public static final Cor AMARELO = new Cor("Amarelo", "A");
    public static final Cor VERMELHO = new Cor("Vermelho", "V");

    private final String nome;
    private final String codigo;

    public Cor(String nome, String codigo) {
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
