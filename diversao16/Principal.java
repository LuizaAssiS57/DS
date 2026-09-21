package diversao16;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        while (true) {
            System.out.println("<<<>>> SISTEMA FUNCIONÁRIOS <<<>>>");
            System.out.println("1 - Cadastrar funcionário CLT");
            System.out.println("2 - Cadastrar funcionário Freelancer");
            System.out.println("3 - Mostrar os dados cadastrados");
            System.out.println("4 - Pesquisar funcionário");
            System.out.println("5 - Alterar funcionário");
            System.out.println("6 - Excluir funcionário");
            System.out.println("0 - Sair do sistema");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.println("Escolha uma opção: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("\n>>> CADASTRAR FUNCIONÁRIO CLT<<<");
                    System.out.println("Informe o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Informe o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.println("Salário mensal: ");
                    double salarioMensal = sc.nextDouble();

                    funcionarios.add(new FuncionarioCLT(nome, cpf, salarioMensal));
                    System.out.println("CLT cadastrado!");
                    break;
                }
                case 2:{
                    System.out.println("\n>>> CADASTRAR FUNCIONÁRIO FREELANCER <<<");
                    System.out.println("Informe o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Informe o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.println("Horas trabalhadas: ");
                    int horasTrabalho = sc.nextInt();

                    System.out.println("Valor por hora: ");
                    double valorHora = sc.nextDouble();

                    funcionarios.add(new FuncionarioFreelancer(nome, cpf, valorHora, horasTrabalho));
                    System.out.println("Freelancer cadastrado!");
                    break;
                }
                case 3:
                    System.out.println("<<<<< LISTA DE FUNCIONÁRIOS >>>>>");
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado");
                    } else {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            System.out.println((i + 1) + " - " + funcionarios.get(i).exibirDados());
                        }
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 0:
                    System.out.println("FUI......");
                    sc.close();
                    return;
            
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");

                    break;
            }
        }
    }
}
