package diversao05;

import java.util.Scanner;

// Faça um programa em que o usuário digite diversos números positivos. Se digitar um número negativo o programa termina.

public class Negativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero = 1;

        while (numero > 0) {
            System.out.println("Informe um número: ");
            numero = sc.nextInt();
        }
        System.out.println("Número negativo!");

        sc.close();
    }
}
