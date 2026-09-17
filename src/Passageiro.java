/**
 * Vagao do tipo Passageiro.
 * Especifico: quantidade de passageiros (ate 50).
 * O peso informado ja inclui os passageiros.
 */
public class Passageiro extends Vagao {
   private int passageiros; // Quantidade de passageiros no vagao.

   public Passageiro(double comprimento, double peso, int passageiros) {
      super(comprimento, peso);
      // TODO: inicializar a quantidade de passageiros.
   }

   public int getPassageiros() {
      // TODO: retornar a quantidade de passageiros.
      return 0;
   }

   @Override
   public void imprime() {
      // TODO: imprimir tipo e passageiros, DEPOIS chamar super.imprime().
   }
}
