package diversao04;

import java.util.Scanner;

// Implemente um programa em Java que exiba um menu com três tipos de canetas: esferográfica, gel e tinteiro. Ao escolher uma opção, o programa deve apresentar uma descrição sobre a caneta selecionada. O menu deve continuar sendo exibido até que o usuário escolha sair.

public class Canetas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op = 4;

        do {
            System.out.println("\n=+=+=+MENU+=+=+=");
            System.out.println("1 - Esferográfica");
            System.out.println("2 - Gel");
            System.out.println("3 - Tinteiro");
            System.out.println("0 - Sair");
            System.out.println("=+=+=+=+=+=+=+=+=+=");
            System.out.println("Escolha a opção...");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Caneta Esferográfica: Econômica e de longa duração");
                    break;
                case 2:
                    System.out.println("Caneta Gel: Tinta mais pigmentada e escrita suave");
                    break;
                case 3:
                    System.out.println("Caneta Tinteiro: Clássica e elegante, usada para caligrafia");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (op != 4);
        sc.close();
    }
}
