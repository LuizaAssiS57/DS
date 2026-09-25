package avaliacoes.avaliacao1;

import java.util.Scanner;

public class SweetFlight2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxAvioes = 4;
        int maxReservas = 20;

        int[] numeroAvioes = new int[maxAvioes];
        int[] assentosDisponiveis = new int[maxAvioes];

        String[] passageiros = new String[maxReservas];
        int[] aviaoReserva = new int[maxReservas];

        int quantidadeAvioes = 0;
        int totalReservas = 0;

        boolean avioesCadastrados = false;
        boolean assentosCadastrados = false;

        int op = 0;

        while (op != 8) {
            System.out.println("\n=========================================");
            System.out.println("     SWEET FLIGHT – SISTEMA DE RESERVAS   ");
            System.out.println("=========================================");
            System.out.println("1 - Cadastrar aviões");
            System.out.println("2 - Cadastrar quantidade de assentos");
            System.out.println("3 - Listar aviões");
            System.out.println("4 - Realizar reserva");
            System.out.println("5 - Consultar reservas de um avião");
            System.out.println("6 - Pesquisar passageiro");
            System.out.println("7 - Mostrar resumo");
            System.out.println("8 - Sair");
            System.out.print("\nEscolha uma opção: ");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\n===== CADASTRAR AVIÕES =====");
                    System.out.print("Informe a quantidade de aviões que deseja cadastrar (1 a 4): ");
                    quantidadeAvioes = sc.nextInt();

                    while (quantidadeAvioes < 1 || quantidadeAvioes > 4) {
                        System.out.print("Quantidade inválida! Digite um valor entre 1 e 4: ");
                        quantidadeAvioes = sc.nextInt();
                    }

                    for (int i = 0; i < quantidadeAvioes; i++) {
                        boolean duplicado;
                        int num;
                        do {
                            duplicado = false;
                            System.out.print("Informe o número do " + (i + 1) + "º avião: ");
                            num = sc.nextInt();

                            for (int j = 0; j < i; j++) {
                                if (numeroAvioes[j] == num) {
                                    System.out.println("Já existe um avião cadastrado com esse número! Tente outro.");
                                    duplicado = true;
                                    break;
                                }
                            }
                        } while (duplicado);

                        numeroAvioes[i] = num;
                    }

                    avioesCadastrados = true;
                    assentosCadastrados = false;
                    System.out.println("Aviões cadastrados com sucesso!");
                    break;

                case 2:
                    if (!avioesCadastrados) {
                        System.out.println("É preciso cadastrar os aviões primeiro!");
                    } else {
                        System.out.println("\n===== CADASTRAR QUANTIDADE DE ASSENTOS =====");
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            System.out.print("Informe a quantidade de assentos para o avião " + numeroAvioes[i] + " (0 a 20): ");
                            int assentos = sc.nextInt();

                            while (assentos < 0 || assentos > 20) {
                                System.out.print("Quantidade inválida! Digite um valor entre 0 e 20: ");
                                assentos = sc.nextInt();
                            }

                            assentosDisponiveis[i] = assentos;
                        }

                        assentosCadastrados = true;
                        System.out.println("Assentos cadastrados com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("\n===== LISTAR AVIÕES =====");
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            System.out.println("Avião: " + numeroAvioes[i] + " | Assentos disponíveis: " + assentosDisponiveis[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n===== REALIZAR RESERVA =====");
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else if (!assentosCadastrados) {
                        System.out.println("Cadastre primeiro a quantidade de assentos!");
                    } else if (totalReservas >= maxReservas) {
                        System.out.println("Limite máximo de 20 reservas atingido!");
                    } else {
                        System.out.print("Informe o número do avião desejado: ");
                        int numeroAviao = sc.nextInt();
                        sc.nextLine();

                        int posicaoAviao = -1;
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            if (numeroAvioes[i] == numeroAviao) {
                                posicaoAviao = i;
                                break;
                            }
                        }

                        if (posicaoAviao == -1) {
                            System.out.println("Este avião não existe!");
                        } else if (assentosDisponiveis[posicaoAviao] <= 0) {
                            System.out.println("Não há assentos disponíveis para este avião!");
                        } else {
                            System.out.print("Informe o nome do passageiro: ");
                            String nome = sc.nextLine();

                            while (nome.trim().isEmpty()) {
                                System.out.print("O nome não pode ficar vazio! Informe o nome do passageiro: ");
                                nome = sc.nextLine();
                            }

                            passageiros[totalReservas] = nome;
                            aviaoReserva[totalReservas] = numeroAviao;

                            assentosDisponiveis[posicaoAviao]--;
                            totalReservas++;

                            System.out.println("Reserva realizada com sucesso!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\n===== CONSULTAR RESERVAS DE UM AVIÃO =====");
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        System.out.print("Informe o número do avião: ");
                        int numeroAviaoConsulta = sc.nextInt();

                        boolean existeAviao = false;
                        for (int i = 0; i < quantidadeAvioes; i++) {
                            if (numeroAvioes[i] == numeroAviaoConsulta) {
                                existeAviao = true;
                                break;
                            }
                        }

                        if (!existeAviao) {
                            System.out.println("Este avião não existe!");
                        } else {
                            boolean encontrouReserva = false;
                            System.out.println("Passageiros com reserva no avião " + numeroAviaoConsulta + ":");

                            for (int i = 0; i < totalReservas; i++) {
                                if (aviaoReserva[i] == numeroAviaoConsulta) {
                                    System.out.println("- " + passageiros[i]);
                                    encontrouReserva = true;
                                }
                            }

                            if (!encontrouReserva) {
                                System.out.println("Não há reservas realizadas para este avião!");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n===== PESQUISAR PASSAGEIRO =====");
                    System.out.print("Informe o nome do passageiro: ");
                    String buscaPassageiro = sc.nextLine();

                    boolean encontrouPassageiro = false;

                    for (int i = 0; i < totalReservas; i++) {
                        if (passageiros[i].equalsIgnoreCase(buscaPassageiro)) {
                            if (!encontrouPassageiro) {
                                System.out.println("Reservas encontradas para " + buscaPassageiro + ":");
                            }
                            System.out.println("- Avião: " + aviaoReserva[i]);
                            encontrouPassageiro = true;
                        }
                    }

                    if (!encontrouPassageiro) {
                        System.out.println("Não há reservas realizadas para este passageiro!");
                    }
                    break;

                case 7:
                    System.out.println("\n===== MOSTRAR RESUMO =====");
                    if (!avioesCadastrados) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        int totalAssentosDisponiveis = 0;
                        int avioesComAssentos = 0;
                        int avioesSemAssentos = 0;
                        int aviaoMaiorAssentos = numeroAvioes[0];
                        int maxAssentos = assentosDisponiveis[0];

                        for (int i = 0; i < quantidadeAvioes; i++) {
                            totalAssentosDisponiveis += assentosDisponiveis[i];

                            if (assentosDisponiveis[i] > 0) {
                                avioesComAssentos++;
                            } else {
                                avioesSemAssentos++;
                            }

                            if (assentosDisponiveis[i] > maxAssentos) {
                                maxAssentos = assentosDisponiveis[i];
                                aviaoMaiorAssentos = numeroAvioes[i];
                            }
                        }

                        System.out.println("Quantidade de aviões cadastrados: " + quantidadeAvioes);
                        System.out.println("Quantidade total de reservas realizadas: " + totalReservas);
                        System.out.println("Quantidade total de assentos disponíveis: " + totalAssentosDisponiveis);
                        System.out.println("Quantidade de aviões com assentos disponíveis: " + avioesComAssentos);
                        System.out.println("Quantidade de aviões sem assentos disponíveis: " + avioesSemAssentos);
                        System.out.println("Avião com maior quantidade de assentos disponíveis: " + aviaoMaiorAssentos + " (" + maxAssentos + " assentos)");
                    }
                    break;

                case 8:
                    System.out.println("Sistema encerrado. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        sc.close();
    }
}
