public class ArvoreBinaria implements Arvore {

    private NodoArvore raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(int valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private NodoArvore inserirRecursivo(NodoArvore nodoAtual, int valor) {
        if (nodoAtual == null) {
            return new NodoArvore(valor);
        }

        if (valor < nodoAtual.chave) {
            nodoAtual.filhoEsquerda = inserirRecursivo(nodoAtual.filhoEsquerda, valor);
        } else if (valor > nodoAtual.chave) {
            nodoAtual.filhoDireita = inserirRecursivo(nodoAtual.filhoDireita, valor);
        }
        
        return nodoAtual;
    }

    @Override
    public NodoArvore pesquisa(int valor) {
        return pesquisaRecursivo(this.raiz, valor);
    }

    private NodoArvore pesquisaRecursivo(NodoArvore noAtual, int valor) {
        if (noAtual == null || noAtual.chave == valor) {
            return noAtual;
        }

        if (valor < noAtual.chave) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, valor);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, valor);
        }
    }

    @Override
    public void remover(int valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public void imprime_preFixado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprime_preFixado'");
    }
}
