package diversao15;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroContatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Contato> contatos = new ArrayList<>();

        while (true) {
            System.out.println("<<<<<<< AGENDA DE CONTATOS>>>>>>>");
            System.out.println("1 - CADASTRAR CONTATO PESSOAL");
            System.out.println("2 - CADASTRAR CONTATO PROFISSIONAL");
            System.out.println("3 - LISTAR TODOS OS CONTATO");
            System.out.println("4 - PESQUISAR CONTATO");
            System.out.println("5 - ALTERAR CONTATO");
            System.out.println("6 - EXCLUIR CONTATO");
            System.out.println("7 - SAIR");
            System.out.println("<<<<<<<<<>>>>>>>>>");
            System.out.println("OPÇÃO: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:{
                    System.out.println("INFORME O NOME: ");
                    String nome = sc.nextLine();

                    System.out.println("INFORME O NÚMERO: ");
                    String numero = sc.nextLine();

                    System.out.println("INFORME O PARENTESCO: ");
                    String parentesco = sc.nextLine();

                    contatos.add(new ContatoPessoal(nome, numero, parentesco));
                    System.out.println("CONTATO PESSOAL CADASTRADO!");
                    break;
                }
                case 2:{
                    System.out.println("INFORME O NOME: ");
                    String nome = sc.nextLine();

                    System.out.println("INFORME O NÚMERO: ");
                    String numero = sc.nextLine();

                    System.out.println("INFORME A EMPRESA: ");
                    String empresa = sc.nextLine();

                    System.out.println("INFORME O CARGO: ");
                    String cargo = sc.nextLine();

                    contatos.add(new ContatoProfissional(nome, numero, empresa, cargo));
                    System.out.println("CONTATO PROFISSIONAL CADASTRADO!");
                    break;
                }
                case 3:
                    System.out.println("<<<<<<< LISTA DE CONTATOS >>>>>>");
                    if (contatos.isEmpty()) {
                        System.out.println("NENHUM CONTATO CADASTRADO");
                    } else {
                        for (int i = 0; i < contatos.size(); i++) {
                            System.out.println((i+1) + " - " + contatos.get(i).exibirDados());
                        }
                    }
                    break;
                case 4:
                    System.out.println("INFORME O NOME PARA PERQUISAR: ");
                    if (contatos.isEmpty()) {
                        System.out.println("NENHUM CONTATO CADASTRADO");
                    } else {
                        String busca = sc.nextLine();
    
                        boolean encontrado = false;
                        for (int i = 0; i < contatos.size(); i++) {
                            if (contatos.get(i).getNome().equalsIgnoreCase(busca)) {
                                System.out.println("ENCONTRADO: " + contatos.get(i).exibirDados());
    
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("CONTATO NÃO EMCONTRADO!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n<<<<<<< ALTERAR CONTATO >>>>>>>");
                    if (contatos.isEmpty()) {
                        System.out.println("NENHUM CONTATO CADASTRADO");
                    } else {
                        for (int i = 0; i < contatos.size(); i++) {
                            System.out.println((i + 1) + " - " + contatos.get(i).getNome());
                        }
                    }
                    System.out.println("INFORME O NÚMERO DO CONTATO PARA ALTERAR: ");
                    int pos = sc.nextInt() -1;
                    sc.nextLine();

                    if (pos >= 0 && pos < contatos.size()) {
                        Contato contato = contatos.get(pos);
                        System.out.println("NOVO NOME: ");
                        String novoNome = sc.nextLine();

                        System.out.println("NOVO NÚMERO: ");
                        String novoNumero = sc.nextLine();

                        contato.setNome(novoNome);
                        contato.setNumero(novoNumero);
                        System.out.println("CONTATO ALTERADO COM SUCESSO!");
                    }else{
                        System.out.println("CONTATO INVÁLIDO");
                    }
                    break;
                case 6:
                    System.out.println("\n<<<<<<<<EXCLUIR CONTATO>>>>>>>>>");
                    if (contatos.isEmpty()) {
                        System.out.println("NENHUM CONTATO CADASTRADO");
                    } else {
                        System.out.println("INFORME O NÚMERO DO CONTATO PARA REMOVER: ");
                        int index = sc.nextInt();
                        sc.nextLine();
    
                        if (index > 0 && index <= contatos.size()) {
                            contatos.remove(index-1);
                            System.out.println("CONTATO REMOVIDO");
                        } else {
                            System.out.println("CONTATO INVÁLIDO!");
                        }
                    }
                    break;
                case 7:
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
