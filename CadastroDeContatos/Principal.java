import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Joao", "123456789", "joao@email.com"));
        contatos.add(new Contato("Maria", "987654321", "maria@email.com"));
        contatos.add(new Contato("Daniel", "456987123", "daniel@email.com"));
        contatos.add(new Contato("Alex", "123654987", "alex@email.com"));

        MergeSort.mergeSort(contatos, 0, contatos.size() - 1);

        System.out.println("Array de contatos ordenado:");
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome() +
                    ", Telefone: " + contato.getTelefone() +
                    ", Email: " + contato.getEmail());
        }

        ArvoreBusca arvoreContatos = new ArvoreBusca();
        for (Contato contato : contatos) {
            arvoreContatos.inserir(contato);
        }

        System.out.println("Buscando contato!");
        Contato contatoPesquisado = arvoreContatos.buscar("Daniel");

        if (contatoPesquisado != null) {
            System.out.println("Contato encontrado: " + contatoPesquisado.getNome() +
                    ", Telefone: " + contatoPesquisado.getTelefone() +
                    ", Email: " + contatoPesquisado.getEmail());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}