package Diversao01;

import java.util.Scanner;

//ESCREVA UM PROGRAMA QUE CALCULE O TRABALHO REALIZADO POR UMA FORÇA QUE ATUA SOBRE UM OBJETO, UTILIZANDO A FÓRMULA T=F*D, ONDE T É O TRABALHO, F É A FORÇA APLICADA E D É A DISTÂNCIA PERCORRIDA PELO OBJETO

public class atv4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe F: ");
        double F = sc.nextDouble();

        System.out.println("Informe D: ");
        double D = sc.nextDouble();

        double T = F * D;

        System.out.println("T = "+F+" * "+D);
        System.out.println("T = "+T);

        sc.close();
    }
}
