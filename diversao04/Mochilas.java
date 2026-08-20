package diversao04;

import java.util.Scanner;

public class Mochilas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("\n=+=+=+MENU+=+=+=");
            System.out.println("1 - Mochila Escolar");
            System.out.println("2 - Mochila de Viagem");
            System.out.println("3 - Mochila Esportiva");
            System.out.println("0 - Sair");
            System.out.println("=+=+=+=+=+=+=+=+=");
            System.out.println("Escolha a opção...");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println(" Mochila Escolar: Compacta e ideal para estudantes");
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    break;
                    case 2:
                    System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println("Mochila de Viagem: Espaçosa, ideal para longas jornadas");
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    break;
                    case 3:
                    System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println("Mochila Esportiva: Leve, resistente e ergonômica");
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    break;
                    case 0:
                    System.out.println("\n=+=+=+=+=");
                    System.out.println("Saindo...");
                    System.out.println("=+=+=+=+=+=");
                    break;
            
                default:
                    System.out.println("Opção invalida!!");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
