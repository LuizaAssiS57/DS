import java.util.Scanner;

public class GestaoReservas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int MAX_RESERVAS = 25;
        int qtdQuartos = 0;

        while (qtdQuartos <= 0 || qtdQuartos > 5) {
            System.out.println("Informe a quantidade de quartos disponíveis no hotel (máximo 5): ");
            qtdQuartos = sc.nextInt();
            if (qtdQuartos <= 0 || qtdQuartos > 5) {
                System.out.println("Quantidade inválida! O hotel pode possuir de 1 a 5 quartos.");
            }
        }
        sc.nextLine();

        String[] quartos = new String[qtdQuartos];
        int[] camas = new int[qtdQuartos];
        
        String[] reservasHospede = new String[MAX_RESERVAS];
        String[] reservasQuarto = new String[MAX_RESERVAS];
        
        int totalReservas = 0;
        int op;

        do {
            System.out.println("\n===== MENU DO SISTEMA SUNSTAY =====");
            System.out.println("1 - Registrar número dos quartos");
            System.out.println("2 - Registrar quantidade de camas");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Consultar reservas por quarto");
            System.out.println("5 - Consultar reservas por hóspede");
            System.out.println("0 - Encerrar sistema");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.println("\n--- REGISTRAR QUARTOS ---");
                    for (int i = 0; i < qtdQuartos; i++) {
                        System.out.print("Informe a identificação do " + (i + 1) + "º quarto (Ex: Quarto 101): ");
                        quartos[i] = sc.nextLine();
                    }
                    System.out.println("Quartos registrados com sucesso!");
                    break;

                case 2:
                    if (quartos[0] == null) {
                        System.out.println("Por favor, registre os quartos primeiro (Opção 1)!");
                        break;
                    }
                    System.out.println("\n--- REGISTRAR CAMAS ---");
                    for (int i = 0; i < qtdQuartos; i++) {
                        System.out.print("Quantidade de camas disponíveis no " + quartos[i] + ": ");
                        camas[i] = sc.nextInt();
                    }
                    sc.nextLine(); 
                    System.out.println("Camas registradas com sucesso!");
                    break;

                case 3:
                    if (totalReservas >= MAX_RESERVAS) {
                        System.out.println("O limite de 25 reservas totais já foi atingido!");
                        break;
                    }
                    
                    System.out.print("\nInforme o número do quarto para reserva: ");
                    String numeroQuarto = sc.nextLine();
                    
                    int posQuarto = -1;
                    for (int i = 0; i < qtdQuartos; i++) {
                        if (quartos[i] != null && quartos[i].equalsIgnoreCase(numeroQuarto)) {
                            posQuarto = i;
                            break;
                        }
                    }

                    if (posQuarto == -1) {
                        System.out.println("Este quarto não existe!");
                    } else if (camas[posQuarto] == 0) {
                        System.out.println("Não há camas disponíveis neste quarto!");
                    } else {
                        System.out.print("Informe o nome do hóspede: ");
                        String nomeHospede = sc.nextLine();
                        
                        reservasHospede[totalReservas] = nomeHospede;
                        reservasQuarto[totalReservas] = quartos[posQuarto];

                        camas[posQuarto]--;
                        totalReservas++;
                        
                        System.out.println("Reserva realizada com sucesso!");
                    }
                    break;

                case 4:
                    System.out.print("\nInforme o número do quarto: ");
                    String buscaQuarto = sc.nextLine();
                    
                    int quartoExiste = 0; 
                    for (int i = 0; i < qtdQuartos; i++) {
                        if (quartos[i] != null && quartos[i].equalsIgnoreCase(buscaQuarto)) {
                            quartoExiste = 1; 
                            break;
                        }
                    }

                    if (quartoExiste == 0) {
                        System.out.println("Este quarto não existe!");
                    } else {
                        int qtdReservasQuarto = 0; 
                        System.out.println("Hóspedes no " + buscaQuarto + ":");
                        for (int i = 0; i < totalReservas; i++) {
                            if (reservasQuarto[i].equalsIgnoreCase(buscaQuarto)) {
                                System.out.println("- " + reservasHospede[i]);
                                qtdReservasQuarto++;
                            }
                        }
                        
                        if (qtdReservasQuarto == 0) {
                            System.out.println("Não há reservas para este quarto!");
                        }
                    }
                    break;

                case 5:
                    System.out.print("\nInforme o nome do hóspede: ");
                    String buscaHospede = sc.nextLine();
                    
                    int qtdReservasHospede = 0; 
                    System.out.println("Reservas de " + buscaHospede + ":");
                    for (int i = 0; i < totalReservas; i++) {
                        if (reservasHospede[i].equalsIgnoreCase(buscaHospede)) {
                            System.out.println("- " + reservasQuarto[i]);
                            qtdReservasHospede++;
                        }
                    }
                    
                    if (qtdReservasHospede == 0) {
                        System.out.println("Não há reservas para este hóspede!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema SunStay!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
        
        sc.close();
    }
}