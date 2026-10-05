package diversao20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Manipulacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op != 6) {
            System.out.println("=====MANIPULAÇÃO DE ARQUIVOS=====");
            System.out.println("1 - CRIAR ARQUIVO");
            System.out.println("2 - ESCREVER NO ARQUIVO");
            System.out.println("3 - LER ARQUIVO");
            System.out.println("4 - ALTERAR ARQUIVO");
            System.out.println("5 - REMOVER ARQUIVO");
            System.out.println("6 - SAIR");
            System.out.println("==================================");
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("=====CRIAR ARQUIVO=====");
                    try {
                        File arquivo = new File("arquivo.txt");
                        if (arquivo.createNewFile()) {
                            System.out.println("ARQUIVO CRIADO " + arquivo.getName());
                        }else{
                            System.out.println("O ARQUIVO JÁ EXISTE!");
                        }
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                    break;
                case 2:
                    try {
                        FileWriter writer = new FileWriter("arquivo.txt");
                        System.out.println("DIGITE O QUE DESEJA ESCREVER: ");
                        String escreva = sc.nextLine();
                        writer.write(escreva);
                        writer.close();
                        System.out.println("CONTEÚDO ESCRITO COM SUCESSO!");
                    } catch (IOException e) {
                        System.out.println("ERRO AO ESCREVER: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
                        String linha;

                        System.out.println("\n CONTEÚDO DO ARQUIVO: ");
                        while ((linha = reader.readLine()) != null) {
                            System.out.println(linha);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("ERRO AO LER: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        FileWriter fw = new FileWriter("arquivo.txt");
                        System.out.println("DIGITE PARA ALTERAR: ");
                        String alterar = sc.nextLine();
                        fw.write(alterar);
                        fw.close();

                        System.out.println("ARQUIVO ALTERADO COM SUCESSO!");
                    } catch (IOException e) {
                        System.out.println("ERRO AO ALTERAR: " + e.getMessage());
                    }
                    
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"));
                        String linha;

                        System.out.println("\n APÓS ALTERAÇÃO:");
                        while ((linha = br.readLine()) != null) {
                            System.out.println(linha);
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("ERRO AO LER: " + e.getMessage());
                    }
                    break;
                case 5:
                    File arquivo = new File("arquivo.txt");
                    if (arquivo.delete()) {
                        System.out.println("ARQUIVO REMOVIDO");
                    }else{
                        System.out.println("ERRO AO REMOVER ARQUIVO");
                    }
                    break;
                case 6:
                    System.out.println("SAINDO...");
                    break;
            
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        }
        sc.close();
    }
}
