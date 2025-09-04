import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ArvoreBinaria<Follow> arvore = new ArvoreBinaria<>();
        List<Follow> follows = new ArrayList<>();

        // Cria 10 objetos Follow com IDs aleatórios
        for (int i = 0; i < 10; i++) {
            long followerId = (long) (Math.random() * 100);
            long followedId = (long) (Math.random() * 100);
            follows.add(new Follow(followerId, followedId));
        }

        // Embaralha a lista para inserção em ordem aleatória
        Collections.shuffle(follows);

        System.out.println("Inserindo 10 objetos Follow na árvore...");
        for (Follow follow : follows) {
            System.out.println("Inserindo: " + follow);
            arvore.inserir(follow);
        }

        System.out.println("\n--- Árvore Após Inserções ---");
        arvore.imprimeEmOrdem();
        arvore.imprimePreFixado();

        // Seleciona um objeto para remover (o primeiro da lista original)
        Follow followParaRemover = follows.get(0);
        System.out.println("\nRemovendo o objeto: " + followParaRemover);
        arvore.remover(followParaRemover);

        System.out.println("\n--- Árvore Após Remoção ---");
        arvore.imprimeEmOrdem();
        arvore.imprimePreFixado();
    }
}
