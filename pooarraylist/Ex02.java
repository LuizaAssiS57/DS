package pooarraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(10);
        numeros.add(70);
        numeros.add(50);

        System.out.println("NÚMEROS");
        for (Integer num : numeros) {
            System.out.println(num);
        }

        System.out.println("\nDigite o número que deseja remover: ");
        int numeroRemover = sc.nextInt();

        numeros.remove(Integer.valueOf(numeroRemover));
        System.out.println("NÚMEROS APÓS REMOVER");
        
        for (Integer num : numeros) {
            System.out.println(num);
        }
        
        // numeros.set(1, 3);
        // System.out.println("NÚMEROS APÓS ALTERAR");
        
        // numeros.remove(0);
        // for (Integer num : numeros) {
        //     System.out.println(num);
        // }

        sc.close();
    }
}
