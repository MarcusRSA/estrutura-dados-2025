public class ArvoreBinaria<T extends Comparable<T>> {
    NodoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T objeto) {
        this.raiz = inserirRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> inserirRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return new NodoArvore<>(objeto);
        }

        // Utiliza o compareTo do objeto para decidir a posição
        if (objeto.compareTo(noAtual.objeto) < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (objeto.compareTo(noAtual.objeto) > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }
        
        return noAtual; // Retorna o nó (sem alterações se o objeto já existir)
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
