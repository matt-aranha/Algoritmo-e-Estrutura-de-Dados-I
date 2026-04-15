/*
 * a) Custo da inserção no meio:
 * Inserir no meio de um array dinâmico é mais lento (O(n)) porque para não sobrescrever dados, precisamos deslocar todos os 
 * elementos à direita uma posição para abrir espaço. Na lista encadeada inserir no meio (se já tivermos a referência do nó) custa O(1), pois 
 * envolve apenas a reatribuição de ponteiros (novo.next = x.next; x.next = novo), sem 
 * necessidade de mover outros elementos.
 *
 *
 * b) Custo de acesso por índice:
 * Para acessar o k-ésimo elemento, o array é muito mais rápido (O(1)). Como a memória é 
 * sequencial, o Java calcula o endereço exato do índice instantaneamente 
 * (endereço_base + k * tamanho_tipo). Na lista encadeada, não temos acesso direto; é 
 * necessário começar do 'head' e saltar nó por nó usando a referência 'next' até 
 * chegar em 'k', resultando em um custo de O(n).
 *
 *
 * c) Circularidade:
 * Seria sim possível resolver o Problema de Josephus usando um array. Mas teríamos qhe calcular o índice 
 * para fazer a remoção. No entanto, seria menos eficiente. Toda vez que uma pessoa fosse eliminada, teríamos que 
 * deslocar todos os elementos à direita para preencher a lacuna, resultando em O(n) por 
 * eliminação. A lista circular encadeada faz isso de forma bem mais otimizada.
 */
