/*
 *
 * a) Custo da inserção no meio.
 * Inserir no meio de um array dinâmico é mais lento (O(n)) porque os arrays alocam
 * memória de forma contígua. Para não sobrescrever dados, precisamos deslocar todos os 
 * elementos à direita uma posição para abrir espaço. Na lista encadeada, a memória é 
 * dispersa; inserir no meio (se já tivermos a referência do nó) custa O(1), pois 
 * envolve apenas a reatribuição de ponteiros (novo.next = x.next; x.next = novo), sem 
 * necessidade de mover outros elementos.
 *
 * b) Custo de acesso por índice.
 * Para acessar o k-ésimo elemento, o array é muito mais rápido (O(1)). Como a memória é 
 * sequencial, o Java calcula o endereço exato do índice instantaneamente 
 * (endereço_base + k * tamanho_tipo). Na lista encadeada, não temos acesso direto; é 
 * necessário começar do 'head' e saltar nó por nó usando a referência 'next' até 
 * chegar em 'k', resultando em um custo de O(n).
 *
 * c) Circularidade e o Problema de Josephus com Array.
 * Seria possível resolver o Problema de Josephus usando um array, calculando o índice 
 * com aritmética modular (ex: indice = (indice + M - 1) % tamanho_atual). No entanto, a 
 * remoção seria menos eficiente. Toda vez que uma pessoa fosse eliminada, teríamos que 
 * deslocar todos os elementos à direita para preencher a lacuna, resultando em O(n) por 
 * eliminação. A lista circular encadeada faz isso de forma bem mais otimizada,
 * excluindo o elemento apenas reatribuindo um ponteiro O(1).
 */