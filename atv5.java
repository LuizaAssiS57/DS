package diversao;

import java.util.Scanner;

//ESCREVA UM PROGRAMA QUE CALCULE O IMC DE UM INDIVÍDUO, UTILIZANDO A FÓRMULA IMC =PESO / ALTURA2.

public class atv5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o peso: ");
        double peso = sc.nextDouble();

        System.out.println("Informe a altura: ");
        double altura = sc.nextDouble();

        double imc = peso/(altura*2);

        System.out.println("Seu IMC é: "+imc);

        sc.close();
    }
}
