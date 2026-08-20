package diversao03;

import java.util.Scanner;

/*
7-Em uma loja e CD ́s existem apenas quatro tipos de preços que estão associados a cores. Assim os CD ́s que ficam na loja não são marcados por preços e sim por cores.
Desenvolva o algoritmo que a partir a entrada da cor o software mostre o preço. A loja está atualmente com a seguinte tabela de preços.
*/

public class Atv07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a cor: ");
        String cor = sc.nextLine();
        cor = cor.toUpperCase();

        if (cor.equals("VERDE")) {
            System.out.println("Preço: R$10");
        }else if (cor.equals("AZUL")){
            System.out.println("Preço: R$20");
        }else if (cor.equals("AMARELO")) {
            System.out.println("Preço: R$30");
        }else if (cor.equals("VERMELHO")) {
            System.out.println("Preço: R$40");
        }else{
            System.out.println("Cor invalida!");
        }

        sc.close();
    }
}
