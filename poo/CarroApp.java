package poo;

import java.util.Scanner;

public class CarroApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Carro c = new Carro(null, null, 0);

        System.out.println("Informe a marca: ");
        c.setMarca(sc.nextLine());

        System.out.println("Informe o modelo: ");
        c.setModelo(sc.nextLine());

        System.out.println("Informe o ano: ");
        c.setAnofabricacao(sc.nextInt());

        System.out.println("A marca: " + c.getMarca());
        System.out.println("O modelo: " + c.getModelo());
        System.out.println("O ano: " + c.getAnofabricacao());

        
        sc.close();
    }
}