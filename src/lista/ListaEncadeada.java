package lista;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;

    public void adiciona(T elemento) {
        No<T> novoNo = new No<T>(elemento);
        if (this.tamanho == 0){
            this.inicio = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo;
        this.tamanho++;
    }

    public void adicionaInicio(T elemento){
        if (this.tamanho == 0){
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
            this.tamanho++;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
            this.tamanho++;
        }
    }

    public void aciciona(int posicao, T elemento){
        if (posicao < 0 || posicao > this.tamanho){
            throw new IllegalArgumentException("Posição inválida.");
        }

        if (posicao == 0){
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho){
            this.adiciona(elemento);
        } else {
            No<T> noAnterior = this.buscaNo(posicao);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void limpa() {

        for (No<T> atual = this.inicio; atual != null;){
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    private No<T> buscaNo(int posicao){

        if (!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição não existe.");
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    public T buscaPorPosicao(int posicao){
        return this.buscaNo(posicao).getElemento();
    }

    public int busca(T elemento){

        No<T> noAtual = this.inicio;
        int pos = 0;

        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                return pos;
            }
            pos++;
            noAtual = noAtual.getProximo();
        }

        return NAO_ENCONTRADO;
    }

    @Override
    public String toString() {

        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(" -> ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        /*
        builder.append(atual.getElemento()).append(" -> ");
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
            builder.append(atual.getElemento()).append(" -> ");
        }
        */

        return builder.toString();
    }
}
