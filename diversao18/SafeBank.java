package diversao18;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 75000;

        try {
            System.out.println("++++SAFEBANK++++");
            System.out.println("Informe valor para sacar: ");
            double valor = sc.nextDouble();

            if (valor <= 0) {
                System.out.println("Não é possivel sacar um valor abaixo de zero!");
            } else if (valor > saldo){
                System.out.println("Saldo insuficiente!");
            } else{
                System.out.println("Saque efetuado com sucesso!");
                System.out.printf("Novo saldo: R$" + (saldo -= valor));
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro critico: entrada inválida! Por Favor, use apenas números e virgula");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!" + e.getMessage());
        }
        finally{
            System.out.println("\nOperação encerrada!");
        }
        sc.close();
    }
}
