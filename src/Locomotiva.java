/**
 * Vagao do tipo Locomotiva.
 * Especifico: potencia (2000 a 6000 HP).
 */
public class Locomotiva extends Vagao {
   private double potencia; // Potencia da locomotiva em HP.

   public Locomotiva(double comprimento, double peso, double potencia) {
      super(comprimento, peso);
      // TODO: inicializar a potencia.
   }

   public double getPotencia() {
      // TODO: retornar a potencia.
      return 0;
   }

   @Override
   public void imprime() {
      // TODO: imprimir tipo e potencia, DEPOIS chamar super.imprime().
      // Ordem da saida no exemplo do enunciado: Tipo, Potencia, Comprimento e Peso.
   }
}
