package diversao18;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeBank2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.00;

        System.out.println("=====SAFE BANK=====");
        System.out.println("Saldo disponivel: " + saldo);

        try {
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = sc.nextDouble();

            if (valorSaque < 0) {
                System.out.println("Erro: O valor do saque não pode ser negativo");
            } else if (valorSaque > saldo) {
                System.out.println("Erro: Saldo insuficiente");
            } else {
                saldo -= valorSaque;
                System.out.println("Saque realizado com sucesso!");
                System.out.println("Novo saldo: R$ " + saldo);
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro critico: entrada inválida! Por Favor, use apenas números e virgula");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!");
        }
        finally {
            System.out.println("Operação finalizada");
        }
        sc.close();
    }
}
