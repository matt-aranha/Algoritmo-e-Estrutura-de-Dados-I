public class ListaSimples {
    private Node head;

    public ListaSimples() {
        this.head = null;
    }

    /** Insere 'item' no INICIO da lista O(1). */
    public void insertFirst(Object item) {
        // Crie um novo Node cujo 'next' aponta para o head atual
        Node novo = new Node(item, this.head);
        // Atualize head para apontar para o novo Node
        this.head = novo;
    }
    
    /** Retorna a referencia do primeiro no que contem 'item', ou null se nao encontrar. */
    public Node find(Object item) {
        Node atual = head;
        // Percorra a lista comparando atual.item com 'item'
        while (atual != null) {
            if (atual.item.equals(item)) {
                return atual; // Retorne 'atual' quando encontrar
            }
            atual = atual.next;
        }
        return null; // Se chegar ao fim, retorne null
    }

    /** Insere um novo no com 'item' APOS o no 'x'. */
    public void insertAfter(Node x, Object item) {
        if (x == null) return;
        // 1: crie um novo Node com 'item' e 2: faca novo.next = x.next
        Node novo = new Node(item, x.next);
        // 3: faca x.next = novo
        x.next = novo;
    }

    /** Percorre a lista e imprime todos os elementos. */
    public void imprimir() {
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.item + " -> ");
            atual = atual.next;
        }
        System.out.println("null");
    }

    // === Teste ===
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        lista.imprimir(); // A -> B -> C -> null
        
        Node noB = lista.find("B");
        if (noB != null) {
            lista.insertAfter(noB, "B2");
        }
        lista.imprimir(); // A -> B -> B2 -> C -> null
        
        Node noZ = lista.find("Z");
        System.out.println("Busca por Z: " + noZ); // null
    }
}