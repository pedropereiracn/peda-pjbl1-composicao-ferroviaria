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
      this.carga = peso * 0.75;
   }

   public double getCarga() {
      return carga;
   }

   @Override
   public void imprime() {
      System.out.println("Tipo: Carga");
      System.out.println("Carga transportada: " + carga + " toneladas");
      super.imprime();
   }
}