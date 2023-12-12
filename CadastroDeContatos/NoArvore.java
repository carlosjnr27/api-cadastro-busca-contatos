public class NoArvore {
    Contato contato;
    NoArvore esquerda;
    NoArvore direita;

    public NoArvore(Contato contato) {
        this.contato = contato;
        this.esquerda = null;
        this.direita = null;
    }
}
