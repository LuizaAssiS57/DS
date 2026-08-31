import java.util.Scanner;

public class ReservaHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxQuartos = 5;
        int maxReservas = 25;

        int [] numerosQuartos = new int [maxQuartos];
        int [] camasDisponiveis = new int [maxQuartos];

        String [] hospedes = new String[maxReservas];
        int [] quartoReserva = new int[maxReservas];

        int quantidadeQuartos;
        int totalReservas = 0;

        boolean quartosCadastrados = false;
        boolean camasCadastradas = false;

        int opcao;

        System.out.println("Informe a quantidade de quartos disponiveis (máx 5): ");
        quantidadeQuartos = sc.nextInt();
        while (quantidadeQuartos < 1 || quantidadeQuartos > 5) {
            System.out.println("Digite um valor entre 1 e 5: ");
            quantidadeQuartos = sc.nextInt();
        }

        do {
            System.out.println("\n===== MENU DO SISTEMA SUNSTAY =====");
            System.out.println("1 - Registrar número dos quartos");
            System.out.println("2 - Registrar quantidade de camas");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Consultar reservas por quarto");
            System.out.println("5 - Consultar reservas por hóspede");
            System.out.println("6 - Mostrar relatório geral");
            System.out.println("7 - Encerrar sistema");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n----Cadastro dos quartos----");
                    for (int i = 0; i < quantidadeQuartos; i++) {
                        System.out.println("Informe o número do quarto: "+(i+1)+" : ");
                        numerosQuartos[i] = sc.nextInt();
                    }

                    quartosCadastrados = true;
                    System.out.println("Quartos cadastrados com sucesso!");
                    break;
                case 2:
                    if (!quartosCadastrados) {
                        System.out.println("Cadastre primeiro o número dos quartos!");
                    }else{
                        System.out.println("\n-----Cadastro de camas por quarto-----");
                        for (int i = 0; i < quantidadeQuartos; i++) {
                            System.out.println("Informe a quantidade de camas do quarto: "+numerosQuartos[i]+" : ");
                            camasDisponiveis[i] = sc.nextInt();
                        }
                        camasCadastradas = true;
                        System.out.println("Quantidade de camas cadastrada com sucesso!");
                    }
                    break;
                case 3:
                    if (!quartosCadastrados) {
                        System.out.println("Cadastre primeiro o número dos quartos!");
                    }else if(!camasCadastradas){
                        System.out.println("Cadastre as camas disponiveis!");
                    }else if (totalReservas >= maxReservas){
                        System.out.println("Limite total atingido!");
                    }else{
                        int numeroQuarto;
                        int posicaoQuarto = -1;

                        System.out.println("Informe o número do quarto para a reserva: ");
                        numeroQuarto = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < quantidadeQuartos; i++) {
                            if (numerosQuartos[i] == numeroQuarto) {
                                posicaoQuarto = i;
                                break;
                            }
                        }

                        if (posicaoQuarto == -1) {
                            System.out.println("Este quarto não existe!");
                        }else if(camasDisponiveis[posicaoQuarto] <= 0) {
                            System.out.println("Não há camas disponiveis neste quarto!");
                        }else{
                            System.out.println("Informe o nome do hóspede: ");
                            hospedes[totalReservas] = sc.nextLine();
                            quartoReserva[totalReservas] = numeroQuarto;

                            camasDisponiveis[posicaoQuarto]--;
                            totalReservas++;

                            System.out.println("Reserva realizada com sucesso!");
                        }
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
            
                default:
                    break;
            }
        } while (opcao != 7);


        sc.close();
    }
}
