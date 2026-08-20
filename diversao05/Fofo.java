package diversao05;

import java.util.Scanner;

// Faça um programa que peça ao usuário para digitar  o nome do professor mais fofo do senai.  O programa só termina se ele digitar Anderson

public class Fofo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha = "";

        while (!senha.equals("Anderson")) {
            System.out.println("Informe o nome do professor mais fofo do SENAI: ");
            senha = sc.nextLine();
        }
        System.out.println("Tá certo, congratulations!");
        sc.close();
    }
}
