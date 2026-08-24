package diversao07;

// 3-Escreva um programa que imprima os números impares de 1 a 51 e os pares de 52 a 100

public class Impares {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0 && i <= 51) {
                System.out.println("ÍMPAR: "+ i);
            }else if (i % 2 == 0 && i >= 52) {
                System.out.println("PAR: "+ i);
            }
        }
    }
}
