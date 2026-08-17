package diversaocondicional;

import java.util.Scanner;

// 1-Elaborar um programa que permita ler um número inteiro a partir do teclado, e apresentar a indicação de que é positivo, negativo ou nulo.

public class Atv01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar um número: ");
        int numero = sc.nextInt();

        if (numero < 0) {
            System.out.println("Negativo");
        }else if (numero > 0) {
            System.out.println("Positivo");
        }else if (numero == 0) {
            System.out.println("Nulo");
        }else{
            System.out.println("Invalido");
        }

        sc.close();
    }
}
