package diversao06;

import java.util.Scanner;

public class Emabalagens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        while (op != 0) {
            System.out.println("\n=+=+=MENU=+=+=");
            System.out.println("1 - Caixa de papelão");
            System.out.println("2 - Sacola plática");
            System.out.println("3 - Embalagem de vidro");
            System.out.println("0 - Sair");
            System.out.println("=+=+=+=+=+=+=+=+=");
            System.out.println("Escolha a opção...");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Caixa de papelão: Ideal para transporte e armazenamento");
                    break;
                case 2:
                    System.out.println("Sacola plástica: Leve e prática, mas pouco sustentável");
                    break;
                case 3:
                    System.out.println("Embalagem de vidro: Resistente e reutilizável");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        sc.close();
    }
}
