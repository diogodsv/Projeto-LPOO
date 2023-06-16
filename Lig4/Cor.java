package Lig4;

public class Cor {
	public static final Cor AMARELO = new Cor("Amarelo", "A");
    public static final Cor VERMELHO = new Cor("Vermelho", "V");

    private String nome;
    private String codigo;

    private Cor(String nome, String codigo) {
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
