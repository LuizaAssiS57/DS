package diversao19;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Conta> contas = new ArrayList<>();

        while (true) {

            try {
                System.out.println("+++++CADASTRO DE CONTAS BANCÁRIAS+++++");
                System.out.println("1 - CADASTRAR CONTA");
                System.out.println("2 - BUSCAR CONTA");
                System.out.println("3 - REMOVER CONTA");
                System.out.println("4 - SAIR");
                System.out.println("++++++++++++++++++++++++++++++++++++++");
                System.out.println("ESCOLHA UMA OPÇÃO: ");
                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.println(">>>CADASTRAR CONTA<<<");
                        System.out.println("\nTITULAR DA CONTA: ");
                        String titular = sc.nextLine();

                        System.out.println("NÚMERO DA CONTA: ");
                        String numeroConta = sc.nextLine();

                        System.out.println("SALDO: R$");
                        double saldo = sc.nextDouble();

                        Conta novaConta = new Conta(titular, numeroConta, saldo);
                        contas.add(novaConta);
                        System.out.println("CONTA CADASTRADA COM SUCESSO!");
                        break;
                    case 2:
                        System.out.println("\n>>> BUSCAR CONTA <<<");
                        if (contas.isEmpty()) {
                            System.out.println("NENHUMA CONTA REGISTRADA!");
                            break;
                        }
                        System.out.print("Informe o número da conta para pesquisar: ");
                        String contaBusca = sc.nextLine();
                        boolean encontrado = false;
                        
                        for (Conta c : contas) {
                            if (c.getNumeroConta().equalsIgnoreCase(contaBusca)) {
                                System.out.println("\nCONTA ENCONTRADA:");
                                System.out.println(c.mostrarDadosConta());
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("CONTA NÃO ENCONTRADA!");
                        }
                        break;
                    case 3:
                        System.out.println("\n>>> REMOVER CONTA <<<");
                        if (contas.isEmpty()) {
                            System.out.println("NENHUMA CONTA REGISTRADA!");
                            break;
                        }
                        System.out.print("Informe o número da conta que deseja remover: ");
                        String contaRemover = sc.nextLine();
                        boolean removido = false;

                        for (int i = 0; i < contas.size(); i++) {
                            if (contas.get(i).getNumeroConta().equalsIgnoreCase(contaRemover)) {
                                contas.remove(i);
                                System.out.println("CONTA REMOVIDA COM SUCESSO!");
                                removido = true;
                                break;
                            }
                        }
                        if (!removido) {
                            System.out.println("CONTA NÃO ENCONTRADA!");
                        }
                        break;
                    case 4:
                        System.out.println("SAINDO...");
                        break;
                
                    default:
                        System.out.println("INVÁLIDO!");
                        break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Por favor, digite números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}