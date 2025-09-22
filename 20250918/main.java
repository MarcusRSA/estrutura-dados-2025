// main.java
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // 1. Criação das 2 árvores
        ArvoreBinaria<Follow> arvorePadrao = new ArvoreBinaria<>();
        ArvoreBinariaAlternativa<Follow> arvoreAlternativa = new ArvoreBinariaAlternativa<>(new FollowComparator());

        // 2. Criação daa lista de objetos Follow
        List<Follow> follows = new ArrayList<>();
        follows.add(new Follow(20L, 50L));
        follows.add(new Follow(10L, 30L));
        follows.add(new Follow(30L, 10L));
        follows.add(new Follow(10L, 20L));
        follows.add(new Follow(25L, 50L));
        follows.add(new Follow(30L, 5L));

        // 3. Inserindo os mesmos objetos nas 2 árvores
        System.out.println("--- Inserindo objetos ---");
        for (Follow follow : follows) {
            System.out.println("Inserindo: " + follow);
            arvorePadrao.inserir(follow);
            arvoreAlternativa.inserir(follow);
        }

        // 4. Exibindo os resultados
        System.out.println("\n\n--- ÁRVORE PADRÃO (Ordenada por followerId, depois followedId) ---");
        arvorePadrao.imprimeEmOrdem();
        arvorePadrao.imprimePreFixado();

        System.out.println("\n\n--- ÁRVORE ALTERNATIVA (Ordenada por followedId, depois followerId) ---");
        arvoreAlternativa.imprimeEmOrdem();
        arvoreAlternativa.imprimePreFixado();
    }
}
