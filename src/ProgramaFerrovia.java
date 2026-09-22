import java.util.Scanner;

public class ProgramaFerrovia {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      ComposicaoFerroviaria comp = new ComposicaoFerroviaria(100, "composicao.dat");
      String opcao;

      do {
         System.out.println("a) Criar composicao padrao");
         System.out.println("b) Inserir vagao");
         System.out.println("c) Remover vagao");
         System.out.println("d) Apresentar a descricao da composicao");
         System.out.println("e) Dados do primeiro vagao");
         System.out.println("f) Dados do ultimo vagao");
         System.out.println("g) Terminar");
         System.out.print("Opcao: ");
         opcao = sc.nextLine();

         switch (opcao) {
            case "a":
               comp.criarComposicaoPadrao();
               break;

            case "d":
               comp.diagnostico();
               break;

            case "g":
               System.out.println("Encerrando.");
               break;

            case "e":
               Vagao v = comp.primeiroVagao();
               if (v == null)
                  System.out.println("Composicao vazia.");
               else
                  v.imprime();
               break;

            case "f":
               Vagao u = comp.ultimoVagao();
               if (u == null)
                  System.out.println("Composicao vazia.");
               else
                  u.imprime();
               break;

            case "c":
               System.out.print("Remover do (1) inicio ou (2) final? ");
               String lado = sc.nextLine();
               Vagao r;
               if (lado.equals("1"))
                  r = comp.removerInicio();
               else
                  r = comp.removerFim();
               if (r == null)
                  System.out.println("Nao foi possivel remover.");
               else {
                  System.out.println("Vagao removido:");
                  r.imprime();
               }
               break;

            case "b":
               System.out.print("Inserir no (1) inicio ou (2) final? ");
               String onde = sc.nextLine();
               if (!onde.equals("1") && !onde.equals("2")) {
                  System.out.println("Local invalido.");
                  break;
               }
               System.out.print("Tipo: (1) locomotiva, (2) passageiro, (3) carga: ");
               String tipo = sc.nextLine();
               System.out.print("Comprimento (m): ");
               double c = Double.parseDouble(sc.nextLine());
               System.out.print("Peso (t): ");
               double p = Double.parseDouble(sc.nextLine());
               Vagao novo;
               if (tipo.equals("1")) {
                  System.out.print("Potencia (HP): ");
                  double pot = Double.parseDouble(sc.nextLine());
                  novo = new Locomotiva(c, p, pot);
               } else if (tipo.equals("2")) {
                  System.out.print("Numero de passageiros: ");
                  int pas = Integer.parseInt(sc.nextLine());
                  novo = new Passageiro(c, p, pas);
               } else if (tipo.equals("3")) {
                  novo = new Carga(c, p);
               } else {
                  System.out.println("Tipo invalido.");
                  break;
               }
               if (onde.equals("1"))
                  comp.inserirInicio(novo);
               else
                  comp.inserirFim(novo);
               System.out.println("Vagao inserido.");
               break;
            default:
               System.out.println("Opcao invalida.");
         }
      } while ( !opcao.equals("g"));

      sc.close();
   }
}