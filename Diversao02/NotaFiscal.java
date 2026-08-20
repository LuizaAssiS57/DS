package Diversao02;

import java.util.Scanner;

public class NotaFiscal {
    public static void main(String[] args) {
        Scanner nf = new Scanner(System.in);

        System.out.println("Informe o nome do cliente: ");
        String nome_cliente = nf.nextLine();

        System.out.println("Informe o nome do produto: ");
        String nome_produto = nf.nextLine();

        System.out.println("Informe a quantidade: ");
        int quantidade = nf.nextInt();

        System.out.println("Informe o valor unitário: ");
        double valorUnitario = nf.nextDouble();

        double total = quantidade * valorUnitario;

        System.out.println("-------- NOTA FISCAL --------");
        System.out.printf("Cliente: %s%n", nome_cliente);
        System.out.printf("Produto: %s%n", nome_produto);
        System.out.printf("Quantidade: %d%n", quantidade);
        System.out.printf("Valor unitário: %.2f%n", valorUnitario);
        System.out.printf("Total: %.2f%n", total);
        System.out.printf("----------------------------");
        
        nf.close();
    }
}
