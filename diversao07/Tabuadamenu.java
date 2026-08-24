package diversao07;

import java.util.Scanner;

/*
6-Escreva o programa que deverá apresentar o seguinte menu ao usuário:
1 - Calcular Tabuada
2 - Realizar Contagem Regressiva
0 - Sair
*/

public class Tabuadamenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=+=+=+MENU+=+=+=");
            System.out.println("1 - Calcular Tabuada");
            System.out.println("2 -  Realizar Contagem Regressiva");
            System.out.println("0 - Sair");
            System.out.println("=+=+=+=+=+=+=+=+=");
            System.out.println("Escolha a opção...");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println(" Calcular Tabuada");
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println("Informe o número: ");
                    int numero = sc.nextInt();

                    for (int i = 1; i <= 10; i++) {
                        System.out.println(numero+" x "+i+" = "+(numero*i));
                    }
                    break;
                    case 2:
                    System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println("Realizar Contagem Regressiva");
                    System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
                    System.out.println("Informe o número de inicio: ");
                    int x = sc.nextInt();
                    for (int i = x; i >= 0; i--) {
                        System.out.println(i);
                    }
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
