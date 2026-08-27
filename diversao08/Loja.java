package diversao08;

import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] produtos = new String[5];
        int[] quantidades = new int[5];
        int qtd = 0;
        int op = 0;

        do{
            System.out.println("\n======CONTROLE DE PRODUTOS======");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - LISTAR PRODUTO");
            System.out.println("3 - PESQUISAR PRODUTO");
            System.out.println("4 - ALTERAR PRODUTO");
            System.out.println("5 - REMOVER PRODUTO");
            System.out.println("0 - SAIR");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("=== CADASTRAR PRODUTO ===");
                    if (qtd < produtos.length) {
                        System.out.print("Digite o nome do produto: ");
                        produtos[qtd] = sc.nextLine();

                        System.out.print("Digite a quantidade em estoque: ");
                        quantidades[qtd] = sc.nextInt();
                        sc.nextLine();

                        qtd++;
                        System.out.println("Produto cadastrado!");
                    } else {
                        System.out.println("Limite de produtos atingido!");
                    }
                    break;
                case 2:
                    System.out.println("\n LISTA ATUAL");
                    listar(produtos, quantidades, qtd);
                    break;
                case 3:
                    System.out.println("=== PESQUISAR PRODUTO ===");
                    System.out.print("Digite o nome do produto para buscar: ");
                    String nomeBusca = sc.nextLine();
                    int posBusca = -1;

                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(nomeBusca)) {
                            posBusca = i;
                            break;
                        }
                    }

                    if (posBusca != -1) {
                        System.out.println("Encontrado no Índice " + posBusca + " -> Nome: " + produtos[posBusca] + " | Qtd: " + quantidades[posBusca]);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("=== ALTERAR PRODUTO ===");
                    System.out.print("Digite a posição para alterar: ");
                    int posAlterar = sc.nextInt();
                    sc.nextLine();

                    if (posAlterar >= 0 && posAlterar < qtd) {
                        System.out.print("Digite o novo nome: ");
                        produtos[posAlterar] = sc.nextLine();

                        System.out.print("Digite a nova quantidade: ");
                        quantidades[posAlterar] = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Posição inválida!!");
                    }

                    System.out.println("LISTA ATUALIZADA: ");
                    listar(produtos, quantidades, qtd);
                    break;
                case 5:
                    System.out.println("=== REMOVER PRODUTO ===");
                    System.out.println("Digite a posição para remover: ");
                    int posRemover = sc.nextInt();

                    if (posRemover >= 0 && posRemover < qtd) {
                        for (int i = posRemover; i < qtd - 1; i++) {
                            produtos[i] = produtos[i + 1];
                            quantidades[i] = quantidades[i + 1];
                        }
                        
                        produtos[qtd - 1] = null;
                        quantidades[qtd - 1] = 0;
                        qtd--;
                        
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Posição inválida.");
                    }

                    System.out.println("\n LISTA APÓS REMOÇÃO");
                    listar(produtos, quantidades, qtd);
                    break;
                case 0:
                    System.out.println("SAINDO...");
                    break;
            
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }while (op != 0);

        sc.close();
    }

    public static void listar(String[] nomes, int[] qtds, int total) {
        if (total == 0) {
            System.out.println("Nenhum produto cadastrado.");
        }else {
            for (int i = 0; i < total; i++) {
                System.out.println(i + " - Nome: " + nomes[i] + " | Quantidade: " + qtds[i]);
            }

        }
    }
}