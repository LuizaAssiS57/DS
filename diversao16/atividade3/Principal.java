package diversao16.atividade3;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        while (true) {
            System.out.println("\n<<<>>> SISTEMA DE PRODUTOS <<<>>>");
            System.out.println("1 - CADASTRAR PRODUTO FÍSICO");
            System.out.println("2 - CADASTRAR PRODUTO DIGITAL");
            System.out.println("3 - MOSTRAR DADOS DOS PRODUTOS");
            System.out.println("4 - REALIZAR VENDA");
            System.out.println("5 - REALIZAR VENDA COM DESCONTO");
            System.out.println("0 - SAIR");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: {
                    System.out.println("\n>>> CADASTRAR PRODUTO FÍSICO <<<");
                    System.out.print("Informe o código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Informe o nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Preço unitário: R$ ");
                    double preco = sc.nextDouble();
                    
                    System.out.print("Valor do frete: R$ ");
                    double frete = sc.nextDouble();
                    sc.nextLine();

                    produtos.add(new ProdutoFisico(codigo, nome, preco, frete));
                    System.out.println("PRODUTO FISICO CADASTRADO COM SUCESSO!");
                    break;
                }
                case 2: {
                    System.out.println("\n>>> CADASTRAR PRODUTO DIGITAL <<<");
                    System.out.print("Informe o código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Informe o nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Preço unitário: R$ ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    produtos.add(new ProdutoDigital(codigo, nome, preco));
                    System.out.println("PRODUTO DIGITAL CADASTRADO COM SUCESSO!");
                    break;
                }
                case 3: {
                    System.out.println("\n<<<<< DADOS DOS PRODUTOS >>>>>");
                    if (produtos.isEmpty()) {
                        System.out.println("NENHUM PRODUTO CADASTRADO!");
                    } else {
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println("---------------------------");
                            System.out.println(produtos.get(i).exibirDados());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("\n>>> REALIZAR VENDA <<<");
                    if (produtos.isEmpty()) {
                        System.out.println("NENHUM PRODUTO CADASTRADO!");
                        break;
                    }
                    
                    System.out.print("Informe o código do produto para a venda: ");
                    int codigoBusca = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoBusca) {
                            System.out.print("Informe a quantidade: ");
                            int qtd = sc.nextInt();
                            sc.nextLine();
                            
                            double valorFinal = p.realizarVenda(qtd);
                            System.out.println("\n--- NOTA FISCAL ---");
                            System.out.println("Produto: " + p.getNome());
                            System.out.printf("Valor Final: R$ %.2f\n", valorFinal);
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("PRODUTO COM ESSE CÓDIGO NÃO ENCONTRADO!");
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n>>> REALIZAR VENDA COM DESCONTO <<<");
                    if (produtos.isEmpty()) {
                        System.out.println("NENHUM PRODUTO CADASTRADO!");
                        break;
                    }
                    
                    System.out.print("Informe o código do produto para a venda: ");
                    int codigoBusca = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoBusca) {
                            System.out.print("Informe a quantidade: ");
                            int qtd = sc.nextInt();
                            
                            System.out.print("Informe o desconto (em %): ");
                            double desconto = sc.nextDouble();
                            sc.nextLine();
                            
                            double valorFinal = p.realizarVenda(qtd, desconto);
                            System.out.println("\n--- Resumo da Venda ---");
                            System.out.println("Produto: " + p.getNome());
                            System.out.printf("Valor Final com %s%% de desconto: R$ %.2f\n", desconto, valorFinal);
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("PRODUTO COM ESSE CÓDIGO NÃO ENCONTRADO!");
                    }
                    break;
                }
                case 0: {
                    System.out.println("SAINDO...");
                    sc.close();
                    return;
                }
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        }
    }
}
