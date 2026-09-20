import java.io.Serializable;

/**
 * Classe base da hierarquia de vagoes. Abstrata: nao pode ser instanciada.
 * Atributos comuns aos tres tipos: comprimento e peso.
 * Assinaturas conforme o diagrama de classes do enunciado (secao 3.3).
 */
public abstract class Vagao implements Serializable {
   protected double comprimento; // Comprimento do vagao em metros.
   protected double peso;        // Peso do vagao em toneladas.

   public Vagao(double comprimento, double peso) {
      this.comprimento = comprimento;
      this.peso = peso;
   }

   public double getComprimento() {
      return comprimento;
   }

   public double getPeso() {
      return peso;
   }

   public void imprime() {
      System.out.println("Comprimento: " + comprimento + " m, Peso: " + peso + " toneladas.");
   }
}