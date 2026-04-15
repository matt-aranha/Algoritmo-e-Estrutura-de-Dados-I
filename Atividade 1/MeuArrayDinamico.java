public class MeuArrayDinamico {
    
    private int[] dados;
    private int tamanho; // quantos elementos realmente existem

    public MeuArrayDinamico(int capacidadeInicial) {
        this.dados = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    /** Dobra a capacidade do array interno. */
    private void resize() {
        // 1a: crie um novo array com o dobro do tamanho
        int[] novo = new int[dados.length * 2];
        
        // 1b: copie cada elemento de dados para o novo array
        for (int i = 0; i < tamanho; i++) {
            novo[i] = dados[i];
        }
        
        // 1c: faca 'dados' apontar para o novo array
        this.dados = novo;
    }

    /** Adiciona 'valor' no final do array. */
    public void add(int valor) {
        // 2a: se tamanho == dados.length, chame resize()
        if (tamanho == dados.length) {
            resize();
        }
        
        // 2b: coloque 'valor' na posicao 'tamanho'
        dados[tamanho] = valor;
        
        // 2c: incremente 'tamanho'
        tamanho++;
    }

    /** Retorna o elemento na posicao 'indice'. */
    public int get(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);
        }
        return dados[indice];
    }

    public int size() {
        return tamanho;
    }

    /** Remove o elemento na posicao 'indice'. */
    public void remove(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);
        }
        
        // 1: desloque cada elemento de (indice+1) ate (tamanho-1) uma posicao para a esquerda
        for (int i = indice; i < tamanho - 1; i++) {
            dados[i] = dados[i + 1];
        }
        
        // 2: decremente 'tamanho'
        tamanho--;
    }

    /** Imprime o array no formato [a, b, c]. */
    public void imprimir() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[i]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    // === Teste ===
    public static void main(String[] args) {
        MeuArrayDinamico arr = new MeuArrayDinamico(2);
        arr.add(10);
        arr.add(20);
        arr.imprimir(); // [10, 20]
        
        arr.add(30); // deve fazer resize aqui!
        arr.add(40);
        arr.imprimir(); // [10, 20, 30, 40]
        System.out.println("Tamanho: " + arr.size()); // 4
        
        arr.remove(1); // remove o 20
        arr.imprimir(); // [10, 30, 40]
        
        arr.remove(0); // remove o 10
        arr.imprimir(); // [30, 40]
        System.out.println("Tamanho: " + arr.size()); // 2
    }
}