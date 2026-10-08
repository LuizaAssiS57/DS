package diversao21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> carros = new ArrayList<>();

        boolean executando = true;

        while (executando) {
            String op = JOptionPane.showInputDialog(null, "ESCOLHA UMA OPÇÃO:\n" + "1 - CADASTRAR CARRO\n" + "2 - LISTAR CARROS\n" + "3 - DETALHAR CARRO\n" + "4 - ALTERAR CARRO\n" + "5 - REMOVER CARRO\n" + "6 - GRAVAR INFORMÇÕES EM ARQUIVO\n" + "7 - SAIR", "MENU PRINCIPAL", JOptionPane.QUESTION_MESSAGE);
            if (op == null) {
                JOptionPane.showMessageDialog(null, "OPERAÇÃO CANCELADA");
                break;
            }

            switch (op) {
                case "1":
                    String marca = JOptionPane.showInputDialog(null, "MARCA: ", "CADASTRO DE CARRO", JOptionPane.QUESTION_MESSAGE);
                    String modelo = JOptionPane.showInputDialog(null, "MODELO: ", "CADASTRO DE CARRO", JOptionPane.QUESTION_MESSAGE);
                    String ano = JOptionPane.showInputDialog(null, "ANO: ", "CADASTRO DE CARRO", JOptionPane.QUESTION_MESSAGE);

                    if (marca == null || marca.trim().isEmpty() || modelo == null || modelo.trim().isEmpty() || ano == null || ano.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Carro não cadastrado!");
                    }else{
                        String carroCompleto = marca + " - " + modelo + " - " + ano;
                        carros.add(carroCompleto);
                        JOptionPane.showMessageDialog(null, "CARRO CADASTRADO COM SUCESSO!");
                    }
                    break;
                case "2":
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM CARRO CADASTRADO!");
                    }else{
                        String lista = "CARROS CADASTRADOS\n\n";

                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - " + carros.get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, lista, "LISTA DE VEICULOS", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "3":
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM CARRO CADASTRADO!");
                    } else {
                        String lista = "ESCOLHA O NÚMERO DO CARRO PARA DETALHAR:\n\n";
                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - " + carros.get(i) + "\n";
                        }
                        String num = JOptionPane.showInputDialog(null, lista, "DETALHAR CARRO", JOptionPane.QUESTION_MESSAGE);

                        if (num != null && !num.trim().isEmpty()) {
                            int numero = Integer.parseInt(num) - 1;
                            
                            if (numero >= 0 && numero < carros.size()) {
                                String carroSelecionado = carros.get(numero);
                                String[] dados = carroSelecionado.split(" - ");
                                
                                String detalhes = "DETALHES DO CARRO:\n\n" + "MARCA: " + dados[0] + "\n" + "MODELO: " + dados[1] + "\n" + "ANO: " + dados[2];
                                JOptionPane.showMessageDialog(null, detalhes, "DETALHES", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "NÚMERO INVÁLIDO!");
                            }
                        }
                    }
                    break;
                case "4":
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM CARRO CADASTRADO!");
                    } else {
                        String lista = "ESCOLHA O NÚMERO DO CARRO PARA ALTERAR:\n\n";
                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - " + carros.get(i) + "\n";
                        }
                        String num = JOptionPane.showInputDialog(null, lista, "ALTERAR CARRO", JOptionPane.QUESTION_MESSAGE);

                        if (num != null && !num.trim().isEmpty()) {
                            int numero = Integer.parseInt(num) - 1;

                            if (numero >= 0 && numero < carros.size()) {
                                String carroAntigo = carros.get(numero);
                                String[] dadosAntigos = carroAntigo.split(" - ");

                                String novaMarca = JOptionPane.showInputDialog(null, "NOVA MARCA: ", dadosAntigos[0]);
                                String novoModelo = JOptionPane.showInputDialog(null, "NOVO MODELO: ", dadosAntigos[1]);
                                String novoAno = JOptionPane.showInputDialog(null, "NOVO ANO: ", dadosAntigos[2]);

                                if (novaMarca == null || novaMarca.trim().isEmpty() || novoModelo == null || novoModelo.trim().isEmpty() || novoAno == null || novoAno.trim().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "ALTERAÇÃO CANCELADA!");
                                } else {
                                    String carroAtualizado = novaMarca + " - " + novoModelo + " - " + novoAno;
                                    carros.set(numero, carroAtualizado);
                                    JOptionPane.showMessageDialog(null, "CARRO ALTERADO COM SUCESSO!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "NÚMERO INVÁLIDO!");
                            }
                        }
                    }
                    break;
                case "5":
                    if (carros.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "NENHUM CARRO CADASTRADO!");
                    }else{
                        String lista = "ESCOLHA O NÚMERO DO CARRO:\n\n";
                        for (int i = 0; i < carros.size(); i++) {
                            lista += (i + 1) + " - " + carros.get(i) + "\n";
                        }

                        String num = JOptionPane.showInputDialog(null, lista, "REMOVER CARRO", JOptionPane.QUESTION_MESSAGE);

                        if (num != null && num.trim().isEmpty()) {
                            
                            int numero = Integer.parseInt(num) - 1;
                            String remover = carros.remove(numero);
                            JOptionPane.showMessageDialog(null, "CARRO: " + remover + " REMOVIDO COM SUCESSO!");
                        }
                    }
                    break;
                case "6":
                    try {
                        File arquivo = new File("carros.txt");
                        if (arquivo.createNewFile()) {
                            JOptionPane.showMessageDialog(null, "ARQUIVO CRIADO: " + arquivo.getName());
                        } else {
                            JOptionPane.showMessageDialog(null, "O ARQUIVO JÁ EXISTE");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        FileWriter writer = new FileWriter("carros.txt");
                        
                        for (int i = 0; i < carros.size(); i++) {
                            String carro = carros.get(i);
                            writer.write(carro + "\n");
                        }
                        writer.close();
                        
                        JOptionPane.showMessageDialog(null, "INFORMAÇÕES GRAVADAS COM SUCESSO!");
                        
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "ERRO AO ESCREVER: " + e.getMessage());
                    }

                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "SAINDO...");
                    executando = false;
                    break;
            
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
                    break;
            }
        }
    }
}
