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
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Locomotiva) {      // Usa a primeira encontrada como modelo.
            Locomotiva l = (Locomotiva) obj;
            return new Locomotiva(l.getComprimento(), l.getPeso(), l.getPotencia());
         }
      }
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
      int total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Locomotiva)
            total = total + 1;
      }
      return total;
   }

   private int contarVagoesPassageiros() {
      int total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Passageiro)
            total = total + 1;
      }
      return total;
   }

   private int contarVagoesCarga() {
      int total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Carga)
            total = total + 1;
      }
      return total;
   }

   // ---------- Requisito 5: comprimento e peso ----------

   private double calcularComprimentoTotal() {
      double total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         total += ((Vagao) obj).getComprimento();
      }
      if (getSize() >= 2)                   // Espacos so existem entre vagoes.
         total += (getSize() - 1) * 2;
      return total;
   }

   private double calcularPesoTotal() {
      double total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         total += ((Vagao) obj).getPeso();
      }
      return total;
   }

   // ---------- Requisito 6: passageiros e carga ----------

   private int calcularTotalPassageiros() {
      int total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Passageiro)
            total += ((Passageiro) obj).getPassageiros();
      }
      return total;
   }

   private double calcularCargaTotal() {
      double total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Carga)
            total += ((Carga) obj).getCarga();
      }
      return total;
   }

   private double calcularPotenciaTotal() {
      double total = 0;
      rewind();
      for (int i = 0; i < getSize(); i++) {
         Object obj = next();
         if (obj instanceof Locomotiva)
            total += ((Locomotiva) obj).getPotencia();
      }
      return total;
   }

   // ---------- Requisito 7: potencia ----------

   private String verificarPotencia() {
      double peso = calcularPesoTotal();
      double potencia = calcularPotenciaTotal();
      double razao = potencia / peso;
      if (razao >= 1.05)
         return "Potencia suficiente. Relacao: " + razao + " HP/t.";
      double falta = 1.05 * peso - potencia;
      Locomotiva modelo = criarLocomotivaIgual();
      if (modelo == null)
         return "Composicao sem locomotiva.";
      double hpLoco = modelo.getPotencia();
      double pesoLoco = modelo.getPeso();
      double novaPotencia = potencia;
      double novoPeso = peso;
      int qtde = 0;
      while (novaPotencia / novoPeso < 1.05) {   // Nao se sabe quantas de antemao.
         qtde++;
         novaPotencia += hpLoco;
         novoPeso += pesoLoco;
      }
      return "Potencia insuficiente. Relacao: " + razao + " HP/t. Faltam "
           + falta + " HP. Adicionar " + qtde + " locomotiva(s) iguais.";
   }

   // ---------- Requisito 8: diagnostico (2,0 pontos) ----------

   public void diagnostico() {
      System.out.println("=== DIAGNOSTICO DA COMPOSICAO ===");
      System.out.println("Total de vagoes......: " + getSize());
      System.out.println("Locomotivas..........: " + contarLocomotivas());
      System.out.println("Vagoes de passageiros: " + contarVagoesPassageiros());
      System.out.println("Vagoes de carga......: " + contarVagoesCarga());
      System.out.println("Comprimento total....: " + calcularComprimentoTotal() + " m");
      System.out.println("Peso total...........: " + calcularPesoTotal() + " t");
      System.out.println("Passageiros..........: " + calcularTotalPassageiros());
      System.out.println("Carga total..........: " + calcularCargaTotal() + " t");
      System.out.println(verificarPotencia());
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
