package jogo;

public class ValorAtributoInvalidoException extends RuntimeException {
    private String mensagem;

    public ValorAtributoInvalidoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
