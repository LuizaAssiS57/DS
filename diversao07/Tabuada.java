package diversao07;

// 4-ESCREVA UM NÚMERO QUE IMPRIMA NA TELA A TABUADA DE TODOS OS NÚEMROS DE 1 A 10

public class Tabuada {
    public static void main(String[] args) {
        for (int numero = 1; numero <= 10; numero++) {
            System.out.println("====== TABUADA DO "+ numero + " ======");

            for (int i = 0; i < 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        }
    }
}
