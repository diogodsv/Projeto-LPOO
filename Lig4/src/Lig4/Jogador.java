package Lig4;

public class Jogador {
	private String nome;
    private Cor cor;
	
	public Jogador(String nome, Cor cor) {
		this.nome = nome;
        this.cor = cor;
	}
	
	public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }
    
    public void setCor (Cor cor) {
        this.cor = cor;
    }
}
