// import java.util.ArrayList;
// import java.util.Scanner;

// public class CadastroContatos {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         ArrayList<Contato> contatos = new ArrayList<>();
//         int opcao;

//         do {
//             System.out.println("\n========= AGENDA DE CONTATOS =========");
//             System.out.println("1 - Cadastrar contato pessoal");
//             System.out.println("2 - Cadastrar contato profissional");
//             System.out.println("3 - Listar todos os contatos");
//             System.out.println("4 - Pesquisar contato");
//             System.out.println("5 - Alterar contato");
//             System.out.println("6 - Excluir contato");
//             System.out.println("7 - Sair");
//             System.out.print("Escolha uma opção: ");
            
//             opcao = scanner.nextInt();
//             scanner.nextLine(); 

//             switch (opcao) {
//                 case 1:
//                     System.out.println("\n--- CADASTRO DE CONTATO PESSOAL ---");
//                     System.out.print("Nome: ");
//                     String nomeP = scanner.nextLine();
//                     System.out.print("Telefone: ");
//                     String telP = scanner.nextLine();
//                     System.out.print("Parentesco: ");
//                     String parentesco = scanner.nextLine();

//                     contatos.add(new ContatoPessoal(nomeP, telP, parentesco));
//                     System.out.println("Contato pessoal cadastrado com sucesso!");
//                     break;

//                 case 2:
//                     System.out.println("\n--- CADASTRO DE CONTATO PROFISSIONAL ---");
//                     System.out.print("Nome: ");
//                     String nomePr = scanner.nextLine();
//                     System.out.print("Telefone: ");
//                     String telPr = scanner.nextLine();
//                     System.out.print("Empresa: ");
//                     String empresa = scanner.nextLine();
//                     System.out.print("Cargo: ");
//                     String cargo = scanner.nextLine();

//                     contatos.add(new ContatoProfissional(nomePr, telPr, empresa, cargo));
//                     System.out.println("Contato profissional cadastrado com sucesso!");
//                     break;

//                 case 3:
//                     System.out.println("\n--- LISTA DE CONTATOS ---");
//                     if (contatos.isEmpty()) {
//                         System.out.println("Nenhum contato cadastrado.");
//                     } else {
//                         for (int i = 0; i < contatos.size(); i++) {
//                             System.out.println((i + 1) + " - " + contatos.get(i).exibirDados());
//                             System.out.println("------------------------------");
//                         }
//                     }
//                     break;

//                 case 4:
//                     System.out.println("\n--- PESQUISAR CONTATO ---");
//                     if (contatos.isEmpty()) {
//                         System.out.println("Nenhum contato cadastrado.");
//                     } else {
//                         System.out.print("Digite o nome para pesquisar: ");
//                         String busca = scanner.nextLine();
//                         boolean encontrado = false;

//                         for (Contato c : contatos) {
//                             if (c.getNome().equalsIgnoreCase(busca)) {
//                                 System.out.println("\nContato encontrado!");
//                                 System.out.println(c.exibirDados());
//                                 encontrado = true;
//                             }
//                         }

//                         if (!encontrado) {
//                             System.out.println("Contato não encontrado!");
//                         }
//                     }
//                     break;

//                 case 5:
//                     System.out.println("\n--- ALTERAR CONTATO ---");
//                     if (contatos.isEmpty()) {
//                         System.out.println("Nenhum contato cadastrado.");
//                     } else {
//                         for (int i = 0; i < contatos.size(); i++) {
//                             System.out.println((i + 1) + " - " + contatos.get(i).getNome());
//                         }

//                         System.out.print("\nInforme o número do contato que deseja alterar: ");
//                         int indiceAlterar = scanner.nextInt() - 1;
//                         scanner.nextLine();

//                         if (indiceAlterar >= 0 && indiceAlterar < contatos.size()) {
//                             Contato contato = contatos.get(indiceAlterar);
//                             System.out.print("Novo Nome (" + contato.getNome() + "): ");
//                             String novoNome = scanner.nextLine();
//                             System.out.print("Novo Telefone (" + contato.getNumero() + "): ");
//                             String novoTel = scanner.nextLine();

//                             contato.setNome(novoNome);
//                             contato.setNumero(novoTel);
//                             System.out.println("Contato alterado com sucesso!");
//                         } else {
//                             System.out.println("Contato inválido!");
//                         }
//                     }
//                     break;

//                 case 6:
//                     System.out.println("\n--- EXCLUIR CONTATO ---");
//                     if (contatos.isEmpty()) {
//                         System.out.println("Nenhum contato cadastrado.");
//                     } else {
//                         for (int i = 0; i < contatos.size(); i++) {
//                             System.out.println((i + 1) + " - " + contatos.get(i).getNome());
//                         }

//                         System.out.print("\nInforme o número do contato que deseja excluir: ");
//                         int indiceExcluir = scanner.nextInt() - 1;
//                         scanner.nextLine();

//                         if (indiceExcluir >= 0 && indiceExcluir < contatos.size()) {
//                             contatos.remove(indiceExcluir);
//                             System.out.println("Contato excluído com sucesso!");
//                         } else {
//                             System.out.println("Contato inválido!");
//                         }
//                     }
//                     break;

//                 case 7:
//                     System.out.println("Encerrando a agenda. Até logo!");
//                     break;

//                 default:
//                     System.out.println("Opção inválida! Tente novamente.");
//             }
//         } while (opcao != 7);

//         scanner.close();
//     }
// }