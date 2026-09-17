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
      // TODO: inicializar os dois atributos.
   }

   public double getComprimento() {
      // TODO: retornar o comprimento.
      return 0;
   }

   public double getPeso() {
      // TODO: retornar o peso.
      return 0;
   }

   public void imprime() {
      // TODO: imprimir os atributos COMUNS (comprimento e peso).
      // As filhas chamam este metodo via super.imprime().
   }
}
