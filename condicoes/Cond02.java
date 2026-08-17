package condicoes;

import java.util.Scanner;

public class Cond02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informar a nota do aluno: ");
        double nota = sc.nextDouble();
        
        System.out.println("Informar a frequência do aluno: ");
        double frequencia = sc.nextDouble();

        if (nota >= 7 && frequencia >= 75){
            System.out.println("Ap");
        }else{
            System.out.println("Rep");
        }

        sc.close();
    }
}
