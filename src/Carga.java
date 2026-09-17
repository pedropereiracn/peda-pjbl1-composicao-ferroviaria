/**
 * Vagao do tipo Carga.
 * Especifico: carga transportada.
 * ATENCAO: o construtor NAO recebe a carga (ver diagrama de classes).
 * O peso informado e o peso TOTAL (vagao + carga), e a carga corresponde
 * a 75% desse peso total, conforme o enunciado e o Anexo.
 */
public class Carga extends Vagao {
   private double carga; // Carga transportada em toneladas.

   public Carga(double comprimento, double peso) {
      super(comprimento, peso);
      // TODO: calcular a carga como 75% do peso total.
   }

   public double getCarga() {
      // TODO: retornar a carga.
      return 0;
   }

   @Override
   public void imprime() {
      // TODO: imprimir tipo e carga, DEPOIS chamar super.imprime().
   }
}
