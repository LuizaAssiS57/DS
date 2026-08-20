package Diversao03;

import java.util.Scanner;

// 2-Fazer um programa para ler um número inteiro e dizer se este número é par ou ímpar.

public class Atv02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar um número: ");
        int numero = sc.nextInt();

        if (numero%2 == 0) {
            System.out.println("Par");
        }else{
            System.out.println("Impar");
        }

        sc.close();
    }
}
