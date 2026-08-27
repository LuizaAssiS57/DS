package vetores;

import java.util.Scanner;

public class Vet04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[3];

        // inserir
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Informe o nome: ");
            nomes[i] = sc.nextLine();
        }
        // listando
        System.out.println("Nomes cadastrados são: ");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }

        sc.close();
    }
}
