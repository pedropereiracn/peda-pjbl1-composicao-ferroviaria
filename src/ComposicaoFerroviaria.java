import java.io.*;

/**
 * Composicao ferroviaria modelada como deque: vagoes entram e saem
 * pelas duas extremidades.
 *
 * Requisito 10: obrigatoriamente derivada da classe Deque da pratica 04J,
 * usando tambem a classe ObjetoPersistente fornecida. Nao alterar o Deque.
 *
 * Assinaturas e visibilidades conforme o diagrama de classes (secao 3.3).
 * Os metodos de contabilizacao sao PRIVADOS de proposito: o requisito 8 diz
 * que eles nao devem ser chamados diretamente pelo programa principal,
 * apenas pelo metodo diagnostico().
 */
public class ComposicaoFerroviaria extends Deque implements Serializable {
   private ObjetoPersistente arqComp; // Arquivo de persistencia da composicao.

   // ---------- Requisito 1: persistencia ----------

   public ComposicaoFerroviaria(int N, String nomeArquivo) {
      super(N);                                   // Chama o construtor de Deque.
      arqComp = new ObjetoPersistente(nomeArquivo);
      carregar();                                 // Carrega o arquivo, se existir.
   }

   private void salvar() {
      // TODO: chamar arqComp.salvar(this).
   }

   private void carregar() {
      // TODO: recuperar o objeto com arqComp.carregar(), fazer o cast para
      // ComposicaoFerroviaria e, se nao for null, redefinir os atributos
      // herdados do Deque: front, rear, ptr, size, N e data.
      //
      // ATENCAO: o enunciado escreve "this.ip = cf.ip", mas a classe Deque
      // da pratica declara o ponteiro de percurso como "ptr". Usar ptr,
      // senao nao compila.
   }

   // ---------- Requisito 2: composicao padrao (2,0 pontos) ----------

   public void criarComposicaoPadrao() {
      // TODO: esvaziar a composicao atual, incluir os vagoes do Anexo
      // (1 locomotiva, 50 de passageiros, 30 de carga) e salvar em arquivo.
   }

   public Locomotiva criarLocomotivaIgual() {
      // TODO: retornar uma locomotiva igual as ja presentes na composicao,
      // para uso no requisito 7.
      return null;
   }

   // ---------- Requisito 3: insercao e remocao ----------

   public void inserirInicio(Vagao v) {
      // TODO: usar addFirst() do Deque e salvar em arquivo depois.
   }

   public void inserirFim(Vagao v) {
      // TODO: usar addLast() do Deque e salvar em arquivo depois.
   }

   public Vagao removerInicio() {
      // TODO: usar deleteFirst() do Deque, salvar e retornar o vagao.
      return null;
   }

   public Vagao removerFim() {
      // TODO: usar deleteLast() do Deque, salvar e retornar o vagao.
      return null;
   }

   // ---------- Requisito 4: contagem de vagoes por tipo ----------

   private int contarLocomotivas() {
      // TODO: percorrer com rewind()/next() e contar instanceof Locomotiva.
      return 0;
   }

   private int contarVagoesPassageiros() {
      // TODO: idem para Passageiro.
      return 0;
   }

   private int contarVagoesCarga() {
      // TODO: idem para Carga.
      return 0;
   }

   // ---------- Requisito 5: comprimento e peso ----------

   private double calcularComprimentoTotal() {
      // TODO: somar o comprimento dos vagoes MAIS os espacos entre eles.
      // ATENCAO: com n vagoes existem (n-1) espacos de 2 m cada.
      return 0;
   }

   private double calcularPesoTotal() {
      // TODO: somar o peso de todos os vagoes.
      return 0;
   }

   // ---------- Requisito 6: passageiros e carga ----------

   private int calcularTotalPassageiros() {
      // TODO: somar getPassageiros() dos vagoes do tipo Passageiro.
      return 0;
   }

   private double calcularCargaTotal() {
      // TODO: somar getCarga() dos vagoes do tipo Carga.
      // O enunciado mostra este metodo pronto na secao 3.4.2.
      return 0;
   }

   // ---------- Requisito 7: potencia ----------

   private String verificarPotencia() {
      // TODO: calcular a relacao potencia/peso da composicao.
      // Minimo aceitavel: HPT = 1.05 HP/Ton.
      // Se for suficiente, informar. Se nao, informar quanta potencia falta
      // e quantas locomotivas IGUAIS as ja incluidas devem ser adicionadas.
      // ATENCAO: cada locomotiva adicionada tambem soma peso a composicao.
      return null;
   }

   // ---------- Requisito 8: diagnostico (2,0 pontos) ----------

   public void diagnostico() {
      // TODO: montar o diagnostico usando os metodos dos requisitos 4 a 7.
      // Este e o UNICO ponto de acesso a eles: o programa principal nao os
      // chama diretamente.
   }

   // ---------- Requisito 9: primeiro e ultimo vagao ----------

   public Vagao primeiroVagao() {
      // TODO: usar peekFront() do Deque.
      return null;
   }

   public Vagao ultimoVagao() {
      // TODO: usar peekRear() do Deque.
      return null;
   }
}
