package diversao12;

import java.util.Scanner;

public class VeiculoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;

        do {
            System.out.println("===Sistema de cadastro de veiculos===");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite 0, 1 ou 2");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("Informe a marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Informe o ano: ");
                    String ano = sc.nextLine();

                    System.out.println("Informe a quantidade de portas: ");
                    int qtdportas = sc.nextInt();

                    Carro c = new Carro(marca, ano, qtdportas);
                    c.setMarca(marca);
                    c.setAno(ano);
                    c.setQtdportas(qtdportas);

                    System.out.println("\n---Informações do veiculo---");
                    c.exibirDados();
                    break;
                }
                case 2:{
                    System.out.println("Informe a marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Informe o ano: ");
                    String ano = sc.nextLine();

                    System.out.println("Informe cilindragem: ");
                    int cilindrada = sc.nextInt();

                    Moto m = new Moto(marca, ano, cilindrada);
                    m.setMarca(marca);
                    m.setAno(ano);
                    m.setCilindrada(cilindrada);

                    System.out.println("\n--Informações do veiculo---");
                    m.exibirDados();
                    break;
                }
                case 0:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        } while (op != 0);
        sc.close();
    }
}
