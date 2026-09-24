package diversao16;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        while (true) {
            System.out.println("<<<>>> SISTEMA FUNCIONÁRIOS <<<>>>");
            System.out.println("1 - CADASTRAR FUNCIONÁRIO CLT");
            System.out.println("2 - CADASTRAR FUNCIONÁRIO FREELANCER");
            System.out.println("3 - LISTA DE FUNCIONÁRIOS");
            System.out.println("4 - PESQUISAR FUNCIONÁRIO");
            System.out.println("5 - CALCULAR PAGAMENTO COM BÔNUS");
            System.out.println("6 - EXCLUIR FUNCIONÁRIO");
            System.out.println("0 - SAIR DO SISTEMA");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("\n>>> CADASTRAR FUNCIONÁRIO CLT <<<");
                    System.out.println("Informe o nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Informe o CPF: ");
                    String cpf = sc.nextLine();

                    System.out.println("Salário mensal: ");
                    double salarioMensal = sc.nextDouble();
                    sc.nextLine();

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
                    sc.nextLine();

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
                case 4:{
                    System.out.println("\n>>> PESQUISAR FUNCIONÁRIO <<<");
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário registrado!");
                        break;
                    }

                    System.out.println("Informe o CPF para pesquisar: ");
                    String cpfBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Funcionario f : funcionarios) {
                        if (f.getCpf().equalsIgnoreCase(cpfBusca)) {
                            System.out.println("\nFuncionário encontrado:");
                            System.out.println(f.exibirDados());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("CPF não encontrado.");
                    }
                    break;
                }
                    
                case 5:{
                    System.out.println("\n>>> CALCULAR PAGAMENTO COM BÔNUS <<<");
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário registrado!");
                        break;
                    }

                    System.out.println("Informe o CPF para pesquisar: ");
                    String cpfBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Funcionario f : funcionarios) {
                        if (f.getCpf().equalsIgnoreCase(cpfBusca)) {
                            System.out.println("Informe o valor do bônus: R$ ");
                            double bonus = sc.nextDouble();
                            sc.nextLine();

                            double total = f.calcPagamento(bonus);
                            System.out.println("\nFuncionário: " + f.getNome());
                            System.out.printf("Pagamento total (+ bônus de %.2f): R$ %.2f\n", bonus, total);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("CPF não encontrado!");
                    }
                    break;
                }
                case 6:{
                    System.out.println("\n>>> EXCLUIR FUNCIONÁRIO <<<");
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário registrado!");
                        break;
                    }

                    System.out.println("Informe o CPF do funcionário a ser excluido: ");
                    String cpfBusca = sc.nextLine();
                    boolean removido = false;

                    for (int i = 0; i < funcionarios.size(); i++) {
                        if (funcionarios.get(i).getCpf().equalsIgnoreCase(cpfBusca)) {
                            System.out.println("Funcionário: " + funcionarios.get(i).getNome() + " removido com sucesso!");
                            funcionarios.remove(i);
                            removido = true;
                        }
                    }

                    if (!removido) {
                        System.out.println("CPF não encontrado.");
                    }
                    break;
                }
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
