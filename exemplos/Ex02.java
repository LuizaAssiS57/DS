package exemplos;

import java.io.FileWriter;

public class Ex02 {
    
    public static void main(String[] args) {
        try {
            FileWriter escritor = new FileWriter("exemplo.txt", true);
            escritor.write("primeiro linha\n");
            escritor.write("segunda linha\n");
            escritor.write("terceira linha\n");

            escritor.close();
            System.out.println("Escrita cocluida");
        } catch (Exception e) {
            System.out.println("Erro ao escrever no arquivo");
            e.printStackTrace();
        }
    }
}
