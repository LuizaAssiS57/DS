package diversaocondicional;

import java.util.Scanner;

// 4-ESCREVA UM PROGRAMA QUE SOLICITE A IDADE DE UMA PESSOA E EXIBA SE ELA É MAIOR DE IDADE OU NÃO.

public class Atv04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar a idade: ");
        int idade = sc.nextInt();

        if (idade >= 18) {
            System.out.println("Maior idade");
        }else{
            System.out.println("Menor idade");
        }

        sc.close();
    }
}
