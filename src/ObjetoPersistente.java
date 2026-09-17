import java.io.*; // Importa classes para entrada/saída e serialização.
// Define a classe de persistência simples.
// Se um objeto desta classe for atributo de uma classe a ser persistida,
// convém que ObjetoPersistente também seja serializável.
public class ObjetoPersistente implements Serializable { 
   private String nomeArquivo; // Armazena o nome do arquivo de persistência.
   public ObjetoPersistente(String nomeArquivo) { // Construtor da classe.
      this.nomeArquivo = nomeArquivo; // Inicializa o nome do arquivo.
   }
   public String getCaminhoAbsoluto() { // Retorna o caminho completo do arquivo.
      File arq = new File(nomeArquivo); // Cria objeto File com o nome informado.
      return arq.getAbsolutePath(); // Retorna o caminho absoluto do arquivo.
   }
   public boolean existeArquivo() { // Verifica se o arquivo existe.
      File arq = new File(nomeArquivo); // Cria objeto File para o arquivo.
      return arq.exists() && arq.isFile(); // Retorna true se existe e é arquivo.
   }
   public boolean salvar(Object obj) { // Salva o objeto no arquivo.
      try (ObjectOutputStream out = // Cria fluxo de saída para objetos.
            new ObjectOutputStream( // Instancia fluxo de escrita.
               new FileOutputStream(nomeArquivo))) { // Abre arquivo para escrita.
         out.writeObject(obj); // Serializa e grava o objeto no arquivo.
         out.flush(); // Força a gravação de dados pendentes no fluxo.
         System.out.println("Dados salvos no arquivo: " + nomeArquivo + ".");
                               // Informa sucesso na operação de salvamento.
         return true; // Retorna verdadeiro indicando sucesso.
      } catch (Exception e) { // Captura qualquer exceção ocorrida.
         System.out.println("Erro ao salvar no arquivo: " + nomeArquivo + ".");
                               // Informa falha na operação de salvamento.
         System.out.println("Motivo: " + // Exibe tipo e mensagem da exceção.
            e.getClass().getSimpleName() + " - " + e.getMessage());
         return false; // Retorna falso indicando falha.
      }
   }
   public Object carregar() { // Carrega e retorna objeto do arquivo.
      if (!existeArquivo()) { // Verifica se o arquivo não existe.
         System.out.println("Arquivo inexistente: " + nomeArquivo + ".");
                               // Informa que o arquivo não foi encontrado.
         System.out.println("Caminho esperado: " + getCaminhoAbsoluto());
                               // Mostra onde o arquivo deveria estar.
         return null; // Retorna null indicando ausência de dados.
      }
      try (ObjectInputStream in = // Cria fluxo de entrada para objetos.
            new ObjectInputStream( // Instancia fluxo de leitura.
               new FileInputStream(nomeArquivo))) { // Abre arquivo para leitura.
         Object obj = in.readObject(); // Desserializa o objeto do arquivo.
         System.out.println("Dados carregados do arquivo: " + nomeArquivo + ".");
                               // Informa sucesso na operação de leitura.
         return obj; // Retorna o objeto carregado.
      } catch (Exception e) { // Captura qualquer exceção ocorrida.
         System.out.println("Erro ao carregar o arquivo: " + nomeArquivo + ".");
                               // Informa falha na operação de leitura.
         System.out.println("Motivo: " + // Exibe tipo e mensagem da exceção.
            e.getClass().getSimpleName() + " - " + e.getMessage());
         return null; // Retorna null indicando falha.
      }
   }
}