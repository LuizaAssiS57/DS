package exemplos;

import java.io.FileWriter;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        
        try {
            FileWriter fw = new FileWriter("dados.txt");
            fw.write("primeira linha\n");
            fw.write("segunda linha\n");
            fw.close();
            System.out.println("Escrita concluida");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
