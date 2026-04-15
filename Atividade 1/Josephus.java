public class Josephus {
    public static void main(String[] args) {
        int N = 6; // numero de pessoas
        int M = 3; // salto (elimina a cada M contagens)

        // --- Passo 1: Montar a lista circular ---
        Node primeiro = new Node(1);
        Node atual = primeiro;

        for (int i = 2; i <= N; i++) {
            Node novo = new Node(i);
            atual.next = novo;
            atual = novo; // avance atual para novo
        }
        atual.next = primeiro; // fecha o circulo!

        // --- Passo 2: Simular a eliminacao ---
        Node anterior = atual; // o no "antes" do atual (no inicio, eh o ultimo da lista)
        atual = primeiro;

        System.out.println("Ordem de eliminacao:");

        while (atual.next != atual) { // enquanto houver mais de 1
            // avance (anterior, atual) por M-1 posicoes
            for (int i = 0; i < M - 1; i++) {
                anterior = atual;
                atual = atual.next;
            }
            
            // elimine 'atual' fazendo anterior.next = atual.next
            anterior.next = atual.next;
            
            // imprima o eliminado
            System.out.println(atual.item);
            
            // avance atual para anterior.next
            atual = anterior.next;
        }

        System.out.println("\nSobrevivente: " + atual.item);
    }
}