/**
 * Vagao do tipo Passageiro.
 * Especifico: quantidade de passageiros (ate 50).
 * O peso informado ja inclui os passageiros.
 */
public class Passageiro extends Vagao {
   private int passageiros; // Quantidade de passageiros no vagao.

   public Passageiro(double comprimento, double peso, int passageiros) {
      super(comprimento, peso);
      this.passageiros = passageiros;
   }

   public int getPassageiros() {
      return passageiros;
   }

   @Override
   public void imprime() {
      System.out.println("Tipo: Passageiro");
      System.out.println("Passageiros: " + passageiros);
      super.imprime();
   }
}