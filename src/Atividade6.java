import java.util.HashSet;
import java.util.Random;

class No {
    int info;
    No prox;

    No(int info) {
        this.info = info;
        this.prox = null;
    }
}

class Lista {
    private No cabeca;
    private int tamanho;

    public Lista() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {
        return cabeca == null;
    }

    public int size() {
        return tamanho;
    }

    public void insert(int info) {
        No novoNo = new No(info);
        if (cabeca == null || cabeca.info > info) {
            novoNo.prox = cabeca;
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            while (atual.prox != null && atual.prox.info < info) {
                atual = atual.prox;
            }
            novoNo.prox = atual.prox;
            atual.prox = novoNo;
        }
        tamanho++;
    }

    public void printList() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.prox;
        }
        System.out.println();
    }

    public static Lista inverter(Lista lista) {
        Lista invertida = new Lista();
        No atual = lista.cabeca;
        while (atual != null) {
            No novoNo = new No(atual.info);
            novoNo.prox = invertida.cabeca;
            invertida.cabeca = novoNo;
            atual = atual.prox;
        }
        invertida.tamanho = lista.tamanho;
        return invertida;
    }

    public static Lista retornarImpares(Lista l1, Lista l2) {
        Lista impares = new Lista();
        No atual = l1.cabeca;
        while (atual != null) {
            if (atual.info % 2 != 0) {
                impares.insert(atual.info);
            }
            atual = atual.prox;
        }
        atual = l2.cabeca;
        while (atual != null) {
            if (atual.info % 2 != 0) {
                impares.insert(atual.info);
            }
            atual = atual.prox;
        }
        return impares;
    }

    public static Lista concatenar(Lista l1, Lista l2) {
        Lista concatenada = new Lista();
        No atual = l1.cabeca;
        while (atual != null) {
            concatenada.insert(atual.info);
            atual = atual.prox;
        }
        atual = l2.cabeca;
        while (atual != null) {
            concatenada.insert(atual.info);
            atual = atual.prox;
        }
        return concatenada;
    }

    public static Lista intersecao(Lista l1, Lista l2) {
        Lista intersecao = new Lista();
        HashSet<Integer> elementos = new HashSet<>();
        No atual = l1.cabeca;
        while (atual != null) {
            elementos.add(atual.info);
            atual = atual.prox;
        }
        atual = l2.cabeca;
        while (atual != null) {
            if (elementos.contains(atual.info)) {
                intersecao.insert(atual.info);
            }
            atual = atual.prox;
        }
        return intersecao;
    }

    public static Lista intercalar1(Lista l1, Lista l2) {
        Lista intercalada = new Lista();
        No atual1 = l1.cabeca;
        No atual2 = l2.cabeca;
        while (atual1 != null && atual2 != null) {
            intercalada.insert(atual1.info);
            intercalada.insert(atual2.info);
            atual1 = atual1.prox;
            atual2 = atual2.prox;
        }
        while (atual1 != null) {
            intercalada.insert(atual1.info);
            atual1 = atual1.prox;
        }
        while (atual2 != null) {
            intercalada.insert(atual2.info);
            atual2 = atual2.prox;
        }
        return intercalada;
    }

    public static Lista intercalar2Ordenadamente(Lista l1, Lista l2) {
        Lista intercalada = new Lista();
        No atual1 = l1.cabeca;
        No atual2 = l2.cabeca;
        while (atual1 != null && atual2 != null) {
            if (atual1.info < atual2.info) {
                intercalada.insert(atual1.info);
                atual1 = atual1.prox;
            } else {
                intercalada.insert(atual2.info);
                atual2 = atual2.prox;
            }
        }
        while (atual1 != null) {
            intercalada.insert(atual1.info);
            atual1 = atual1.prox;
        }
        while (atual2 != null) {
            intercalada.insert(atual2.info);
            atual2 = atual2.prox;
        }
        return intercalada;
    }
}

public class Atividade6 {
    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            l1.insert(random.nextInt(201) - 100);
            l2.insert(random.nextInt(201) - 100);
        }

        System.out.print("Lista L1: ");
        l1.printList();
        System.out.print("Lista L2: ");
        l2.printList();

        Lista invertida = Lista.inverter(l1);
        System.out.print("Lista L1 invertida: ");
        invertida.printList();

        Lista impares = Lista.retornarImpares(l1, l2);
        System.out.print("Elementos ímpares de L1 e L2: ");
        impares.printList();

        Lista concatenada = Lista.concatenar(l1, l2);
        System.out.print("Lista concatenada L1 e L2: ");
        concatenada.printList();

        Lista intersecao = Lista.intersecao(l1, l2);
        System.out.print("Intersecção de L1 e L2: ");
        intersecao.printList();

        Lista intercalada1 = Lista.intercalar1(l1, l2);
        System.out.print("Intercalada L1 e L2 (ordem original): ");
        intercalada1.printList();

        Lista intercalada2 = Lista.intercalar2Ordenadamente(l1, l2);
        System.out.print("Intercalada L1 e L2 (ordenada): ");
        intercalada2.printList();
    }
}
