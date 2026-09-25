package diversao17;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("<<<<< CADASTRO INICIAL >>>>>");

        System.out.println("Número da agência: ");
        int numAgencia = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome da agência: ");
        String nomeAgencia = sc.nextLine();

        System.out.println("Número da conta: ");
        int numConta = sc.nextInt();
        sc.nextLine();

        System.out.println("Titular: ");
        String titular = sc.nextLine();

        System.out.println("Saldo inicial: R$ ");
        double saldoInicial = sc.nextDouble();

        Agencia agencia = new Agencia(numAgencia, nomeAgencia);
        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n<<< MENU >>>");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    conta.mostrarDadosConta();
                    break;
                case 2:
                    conta.consultarSaldo();
                    break;
                case 3:
                    System.out.println("Informe o valor para depósito: R$ ");
                    double valorDep = sc.nextDouble();
                    conta.depositarDinheiro(valorDep);
                    break;
                case 4:
                    System.out.println("Informe o valor do PIX: R$ ");
                    double valorPix = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Informe a chave PIX: ");
                    String chave = sc.nextLine();
                    conta.fazerPagamento(valorPix, chave);
                    break;
                case 5:
                    System.out.println("Informe o valor da compra: R$ ");
                    double valorCartao = sc.nextDouble();
                    System.out.println("Informe a quantidade de parcelas: ");
                    int parcelas = sc.nextInt();
                    conta.fazerPagamento(valorCartao, parcelas);
                    break;
                case 6:
                    System.out.println("Informe o valor do pagamento em dinheiro: R$ ");
                    double valorDinheiro = sc.nextDouble();
                    conta.fazerPagamento(valorDinheiro);
                    break;
                case 0:
                    System.out.println("SAINDO...");
                    break;
            
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
            }
        }
        sc.close();
    }
}