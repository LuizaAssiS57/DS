package diversao12;

import java.util.Scanner;

public class VeiculoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Carro c = null;
        Moto m = null;

        int op;

        do {
            System.out.println("===Sistema de cadastro de veiculos===");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Mostrar Carro");
            System.out.println("4 - Mostrar Moto");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite 0 até 4");
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

                    c = new Carro(marca, ano, qtdportas);

                    
                    break;
                }
                case 2:{
                    System.out.println("Informe a marca: ");
                    String marca = sc.nextLine();

                    System.out.println("Informe o ano: ");
                    String ano = sc.nextLine();

                    System.out.println("Informe cilindragem: ");
                    int cilindrada = sc.nextInt();

                    m = new Moto(marca, ano, cilindrada);

                    
                    break;
                }
                case 3:
                    System.out.println("\n---Informações do veiculo---");
                    if (c != null){
                        c.exibirDados();
                    }else{
                        System.out.println("Não há carros cadastrados!");
                    }
                    break;
                case 4:
                    System.out.println("\n--Informações do veiculo---");
                    if (m != null) {
                        m.exibirDados();
                    }else{
                        System.out.println("Não há motos cadastradas!");
                    }
                    break;
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
