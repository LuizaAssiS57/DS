package diversao13;

import java.util.Scanner;

public class FuncionarioApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Professor p = null;
        Tecnico t = null;

        int op;

        do {
            System.out.println("===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Técnico");
            System.out.println("3 - Exibir Professor");
            System.out.println("4 - Exibir Técnico");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite apenas números de 0 a 4.");
                sc.next();
            }

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("=====CADASTRO DE PROFESSOR=====");
                    System.out.println("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.println("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Disciplina: ");
                    String disciplina = sc.nextLine();

                    p = new Professor(nome, salario, disciplina);
                    // p.setNome(nome);
                    // p.setSalario(salario);
                    // p.setDisciplina(disciplina);
                    break;
                }
                case 2:{
                    System.out.println("=====CADASTRO DE TÉCNICO=====");
                    System.out.println("\nNome: ");
                    String nome = sc.nextLine();

                    System.out.println("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Setor: ");
                    String setor = sc.nextLine();

                    t = new Tecnico(nome, salario, setor);
                    // t.setNome(nome);
                    // t.setSalario(salario);
                    // t.setSetor(setor);
                    break;
                }
                case 3:
                    System.out.println("=====INFORMAÇÕES DO PROFESSOR=====");
                    p.exibirInfo();
                    break;
                case 4:
                    System.out.println("=====INFORMAÇÕES DO TÉCNICO=====");
                    t.exibirInfo();
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
