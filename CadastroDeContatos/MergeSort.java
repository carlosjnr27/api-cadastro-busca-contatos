import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void mergeSort(List<Contato> contatos, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            mergeSort(contatos, inicio, meio);
            mergeSort(contatos, meio + 1, fim);

            merge(contatos, inicio, meio, fim);
        }
    }

    public static void merge(List<Contato> contatos, int inicio, int meio, int fim) {
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        List<Contato> listaEsquerda = new ArrayList<>();
        List<Contato> listaDireita = new ArrayList<>();

        for (int i = 0; i < tamanhoEsquerda; i++) {
            listaEsquerda.add(contatos.get(inicio + i));
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            listaDireita.add(contatos.get(meio + 1 + j));
        }

        int indiceEsquerda = 0, indiceDireita = 0;
        int indiceMerged = inicio;

        while (indiceEsquerda < tamanhoEsquerda && indiceDireita < tamanhoDireita) {
            if (listaEsquerda.get(indiceEsquerda).getNome().compareTo(listaDireita.get(indiceDireita).getNome()) <= 0) {
                contatos.set(indiceMerged, listaEsquerda.get(indiceEsquerda));
                indiceEsquerda++;
            } else {
                contatos.set(indiceMerged, listaDireita.get(indiceDireita));
                indiceDireita++;
            }
            indiceMerged++;
        }

        while (indiceEsquerda < tamanhoEsquerda) {
            contatos.set(indiceMerged, listaEsquerda.get(indiceEsquerda));
            indiceEsquerda++;
            indiceMerged++;
        }

        while (indiceDireita < tamanhoDireita) {
            contatos.set(indiceMerged, listaDireita.get(indiceDireita));
            indiceDireita++;
            indiceMerged++;
        }
    }
}
