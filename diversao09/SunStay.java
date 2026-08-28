package diversao09;

import java.util.Scanner;

public class SunStay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int tam = 5;

        String [] hospedes = new String[tam];
        int [] quartos = new int[tam];

        int qtd = 0;
        int op;

        do {
            System.out.println("\n===== SUNSTAY =====");
            System.out.println("1 - REGISTRAR NÚMERO DO QUARTO");
            System.out.println("2 - REGISTRAR QUANTIDADE DE CAMAS");
            System.out.println("3 - RESERVAR QUARTO");
            System.out.println("4 - RESERVAS POR QUARTO");
            System.out.println("5 - RESERVAS POR HOSPEDES");
            System.out.println("0 - SAIR DO SISTEMA");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 0:
                    System.out.println("Partiu.");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
