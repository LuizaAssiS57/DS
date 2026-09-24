package diversao16.atividade5;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();

        while (true) {
            System.out.println("\n<<<>>> SISTEMA DE PEDIDOS <<<>>>");
            System.out.println("1 - CADASTRAR PEDIDO (LOCAL OU DELIVERY)");
            System.out.println("2 - MOSTRAR DADOS DOS PEDIDOS");
            System.out.println("3 - ESCOLHER FORMA DE PAGAMENTO");
            System.out.println("0 - ENCERRAR O PROGRAMA");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: {
                    System.out.println("\n>>> ESCOLHER TIPO DE PEDIDO <<<");
                    System.out.println("1 - Pedido Local");
                    System.out.println("2 - Pedido Delivery");
                    System.out.print("Opção: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Número do pedido: ");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Valor do pedido: R$ ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {
                        pedidos.add(new PedidoLocal(numero, nome, valor));
                        System.out.println("Pedido Local cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Endereço de entrega: ");
                        String endereco = sc.nextLine();
                        System.out.print("Taxa de entrega: R$ ");
                        double taxa = sc.nextDouble();
                        sc.nextLine();
                        
                        pedidos.add(new PedidoDelivery(numero, nome, valor, endereco, taxa));
                        System.out.println("Pedido Delivery cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo de pedido inválido!");
                    }
                    break;
                }
                
                case 2: {
                    System.out.println("\n<<<<< DADOS DOS PEDIDOS >>>>>");
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido cadastrado!");
                    } else {
                        for (Pedido p : pedidos) {
                            System.out.println("---------------------------");
                            System.out.println(p.exibirDados());
                        }
                    }
                    break;
                }
                
                case 3: {
                    System.out.println("\n>>> ESCOLHER FORMA DE PAGAMENTO <<<");
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido para pagar!");
                        break;
                    }

                    System.out.print("Informe o número do pedido que deseja pagar: ");
                    int numeroBusca = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Pedido p : pedidos) {
                        if (p.getNumeroPedido() == numeroBusca) {
                            encontrado = true;
                            
                            double valorCobrado = p.getValorPedido();
                            
                            if (p instanceof PedidoDelivery) {
                                valorCobrado += ((PedidoDelivery) p).getTaxaEntrega();
                            }

                            System.out.println("\nValor a pagar: R$ " + String.format("%.2f", valorCobrado));
                            System.out.println("1 - Pagar em Dinheiro");
                            System.out.println("2 - Pagar via PIX");
                            System.out.println("3 - Pagar com Cartão");
                            System.out.print("Escolha a forma: ");
                            int formaPgto = sc.nextInt();
                            sc.nextLine();

                            if (formaPgto == 1) {
                                p.realizarPagamento(valorCobrado);
                            } else if (formaPgto == 2) {
                                System.out.print("Informe a chave PIX: ");
                                String chave = sc.nextLine();
                                p.realizarPagamento(valorCobrado, chave);
                            } else if (formaPgto == 3) {
                                System.out.print("Informe a quantidade de parcelas: ");
                                int parcelas = sc.nextInt();
                                sc.nextLine();
                                p.realizarPagamento(valorCobrado, parcelas);
                            } else {
                                System.out.println("Opção de pagamento inválida!");
                            }
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Pedido não encontrado.");
                    }
                    break;
                }
                
                case 0: {
                    System.out.println("Encerrando o programa. Bom descanso!");
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
