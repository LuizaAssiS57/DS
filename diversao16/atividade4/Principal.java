package diversao16.atividade4;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Curso> cursos = new ArrayList<>();

        String nomeAlunoMatriculado = "";
        Curso cursoMatriculado = null;
        double valorMatriculaFinal = 0.0;
        boolean matriculaAtiva = false;

        while (true) {
            System.out.println("\n<<<>>> SISTEMA DE CURSOS <<<>>>");
            System.out.println("1 - CADASTRAR CURSO");
            System.out.println("2 - CADASTRAR NOME DO ALUNO");
            System.out.println("3 - REALIZAR MATRÍCULA");
            System.out.println("4 - REALIZAR MATRÍCULA COM DESCONTO");
            System.out.println("5 - MOSTRAR DADOS DOS CURSOS");
            System.out.println("6 - MOSTRAR DADOS DA MATRÍCULA");
            System.out.println("0 - ENCERRAR O PROGRAMA");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            
            int op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1: {
                    System.out.println("\n>>> ESCOLHER TIPO DE CURSO <<<");
                    System.out.println("1 - Presencial");
                    System.out.println("2 - Online");
                    System.out.print("Opção: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código do curso: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Nome do curso: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Carga Horária (h): ");
                    int carga = sc.nextInt();
                    
                    System.out.print("Valor do curso: R$ ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Nome da sala: ");
                        String sala = sc.nextLine();
                        System.out.print("Turno (Manhã/Tarde/Noite): ");
                        String turno = sc.nextLine();
                        cursos.add(new CursoPresencial(codigo, nome, carga, valor, sala, turno));
                        System.out.println("CURSO PRESENCIAL CADASTRADO!");
                    } else if (tipo == 2) {
                        System.out.print("Endereço da Plataforma (URL): ");
                        String plataforma = sc.nextLine();
                        System.out.print("Código de Acesso: ");
                        String codigoAcesso = sc.nextLine();
                        cursos.add(new CursoOnline(codigo, nome, carga, valor, plataforma, codigoAcesso));
                        System.out.println("CURSO ONLINE CADASTRADO!");
                    } else {
                        System.out.println("Tipo inválido!");
                    }
                    break;
                }
                
                case 2: {
                    System.out.println("\n>>> CADASTRAR NOME DO ALUNO <<<");
                    System.out.print("Informe o nome do aluno: ");
                    nomeAlunoMatriculado = sc.nextLine();
                    System.out.println("Nome cadastrado para a próxima matrícula: " + nomeAlunoMatriculado);
                    break;
                }
                
                case 3: {
                    System.out.println("\n>>> REALIZAR MATRÍCULA <<<");
                    if (cursos.isEmpty()) {
                        System.out.println("NENHUM CURSO CADASTRADO!");
                        break;
                    }
                    if (nomeAlunoMatriculado.isEmpty()) {
                        System.out.println("Cadastre o nome do aluno primeiro (Opção 2)!");
                        break;
                    }
                    
                    System.out.print("Informe o código do curso: ");
                    int codigoBusca = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Curso c : cursos) {
                        if (c.getCodigo() == codigoBusca) {
                            valorMatriculaFinal = c.realizarMatricula();
                            cursoMatriculado = c;
                            matriculaAtiva = true;
                            System.out.println("\nMatrícula realizada com sucesso para " + nomeAlunoMatriculado + "!");
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) System.out.println("CURSO NÃO ENCONTRADO!");
                    break;
                }
                
                case 4: {
                    System.out.println("\n>>> REALIZAR MATRÍCULA COM DESCONTO <<<");
                    if (cursos.isEmpty()) {
                        System.out.println("NENHUM CURSO DISPONIVEL!");
                        break;
                    }
                    if (nomeAlunoMatriculado.isEmpty()) {
                        System.out.println("Cadastre o nome do aluno primeiro (Opção 2)!");
                        break;
                    }
                    
                    System.out.print("Informe o código do curso: ");
                    int codigoBusca = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Curso c : cursos) {
                        if (c.getCodigo() == codigoBusca) {
                            System.out.print("Informe o desconto (em %): ");
                            double desconto = sc.nextDouble();
                            sc.nextLine();
                            
                            valorMatriculaFinal = c.realizarMatricula(desconto);
                            cursoMatriculado = c;
                            matriculaAtiva = true;
                            System.out.println("\nMatrícula com desconto realizada com sucesso para " + nomeAlunoMatriculado + "!");
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) System.out.println("CURSO NÃO ENCONTRADO!");
                    break;
                }
                
                case 5: {
                    System.out.println("\n<<<<< DADOS DOS CURSOS >>>>>");
                    if (cursos.isEmpty()) {
                        System.out.println("NENHUM CURSO DISPONIVEL!");
                    } else {
                        for (Curso c : cursos) {
                            System.out.println("---------------------------");
                            System.out.println(c.exibirDados());
                        }
                    }
                    break;
                }
                
                case 6: {
                    System.out.println("\n<<<<< DADOS DA MATRÍCULA >>>>>");
                    if (matriculaAtiva && cursoMatriculado != null) {
                        System.out.println("Aluno: " + nomeAlunoMatriculado);
                        System.out.println("Curso: " + cursoMatriculado.getNome());
                        System.out.printf("Valor Pago: R$ %.2f\n", valorMatriculaFinal);
                    } else {
                        System.out.println("NENHUMA MATRICULA REGISTRADA!");
                    }
                    break;
                }
                
                case 0: {
                    System.out.println("FUI.......");
                    sc.close();
                    return;
                }
                
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        }
    }
}
