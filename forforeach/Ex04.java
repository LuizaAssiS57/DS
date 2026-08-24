package forforeach;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 3; i <= 3; i++) {
            System.out.println("Informe o "+i+"º número: ");
            int numero = sc.nextInt();
            System.out.println("O número informado é: "+ numero);
        }
        sc.close();
    }
}
