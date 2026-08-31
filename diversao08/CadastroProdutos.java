package diversao08;

import java.util.Scanner;

public class CadastroProdutos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int tam = 5;

        String [] produtos = new String[tam];
        int [] quantidades = new int[tam];

        int qtd = 0;
        int op;

        do {
            System.out.println("\n===== MENU DE CADASTRO DE PRODUTOS =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Pesquisar produto (por nome)");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Sair");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (qtd == tam) {
                        System.out.println("Lista cheia");
                        break;
                    }
                    System.out.println("Nome do produto: ");
                    String nome = sc.next();

                    System.out.println("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    produtos[qtd] = nome;
                    quantidades[qtd] = quantidade;
                    qtd++;

                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    if (qtd == 0) {
                        System.out.println("Nenhum produto registrado.");
                        break;
                    }
                    System.out.println("------ PRODUTOS -------");
                    for (int i = 0; i < qtd; i++) {
                        System.out.println(i+" - "+produtos[i]+"| Estoque: "+quantidades[i]);
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome: ");
                    String busca = sc.next();

                    int posBusca = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(busca)) {
                            posBusca = i;
                            break;
                        }
                    }
                    if (posBusca == -1) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }else{
                        System.out.println("Encontrado: "+produtos[posBusca]+"| Estoque: "+quantidades[posBusca]);
                    }
                    break;
                case 4:
                    System.out.println("Informe o nome para alterar: ");
                    String nomeAlterar = sc.next();

                    int posAlt = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(nomeAlterar)) {
                            posAlt = i;
                            break;
                        }
                    }
                    if (posAlt == -1) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }else{
                        System.out.println("Novo nome: ");
                        produtos[posAlt] = sc.next();

                        System.out.println("Nova quantidade: ");
                        quantidades[posAlt] = sc.nextInt();

                        System.out.println("Alterado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome para remover: ");
                    String nomeRemover = sc.next();

                    int posRem = -1;
                    for (int i = 0; i < qtd; i++) {
                        if (produtos[i].equalsIgnoreCase(nomeRemover)) {
                            posRem = i;
                            break;
                        }
                    }

                    if (posRem == -1) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }else{
                        for (int i = posRem; i < qtd; i++) {
                            produtos[i] = produtos[i+1];
                            quantidades[i] = quantidades[i+1];
                        }
                        produtos[qtd-1] = null;
                        quantidades[qtd-1] = 0;
                        qtd--;
                        System.out.println("Removido com sucesso!");
                    }
                    break;
                case 0:
                    System.out.println("Partiu........");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(op != 0);
        sc.close();
    }
}
