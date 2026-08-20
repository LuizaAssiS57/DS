package whiledowhile;

import java.util.Scanner;

public class Dw05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 0;

        do {
            System.out.println("\n=====MENU=====");
            System.out.println("1 - Iniciar jogo");
            System.out.println("2 - Carregar jogo");
            System.out.println("3 - Configurações");
            System.out.println("0 - Sair");
            System.out.println("\n=============");
            System.out.println("Escolha a opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Iniciar jogo");
                    break;
                case 2:
                    System.out.println("Carregar jogo");
                    break;
                case 3:
                    System.out.println("Configurações");
                    break;
                case 0:
                    System.out.println("Sair");
                    break;
            
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
