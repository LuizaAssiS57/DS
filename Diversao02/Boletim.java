package diversao02;

import java.util.Scanner;

public class Boletim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do aluno: ");
        String nome = sc.nextLine();
        
        System.out.println("Informe a 1ª nota: ");
        double nota1 = sc.nextDouble();

        System.out.println("Informe a 2ª nota: ");
        double nota2 = sc.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.printf("Aluno: %s%n", nome);
        System.out.printf("Nota 1: %.2f%n", nota1);
        System.out.printf("Nota 2: %.2f%n", nota2);
        System.out.printf("Média: %.2f%n", media);
        
        sc.close();
    }
}
