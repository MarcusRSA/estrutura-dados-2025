/**
 * Implementação de uma Árvore Binária de Busca.
 * Foco em operações recursivas para inserção, busca e remoção.
 * @author Equipe da Disciplina
 * @version 2025.09.02
 */
public class ArvoreBinaria<T extends Comparable<T>> implements Arvore<T> {
    NodoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(T objeto) {
        this.raiz = inserirRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> inserirRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return new NodoArvore<>(objeto);
        }

        if (objeto.compareTo(noAtual.objeto) < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (objeto.compareTo(noAtual.objeto) > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }
        
        return noAtual;
    }
    
    @Override
    public NodoArvore<T> pesquisa(T objeto) {
        return pesquisaRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> pesquisaRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null || noAtual.objeto.equals(objeto)) {
            return noAtual;
        }

        if (objeto.compareTo(noAtual.objeto) < 0) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, objeto);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, objeto);
        }
    }
    
    @Override
    public void remover(T objeto) {
        raiz = removerRecursivo(raiz, objeto);
    }

    private NodoArvore<T> removerRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return null;
        }

        if (objeto.compareTo(noAtual.objeto) < 0) {
            noAtual.filhoEsquerda = removerRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (objeto.compareTo(noAtual.objeto) > 0) {
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, objeto);
        } else {
            // Nó com apenas um filho ou nenhum filho
            if (noAtual.filhoEsquerda == null) {
                return noAtual.filhoDireita;
            } else if (noAtual.filhoDireita == null) {
                return noAtual.filhoEsquerda;
            }

            // Nó com dois filhos: Pega o sucessor (menor na subárvore direita)
            noAtual.objeto = valorMinimo(noAtual.filhoDireita);

            // Remove o sucessor
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, noAtual.objeto);
        }

        return noAtual;
    }

    private T valorMinimo(NodoArvore<T> no) {
        T minv = no.objeto;
        while (no.filhoEsquerda != null) {
            minv = no.filhoEsquerda.objeto;
            no = no.filhoEsquerda;
        }
        return minv;
    }

    @Override
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
}
