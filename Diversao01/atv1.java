package Diversao01;

import java.util.Scanner;

//ESCREVA UM PROGRAMA QUE SOLICITE AO USUÁRIO DOIS NÚMEROS E EXIBA A SOMA, SUBTRAÇÃO, DIVISÃO E MULTIPLICAÇÃO.

public class atv1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o N1: ");
        double N1 = sc.nextDouble();

        System.out.println("Informe o N2: ");
        double N2 = sc.nextDouble();

        double soma = N1 + N2;
        double sub = N1 - N2;
        double div = N1 / N2;
        double mult = N1 * N2;

        System.out.println(soma);
        System.out.println(sub);
        System.out.println(div);
        System.out.println(mult);

        sc.close();

    }
}
