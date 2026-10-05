package exemplos;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        
        try {
            File arquivo = new File("exemplo.com");
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado com sucesso " + arquivo.getName());
            }else{
                System.out.println("Arquivo já existe");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }
}