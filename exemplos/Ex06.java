package exemplos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dados.txt", true));
            bw.write("Terceira linha");
            bw.newLine();
            bw.write("Quarta linha");

            bw.close();
            System.out.println("Escrita concluida");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
