package lista;

public class Teste {

    public static void main(String[] args) {
        //testesIniciais();
        //adicionaInicio();
        //adicionaPosicao();
        removeInicio();
    }

    public static void removeInicio(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        //lista.removeInicio();

        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);

        System.out.println("Elemento removido: " + lista.removeInicio());
        System.out.println("Lista: " + lista);
    }

    public static void adicionaPosicao(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        //lista.aciciona(-1, 1);
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(4);

        //lista.aciciona(5, 0);
        lista.aciciona(0, 0);
        lista.aciciona(4, 5);
        lista.aciciona(2, 3);
        System.out.println(lista);

    }

    public static void adicionaInicio(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionaInicio(3);
        lista.adicionaInicio(2);
        lista.adicionaInicio(1);

        System.out.println(lista);
    }

    public static void testesIniciais(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adiciona(2);
        System.out.println(lista);

        lista.adiciona(3);
        System.out.println(lista);

        /*lista.limpa();
        System.out.println(lista);
        */
        System.out.println("*********************************");
        System.out.println(lista.busca(1));
        System.out.println(lista.busca(2));
        System.out.println(lista.busca(3));
        System.out.println(lista.busca(0));

        System.out.println("*********************************");
        System.out.println(lista.buscaPorPosicao(0));
        System.out.println(lista.buscaPorPosicao(1));
        System.out.println(lista.buscaPorPosicao(2));
        //System.out.println(lista.buscaPorPosicao(-1));
        //System.out.println(lista.buscaPorPosicao(4));
    }
}
