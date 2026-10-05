package exemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        
        try {
            File arquivo = new File("exemplo.txt");
            Scanner sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                System.out.println(linha);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
        }
    }
}
