package diversao04;

import java.util.Scanner;

// Escreva um programa que solicite ao usuário uma senha numérica de 4 dígitos. O programa deve repetir a leitura até que a senha digitada seja igual a 2024. Quando acertar, exiba "Acesso Permitido".

public class Senha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha = "";

        do {
            System.out.println("Informe a senha: ");
            senha = sc.nextLine();
        } while (!senha.equals("2024"));
        System.out.println("Acesso permitido");
        sc.close();
    }
}
