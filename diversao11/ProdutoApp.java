package diversao11;

import java.util.Scanner;

public class ProdutoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto p = new Produto(null, 0, 0);

        System.out.println("Informe o nome do produto: ");
        p.setNome(sc.nextLine());

        System.out.println("Informe o preço do produto: ");
        p.setPreco(sc.nextFloat());

        System.out.println("Informe a quantidade do produto: ");
        p.setQtd(sc.nextInt());

        System.out.println("Produto: "+ p.getNome());
        System.out.println("Preço: "+ p.getPreco());
        System.out.println("Quantidade: "+ p.getQtd());
        sc.close();
    }
}
