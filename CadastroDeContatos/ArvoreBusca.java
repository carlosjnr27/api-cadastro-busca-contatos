public class ArvoreBusca {
    private NoArvore raiz;

    public ArvoreBusca() {
        this.raiz = null;
    }

    public void inserir(Contato contato) {
        this.raiz = inserirRec(this.raiz, contato);
    }

    private NoArvore inserirRec(NoArvore raizAtual, Contato contato) {
        if (raizAtual == null) {
            return new NoArvore(contato);
        }

        if (contato.getNome().compareTo(raizAtual.contato.getNome()) < 0) {
            raizAtual.esquerda = inserirRec(raizAtual.esquerda, contato);
        } else if (contato.getNome().compareTo(raizAtual.contato.getNome()) > 0) {
            raizAtual.direita = inserirRec(raizAtual.direita, contato);
        }

        return raizAtual;
    }

    public Contato buscar(String nome) {
        return buscarRec(this.raiz, nome);
    }

    private Contato buscarRec(NoArvore raizAtual, String nome) {
        if (raizAtual == null || raizAtual.contato.getNome().equals(nome)) {
            return raizAtual != null ? raizAtual.contato : null;
        }

        if (nome.compareTo(raizAtual.contato.getNome()) < 0) {
            return buscarRec(raizAtual.esquerda, nome);
        } else {
            return buscarRec(raizAtual.direita, nome);
        }
    }
}
