package diversao14;

import java.util.Scanner;

public class AnimalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cachorro c = null;
        Gato g = null;

        int op;

        do {
            System.out.println("===== CLINÍCA VETERINÁRIA =====");
            System.out.println("1 - Cadastrar Cachorro");
            System.out.println("2 - Cadastrar Gato");
            System.out.println("3 - Mostrar dados do Cachorro");
            System.out.println("4 - Mostrar dados do Gato");
            System.out.println("5 - Fazer Cachorro emitir som");
            System.out.println("6 - Fazer Gato emitir som");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite apenas números de 0 a 6.");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("=====CADASTRO DE CACHORRO=====");
                    System.out.println("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.println("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Raça: ");
                    String raca = sc.nextLine();

                    c = new Cachorro(nome, idade, raca);
                    break;
                }
                case 2:{
                    System.out.println("=====CADASTRO DE GATO=====");
                    System.out.println("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.println("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Cor: ");
                    String cor = sc.nextLine();

                    g = new Gato(nome, idade, cor);
                    break;
                }
                case 3:{
                    System.out.println("=====INFORMAÇÕES DO CACHORRO=====");
                    if (c != null){
                        c.exibirInfo();
                    }else{
                        System.out.println("Não há cachorros cadastrados!");
                    }
                    break;
                }
                case 4:{
                    System.out.println("=====INFORMAÇÕES DO GATO=====");
                    if (g != null){
                        g.exibirInfo();
                    }else{
                        System.out.println("Não há gatos cadastrados!");
                    }
                    break;
                }
                case 5:{
                    c.emitirSom();
                    break;
                }
                case 6:{
                    g.emitirSom();
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
