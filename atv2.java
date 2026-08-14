package diversao;

import java.util.Scanner;

//ESCREVA UM PROGRAMA QUE CALCULE A MÉDIA ARITMÉTICA DE DOIS NÚMEROS.

public class atv2 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe N1: ");
        double N1 = sc.nextDouble();
        
        System.out.println("Informe N2: ");
        double N2 = sc.nextDouble();

        double media = (N1 + N2)/2;

        System.out.println("Sua média é: "+ media);
        sc.close();
    }
}
