import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          // cria GaragemVagao com 3 vagoes
          GaragemVagoes garagemVagao = new GaragemVagoes();
          Vagao vagao1 = new Vagao(1, 100.0);
          Vagao vagao2 = new Vagao(2, 200.0);
          Vagao vagao3 = new Vagao(3, 300.0);
          garagemVagao.engatarVagao(vagao1);
          garagemVagao.engatarVagao(vagao2);
          garagemVagao.engatarVagao(vagao3);

          GaragemLocomotiva garagemLocomotiva = new GaragemLocomotiva();
          Locomotiva locomotiva1 = new Locomotiva(1, 10);
          Locomotiva locomotiva2 = new Locomotiva(2, 20);
          Locomotiva locomotiva3 = new Locomotiva(3, 30);
          Locomotiva locomotiva4 = new Locomotiva(4, 40);
          garagemLocomotiva.engatarLocomotiva(locomotiva1);
          garagemLocomotiva.engatarLocomotiva(locomotiva2);
          garagemLocomotiva.engatarLocomotiva(locomotiva3);
          garagemLocomotiva.engatarLocomotiva(locomotiva4);

          // cria composicao com as locomotivas e vagoes
          Composicao c = new Composicao(1);
          c.engataLocomotiva(locomotiva1);
          c.engataLocomotiva(locomotiva2);
          c.engataVagao(vagao1);
          c.engataVagao(vagao2);
          c.engataVagao(vagao3);

          PatioComposicao patioComposicoes = new PatioComposicao();
          patioComposicoes.engatarComposicao(c);

          int opcao = 0;
          do {
               System.out.println("Escolha uma opção:");
               System.out.println("1 - Criar um trem");
               System.out.println("2 - Editar um trem");
               System.out.println("3 - Listar todos os trens já criados");
               System.out.println("4 - Desfazer um trem");
               System.out.println("5 - Fim");
               System.out.print("Opção escolhida: ");
               opcao = scanner.nextInt();
               scanner.nextLine(); // limpar o buffer do scanner

               switch (opcao) {
                    case 1:
                         System.out.print("Digite o identificador do trem: ");
                         int idTrem = scanner.nextInt();
                         scanner.nextLine(); // limpar o buffer do scanner

                         System.out.print("Digite o identificador da primeira locomotiva: ");
                         int idLocomotiva = scanner.nextInt();
                         scanner.nextLine(); // limpar o buffer do scanner

                         Composicao trem = new Composicao(idTrem);
                         Locomotiva primeiraLocomotiva = new Locomotiva(idLocomotiva, 10);
                         trem.engataLocomotiva(primeiraLocomotiva);
                         patioComposicoes.engatarComposicao(trem);
                         break;

                    case 2:
                         System.out.print("Digite o identificador do trem a ser editado: ");
                         int idTremEditar = scanner.nextInt();
                         scanner.nextLine(); // limpar o buffer do scanner

                         Composicao editar = patioComposicoes.buscaComposicao(idTremEditar);
                         if (editar == null) {
                              System.out.println("Trem não encontrado.");
                              break;
                         }

                         int opcaoEditar = 0;
                         do {
                              System.out.println("Escolha uma opção:");
                              System.out.println("1 - Inserir uma locomotiva");
                              System.out.println("2 - Inserir um vagão");
                              System.out.println("3 - Remover o último elemento do trem");
                              System.out.println("4 - Listar locomotivas livres");
                              System.out.println("5 - Listar vagões livres");
                              System.out.println("6 - Encerrar a edição do trem");
                              System.out.print("Opção escolhida: ");
                              opcaoEditar = scanner.nextInt();
                              scanner.nextLine();

                              switch (opcaoEditar) {
                                   case 1:
                                        System.out.print("Digite o identificador da locomotiva: ");
                                        int idLocomotivaInserir = scanner.nextInt();
                                        scanner.nextLine(); // limpar o buffer do scanner

                                        Locomotiva locomotivaInserir = garagemLocomotiva
                                                  .buscaLocomotiva(idLocomotivaInserir);
                                        if (locomotivaInserir == null) {
                                             System.out.println("Locomotiva não encontrada.");
                                        } else if (editar.engataLocomotiva(locomotivaInserir)) {
                                             System.out.println("Locomotiva inserida.");
                                        } else {
                                             System.out.println("Não foi possível inserir a locomotiva.");
                                        }
                                        break;

                                   case 2:
                                        System.out.print("Digite o identificador do vagão: ");
                                        int idVagaoInserir = scanner.nextInt();
                                        scanner.nextLine(); // limpar o buffer do scanner

                                        Vagao vagaoInserir = garagemVagao.buscaVagao(idVagaoInserir);
                                        if (vagaoInserir == null) {
                                             System.out.println("Vagão não encontrado.");
                                        } else if (editar.engataVagao(vagaoInserir)) {
                                             System.out.println("Vagão inserido.");
                                        } else {
                                             System.out.println("Não foi possível inserir o vagão.");
                                        }
                                        break;

                                   case 3:
                                        if (editar.removeUltimoElemento()) {
                                             System.out.println("Último elemento removido.");
                                        } else {
                                             System.out.println("Não foi possível remover o último elemento.");
                                        }
                                        break;

                                   case 4:
                                        System.out.println("Locomotivas livres:");
                                        garagemLocomotiva.listar();
                                        break;

                                   case 5:
                                        System.out.println("Vagões livres:");
                                        garagemVagao.listar();
                                        break;

                                   case 6:
                                        System.out.println("Edição da composicao encerrada.");
                                        break;

                                   default:
                                        System.out.println("Opção inválida.");
                                        break;
                              }

                         } while (opcaoEditar != 6);
                         break;

                    case 3:
                         System.out.println("Composicao já criada:");
                         patioComposicoes.listar();
                         break;

                    case 4:
                         System.out.print("Digite o identificador da composicao: ");
                         int idTremDesfazer = scanner.nextInt();
                         scanner.nextLine(); // limpar o buffer do scanner

                         Composicao tremDesfazer = patioComposicoes.getComposicao(idTremDesfazer);
                         if (tremDesfazer == null) {
                              System.out.println("Composicao não encontrado.");
                              break;
                         }

                         patioComposicoes.desengatarComposicao(idTremDesfazer);
                         System.out.println("Composicao desengatada com sucesso.");
                         break;

                    case 5:
                         System.out.println("Programa encerrado.");
                         break;

                    default:
                         System.out.println("Opção inválida.");
                         break;
               }

          } while (opcao != 5);

          scanner.close();
     }
}
