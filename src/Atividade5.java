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


    public void remove(int info) {
        if (cabeca == null) {
            return;
        }
        if (cabeca.info == info) {
            cabeca = cabeca.prox;
        } else {
            No atual = cabeca;
            while (atual.prox != null && atual.prox.info != info) {
                atual = atual.prox;
            }
            if (atual.prox != null) {
                atual.prox = atual.prox.prox;
            }
        }
        tamanho--;
    }


    public boolean search(int info) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.info == info) {
                return true;
            }
            atual = atual.prox;
        }
        return false;
    }


    public double media() {
        if (isEmpty()) {
            return 0;
        }
        No atual = cabeca;
        int soma = 0;
        while (atual != null) {
            soma += atual.info;
            atual = atual.prox;
        }
        return (double) soma / tamanho;
    }


    public void elimina(int info) {
        while (cabeca != null && cabeca.info == info) {
            cabeca = cabeca.prox;
            tamanho--;
        }
        No atual = cabeca;
        while (atual != null && atual.prox != null) {
            if (atual.prox.info == info) {
                atual.prox = atual.prox.prox;
                tamanho--;
            } else {
                atual = atual.prox;
            }
        }
    }


    public void elimina(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            cabeca = cabeca.prox;
        } else {
            No atual = cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.prox;
            }
            atual.prox = atual.prox.prox;
        }
        tamanho--;
    }


    public void insereDireita(int posicao, int info) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        No novoNo = new No(info);
        No atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.prox;
        }
        novoNo.prox = atual.prox;
        atual.prox = novoNo;
        tamanho++;
    }

    // Insere um valor à esquerda do enésimo elemento
    public void insereEsquerda(int posicao, int info) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        No novoNo = new No(info);
        if (posicao == 0) {
            novoNo.prox = cabeca;
            cabeca = novoNo;
        } else {
            No atual = cabeca;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.prox;
            }
            novoNo.prox = atual.prox;
            atual.prox = novoNo;
        }
        tamanho++;
    }

    // Verifica se duas listas são iguais
    public boolean iguais(Lista outra) {
        if (this.size() != outra.size()) {
            return false;
        }
        No atual1 = this.cabeca;
        No atual2 = outra.cabeca;
        while (atual1 != null) {
            if (atual1.info != atual2.info) {
                return false;
            }
            atual1 = atual1.prox;
            atual2 = atual2.prox;
        }
        return true;
    }

    // Método auxiliar para imprimir a lista (opcional, para fins de teste)
    public void printList() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.info + " ");
            atual = atual.prox;
        }
        System.out.println();
    }

    // Método principal para testar a implementação
    public static void main(String[] args) {
        Lista lista = new Lista();

        // Inserindo elementos na lista
        lista.insert(5);
        lista.insert(1);
        lista.insert(3);
        lista.insert(2);
        lista.insert(4);

        // Imprimindo a lista
        System.out.print("Lista: ");
        lista.printList();

        // Verificando se a lista é vazia
        System.out.println("A lista está vazia? " + lista.isEmpty());

        // Tamanho da lista
        System.out.println("Tamanho da lista: " + lista.size());

        // Buscando um elemento na lista
        int elemento = 3;
        System.out.println("O elemento " + elemento + " está na lista? " + lista.search(elemento));

        // Calculando a média dos elementos da lista
        System.out.println("Média dos elementos: " + lista.media());

        // Removendo um elemento da lista
        lista.remove(3);
        System.out.print("Lista após remover o elemento 3: ");
        lista.printList();

        // Eliminando todas as ocorrências de um elemento
        lista.elimina(2);
        System.out.print("Lista após eliminar todas as ocorrências do elemento 2: ");
        lista.printList();

        // Inserindo elementos na lista
        lista.insert(6);
        lista.insert(7);

        // Eliminando um elemento em uma posição específica
        lista.elimina(2);
        System.out.print("Lista após eliminar o elemento na posição 2: ");
        lista.printList();

        // Inserindo um elemento à direita de uma posição específica
        lista.insereDireita(1, 8);
        System.out.print("Lista após inserir o elemento 8 à direita da posição 1: ");
        lista.printList();

        // Inserindo um elemento à esquerda de uma posição específica
        lista.insereEsquerda(1, 9);
        System.out.print("Lista após inserir o elemento 9 à esquerda da posição 1: ");
        lista.printList();
    }
}
