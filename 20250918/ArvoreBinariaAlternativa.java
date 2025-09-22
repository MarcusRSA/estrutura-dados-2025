import java.util.Comparator;

public class ArvoreBinariaAlternativa<T> {
    NodoArvore<T> raiz;
    private final Comparator<T> comparator;

    public ArvoreBinariaAlternativa(Comparator<T> comparator) {
        this.raiz = null;
        this.comparator = comparator;
    }

    public void inserir(T objeto) {
        this.raiz = inserirRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> inserirRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return new NodoArvore<>(objeto);
        }

        // Utiliza o compare do Comparator para decidir a posição
        if (comparator.compare(objeto, noAtual.objeto) < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (comparator.compare(objeto, noAtual.objeto) > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }
        
        return noAtual; // Retorna o nó
    }

    public void imprimeEmOrdem() {
        System.out.println("Impressão Em Ordem:");
        imprimeEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimeEmOrdemRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.objeto + " ");
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }

    public void imprimePreFixado() {
        System.out.println("Impressão Pré-Fixada:");
        imprimePreFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePreFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            System.out.print(no.objeto + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }
}
