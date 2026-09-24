package diversao16;

import java.util.ArrayList;
import java.util.Scanner;

public class VeiculoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        while (true) {
            System.out.println("\n<<<>>> SISTEMA DE LOCAÇÃO DE VEÍCULOS <<<>>>");
            System.out.println("1 - CADASTRAR CARRO");
            System.out.println("2 - CADASTRAR MOTO");
            System.out.println("3 - MOSTRAR DADOS DOS VEÍCULOS");
            System.out.println("4 - CALCULAR VALOR DO ALUGUEL");
            System.out.println("5 - CALCULAR ALUGUEL COM DESCONTO");
            System.out.println("0 - SAIR");
            System.out.println("<<<<<<<<>>>>>>><<<<<<<<<>>>>>>>>>");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            
            int op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1: {
                    System.out.println("\n>>> CADASTRAR CARRO <<<");
                    System.out.print("Informe a placa: ");
                    String placa = sc.nextLine();
                    
                    System.out.print("Informe o modelo: ");
                    String modelo = sc.nextLine();
                    
                    System.out.print("Informe o ano: ");
                    int ano = sc.nextInt();
                    
                    System.out.print("Valor da diária: R$ ");
                    double valorDiaria = sc.nextDouble();
                    sc.nextLine();

                    veiculos.add(new Carro(placa, modelo, ano, valorDiaria));
                    System.out.println("Carro cadastrado com sucesso!");
                    break;
                }
                case 2: {
                    System.out.println("\n>>> CADASTRAR MOTO <<<");
                    System.out.print("Informe a placa: ");
                    String placa = sc.nextLine();
                    
                    System.out.print("Informe o modelo: ");
                    String modelo = sc.nextLine();
                    
                    System.out.print("Informe o ano: ");
                    int ano = sc.nextInt();
                    
                    System.out.print("Valor da diária: R$ ");
                    double valorDiaria = sc.nextDouble();
                    sc.nextLine();

                    veiculos.add(new Moto(placa, modelo, ano, valorDiaria));
                    System.out.println("Moto cadastrada com sucesso!");
                    break;
                }
                case 3: {
                    System.out.println("\n<<<<< DADOS DOS VEÍCULOS >>>>>");
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado!");
                    } else {
                        for (int i = 0; i < veiculos.size(); i++) {
                            System.out.println("---------------------------");
                            System.out.println(veiculos.get(i).exibirDados());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("\n>>> CALCULAR ALUGUEL <<<");
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado!");
                        break;
                    }
                    
                    System.out.print("Informe a placa do veículo: ");
                    String placaBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Veiculo v : veiculos) {
                        if (v.getPlaca().equalsIgnoreCase(placaBusca)) {
                            System.out.print("Informe a quantidade de dias: ");
                            int dias = sc.nextInt();
                            sc.nextLine();
                            
                            double total = v.calcularAluguel(dias);
                            System.out.printf("O valor do aluguel para %d dias será de R$ %.2f\n", dias, total);
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Veículo com essa placa não encontrado.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("\n>>> CALCULAR ALUGUEL COM DESCONTO <<<");
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado!");
                        break;
                    }
                    
                    System.out.print("Informe a placa do veículo: ");
                    String placaBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Veiculo v : veiculos) {
                        if (v.getPlaca().equalsIgnoreCase(placaBusca)) {
                            System.out.print("Informe a quantidade de dias: ");
                            int dias = sc.nextInt();
                            
                            System.out.print("Informe o valor do desconto: R$ ");
                            double desconto = sc.nextDouble();
                            sc.nextLine();
                            
                            double totalFinal = v.calcularAluguel(dias, desconto);
                            System.out.printf("O valor final com desconto será de R$ %.2f\n", totalFinal);
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Veículo com essa placa não encontrado.");
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
