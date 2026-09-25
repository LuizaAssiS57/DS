package avaliacoes.avaliacao1;

import java.util.Scanner;

public class SweetFlight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxAvioes = 4;
        int maxReservas = 20;

        
        int [] numeroAvioes = new int[maxAvioes];
        int [] assentosDisponiveis = new int[maxAvioes];
        
        String [] passageiros = new String[maxReservas];
        int [] assentoReserva = new int[maxReservas]; //
        int [] aviaoReserva = new int[maxReservas];
        
        int quantidadeAvioes = 0;
        // int quantidadeAvioes;
        int totalReservas = 0;

        boolean avioesCadastrados = false;
        boolean assentosCadastrados = false;

        int op;//

        //
        System.out.println("Informe a quantidade de aviões: (máximo 4)");
        while (quantidadeAvioes < 1 || quantidadeAvioes > 4) {
            System.out.println("Quantidade inválida! Digite um valor entre 1 e 4: ");
            quantidadeAvioes = sc.nextInt();
        }//

        //
        do {
            System.out.println("=========================================");
            System.out.println("    SWEET FLIGHT - SISTEMA DE RESERVAS   ");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar aviões");
            System.out.println("2 - Cadastrar quantidade de assentos");
            System.out.println("3 - Listar aviões");
            System.out.println("4 - Realizar reserva");
            System.out.println("5 - Consultar reservas de um avião");
            System.out.println("6 - Pesquisar passageiro");
            System.out.println("7 - Mostrar resumo");
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1://
                    System.out.println("\n===== CADASTRO DE AVIÕES =====");
                    for (int i = 0; i < quantidadeAvioes; i++) {
                        System.out.println("Informe o número do "+(i+1)+"º avião: ");
                        numeroAvioes[i] = sc.nextInt();
                    }

                    avioesCadastrados = true;
                    System.out.println("Aviões cadastrados com sucesso!");
                    break;//
                case 2:
                    if (!avioesCadastrados) {
                        System.out.println("É preciso cadastrar aviões");
                    } else {
                        System.out.println("\n===== CADASTRO DE ASSENTOS =====");
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            System.out.println("Informe a quantidade de assentos "+ numeroAvioes[i]+ " : ");
                            assentosDisponiveis[i] = sc.nextInt();
                        }

                        assentosCadastrados = true;
                        System.out.println("Quantidade de assentos cadastrado com sucesso!");
                        
                    }
                    break;
                case 3:
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            System.out.println((i+1) + " - " + numeroAvioes[i]);
                        }
                        break;
                    }
                    break;
                case 4:
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else if (!assentosCadastrados){
                        System.out.println("Cadastre primeiro a quantidade de assentos!");
                    } else if (totalReservas >= maxReservas) {
                        System.out.println("Limite máximo de reservas atingido!");
                    } else {
                        int numeroAviao;
                        int posicaoAviao = -1 ;

                        System.out.println("Informe o número do avião para reserva: ");
                        numeroAviao = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < quantidadeAvioes; i++) {
                            if (numeroAvioes[i] == numeroAviao) {
                                posicaoAviao = i;
                                break;
                            }
                        }

                        if (posicaoAviao == -1) {
                            System.out.println("Este avião não existe!");
                        } else if (assentosDisponiveis[posicaoAviao] <= 0) {
                            System.out.println("Não há assentos disponiveis!");
                        } else {
                            System.out.println("Informe o nome do passageiro: ");
                            passageiros[totalReservas] = sc.nextLine();
                            assentoReserva[totalReservas] = numeroAviao;

                            assentosDisponiveis[posicaoAviao]--;
                            totalReservas++;
                            
                            System.out.println("Reserva realizada com sucesso!");
                        }
                    }
                    break;
                case 5:
                    if (totalReservas == 0) {
                        System.out.println("Nenhuma reserva foi realizada ainda!");
                    } else {
                        int numeroAviaoConsulta;
                        int posicaoAviaoConsulta = -1;
                        boolean encontrouReserva = false;

                        System.out.println("Informe o número do avião para consulta: ");
                        numeroAviaoConsulta = sc.nextInt();

                        for (int i = 0; i < quantidadeAvioes; i++) {
                            if (numeroAvioes[i] == numeroAviaoConsulta) {
                                posicaoAviaoConsulta = i;
                                break;
                            }
                        }

                        if (posicaoAviaoConsulta == -1) {
                            System.out.println("Este avião não existe!");
                        } else {
                            System.out.println("Reservas do avião "+ numeroAviaoConsulta + " : ");

                            for (int i = 0; i < totalReservas; i++) {
                                if (assentoReserva[i] == numeroAviaoConsulta) {
                                    System.out.println("- " + passageiros[i]);
                                    encontrouReserva = true;
                                }
                            }

                            if (!encontrouReserva) {
                                System.out.println("Não há reservas para este avião!");
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("\nInforme o nome do passageiro: ");
                    String buscaPassageiro = sc.nextLine();

                    int qtdReservasPassageiro = 0;
                    System.out.println("Reservas de "+ buscaPassageiro + " : ");
                    for (int i = 0; i < totalReservas; i++) {
                        if (passageiros[i].equalsIgnoreCase(buscaPassageiro)) {
                            System.out.println("- " + aviaoReserva[i]);
                            qtdReservasPassageiro++;
                        }
                    }

                    if (qtdReservasPassageiro == 0) {
                        System.out.println("Não há reservas para este passageiro!");
                    }
                    break;
                case 7:
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião foi cadastrado ainda!");
                    } else {
                        System.out.println("\n===== RESUMO =====");
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            int contadorReservas = 0;

                            for (int j = 0; j < totalReservas; j++) {
                                if (aviaoReserva[j] == numeroAvioes[i]) {
                                    contadorReservas++;
                                }
                            }

                            System.out.println("Avião: "+ numeroAvioes[i]);
                            System.out.println("Assentos disponiveis: "+ assentosDisponiveis[i]);
                            System.out.println("Quantidade de reservas: " + contadorReservas);
                            System.out.println("+++++++++++++++++++++++++++++");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Sistema encerrado. Até logo!");
                    break;
            
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (op != 8);
        sc.close();
    }
}