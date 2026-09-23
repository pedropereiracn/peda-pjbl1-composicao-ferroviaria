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
      arqComp.salvar(this);
   }

   private void carregar() {
      ComposicaoFerroviaria cf = (ComposicaoFerroviaria) arqComp.carregar();
      if (cf != null) {
         this.front = cf.front;
         this.rear = cf.rear;
         this.ptr = cf.ptr;                // ptr, nao ip: e o nome no Deque da pratica.
         this.size = cf.size;
         this.N = cf.N;
         this.data = cf.data;
      }
   }

   // ---------- Requisito 2: composicao padrao ----------

   public void criarComposicaoPadrao() {
      // remove todos os vagoes da composicao anterior
      while (!isEmpty())
         deleteLast();
      addLast(new Locomotiva(20, 150, 2500)); // adiciona a locomotiva como primeiro vagao
      // adiciona 50 vagoes de passageiros depois da locomotiva
      for (int i = 0; i < 50; i++) {
         addLast(new Passageiro(24, 40, 30));
      }
      // adiciona 30 vagoes de carga no final da composicao
      for (int i = 0; i < 30; i++) {
         addLast(new Carga(17, 20));
      }
      // grava a composicao padrao no arquivo
      salvar();
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
      addFirst(v);
      salvar();                  // Req. 3: atualiza o arquivo a cada operacao.
   }

   public void inserirFim(Vagao v) {
      addLast(v);
      salvar();
   }

   public Vagao removerInicio() {
      if (isEmpty())             // Evita o System.exit do Deque vazio.
         return null;
      Vagao v = (Vagao) deleteFirst();
      salvar();
      return v;
   }

   public Vagao removerFim() {
      if (isEmpty())
         return null;
      Vagao v = (Vagao) deleteLast();
      salvar();
      return v;
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

   // ---------- Requisito 8: diagnostico ----------

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
      return (Vagao) peekFront();
   }

   public Vagao ultimoVagao() {
      return (Vagao) peekRear();
   }
}
