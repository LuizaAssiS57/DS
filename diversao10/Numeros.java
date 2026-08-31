package diversao10;

import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int tam = 10;

        int [] numeros = new int[tam];

        int qtd = 0;
        int op;

        do {
            System.out.println("\n===== MENU DE CADASTRO DE PRODUTOS =====");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Listar números");
            System.out.println("3 - Remover número");
            System.out.println("0 - Sair");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (qtd == tam) {
                        System.out.println("Lista cheia");
                        break;
                    }
                    System.out.println("Qual número deseja inserir? ");
                    int numero = sc.nextInt();

                    numeros[qtd] = numero;
                    qtd++;

                    System.out.println("Número cadastrado com sucesso!");
                    break;
                case 2:
                    if (qtd == 0) {
                        System.out.println("Nenhum número registrado.");
                        break;
                    }
                    for (int i = 0; i < qtd; i++) {
                        System.out.println(i+" - "+numeros[i]);
                    }
                    break;
                case 3:
                    if (qtd == 0) {
                        System.out.println("O array está vazio.");
                        break;
                    }
                    System.out.println("Informe o índice que deseja remover: ");
                    int indRemover = sc.nextInt();

                    if (indRemover < 0 || indRemover >= qtd) {
                        System.out.println("Índice inválido!");
                        break;
                    }else {
                        for (int i = indRemover; i < numeros.length - 1; i++) {
                            numeros[i] = numeros[i+1];
                        }
                    }
                    
                    numeros[numeros.length -1] = 0;
                    qtd--;

                    System.out.println("Número removido com sucesso!");
                    break;
                case 0:
                    System.out.println("Partiu...");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;

            }
        } while (op != 0);
        sc.close();
    }
}
