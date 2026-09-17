/**
 * Classe Deque: implementação usando vetor estático circular.
 */
import java.io.Serializable;
class Deque implements Serializable {
   protected int N;          // Guarda o tamanho máximo do deque.
   protected Object[] data;  // Guarda os elementos do deque no vetor circular.
   protected int size;       // Guarda a quantidade atual de elementos.
   protected int front;      // Guarda o índice do início do deque.
   protected int rear;       // Guarda o índice do fim do deque.
   protected int ptr;        // Guarda o ponteiro usado para percorrer o deque.

   public Deque(int N) {
      // Recebe o tamanho máximo do deque e inicializa seus dados.
      this.N = N;           // Copia o tamanho máximo para o atributo da classe.
      data = new Object[N]; // Cria o vetor que armazenará os elementos.
      size = 0;             // Define que o deque começa vazio.
      front = 0;            // Define a posição inicial do início do deque.
      rear = 0;             // Define a posição inicial do fim do deque.
      ptr = 0;              // Define a posição inicial do ponteiro de percurso.
   }

   public boolean isEmpty() {
      // Retorna verdadeiro quando o deque não possui elementos.
      return size == 0;    // Compara o tamanho atual com zero.
   }

   public boolean isFull() {
      // Retorna verdadeiro quando o deque atingiu a capacidade máxima.
      return size == N;    // Compara a quantidade atual com a capacidade máxima.
   }

   public int getSize() {
      // Retorna a quantidade atual de elementos do deque.
      return size;         // Devolve o valor armazenado em size.
   }

   public Object peekFront() {
      // Retorna o primeiro elemento sem removê-lo do deque.
      if (isEmpty())       // Verifica se não existe elemento no deque.
         return null;      // Retorna null quando o deque está vazio.
      return data[front];  // Retorna o elemento localizado no início.
   }

   public Object peekRear() {
      // Retorna o último elemento sem removê-lo do deque.
      if (isEmpty())       // Verifica se não existe elemento no deque.
         return null;      // Retorna null quando o deque está vazio.
      return data[rear];   // Retorna o elemento localizado no fim.
   }

   public String toString() {
      // Monta e retorna uma string com os elementos do deque em ordem.
      if (isEmpty())       // Verifica se o deque não possui elementos.
         return "Deque vazio."; // Retorna mensagem apropriada para deque vazio.
      String lista = "";   // Cria a string que acumulará os elementos.
      rewind();            // Posiciona o ponteiro de percurso no início.
      int strSize = 0;     // Controla quantos elementos já foram copiados.
      while (strSize < size) { // Repete enquanto faltarem elementos a copiar.
         lista += next().toString(); // Concatena o próximo elemento à string.
         strSize++;        // Incrementa a quantidade de elementos copiados.
         if (strSize < size) // Verifica se ainda faltam elementos.
            lista += " ";  // Acrescenta um espaço entre os elementos.
      }
      return lista;        // Retorna a string montada com os elementos.
   }

   public void rewind() {
      // Coloca o ponteiro de percurso no início atual do deque.
      ptr = front;         // Faz o ponteiro passar a apontar para o início.
   }

   public Object next() {
      // Retorna o elemento apontado e avança o ponteiro no vetor circular.
      if (isEmpty())       // Verifica se o deque não possui elementos.
         return null;      // Retorna null quando o deque está vazio.
      Object e = data[ptr]; // Guarda o elemento apontado atualmente.
      ptr++;               // Avança o ponteiro para a próxima posição.
      if (ptr == N)        // Verifica se o ponteiro ultrapassou o vetor.
         ptr = 0;          // Faz o ponteiro circular para a posição zero.
      return e;            // Retorna o elemento que foi guardado.
   }

   public void addFirst(Object e) {
      if (isFull()) {                      // Deque cheio: nao ha espaco.
         System.out.println("Deque cheio: programa encerrado!");
         System.exit(1);
      }
      if (isEmpty()) {                     // Primeiro elemento a entrar.
         front = 0;                        // Inicio e fim apontam para a
         rear = 0;                         // mesma posicao zero.
      } else {
         front--;                          // Recua o inicio uma posicao.
         if (front < 0)                    // Passou do comeco do vetor?
            front = N - 1;                 // Circula para a ultima posicao.
      }
      data[front] = e;                     // Grava na nova posicao de inicio.
      size++;                              // Deque cresceu em um elemento.
   }

   public void addLast(Object e) {
      if (isFull()) {                      // Deque cheio: nao ha espaco.
         System.out.println("Deque cheio: programa encerrado!");
         System.exit(1);
      }
      if (isEmpty()) {                     // Primeiro elemento a entrar.
         front = 0;                        // Inicio e fim apontam para a
         rear = 0;                         // mesma posicao zero.
      } else {
         rear++;                           // Avanca o fim uma posicao.
         if (rear == N)                    // Passou do fim do vetor?
            rear = 0;                      // Circula para a posicao zero.
      }
      data[rear] = e;                      // Grava na nova posicao de fim.
      size++;                              // Deque cresceu em um elemento.
   }

   public Object deleteFirst() {
      if (isEmpty()) {                     // Nao ha o que remover.
         System.out.println("Deque vazio: programa encerrado!");
         System.exit(1);
      }
      Object e = data[front];              // Guarda o elemento do inicio.
      data[front] = null;                  // Libera a posicao no vetor.
      size--;                              // Deque diminuiu em um elemento.
      if (isEmpty()) {                     // Removeu o ultimo que havia?
         front = 0;                        // Volta ao estado inicial.
         rear = 0;
      } else {
         front++;                          // Avanca o inicio uma posicao.
         if (front == N)                   // Passou do fim do vetor?
            front = 0;                     // Circula para a posicao zero.
      }
      return e;                            // Devolve o elemento removido.
   }

   public Object deleteLast() {
      if (isEmpty()) {                     // Nao ha o que remover.
         System.out.println("Deque vazio: programa encerrado!");
         System.exit(1);
      }
      Object e = data[rear];               // Guarda o elemento do fim.
      data[rear] = null;                   // Libera a posicao no vetor.
      size--;                              // Deque diminuiu em um elemento.
      if (isEmpty()) {                     // Removeu o ultimo que havia?
         front = 0;                        // Volta ao estado inicial.
         rear = 0;
      } else {
         rear--;                           // Recua o fim uma posicao.
         if (rear < 0)                     // Passou do comeco do vetor?
            rear = N - 1;                  // Circula para a ultima posicao.
      }
      return e;                            // Devolve o elemento removido.
   }
}