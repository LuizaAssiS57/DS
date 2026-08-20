package whiledowhile;

import java.util.Scanner;

public class Wh04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senha = "";

        while (!senha.equals("1234")) {
            System.out.println("Informe a senha: ");
            senha = sc.nextLine();
        }
        System.out.println("Acesso permitido");
        sc.close();
    }
}
