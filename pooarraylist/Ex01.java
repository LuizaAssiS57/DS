package pooarraylist;

import java.util.ArrayList;

public class Ex01 {
    public static void main(String[] args) {
        
        ArrayList<String> nomes = new ArrayList<>();

        //ADICIONAR
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Marcos");

        // LISTAR
        System.out.println("LISTA");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        //ALTERAR
        nomes.set(1, "Edivandecidecleide");
        System.out.println("LISTA APÓS ALTERAR");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        //REMOVER
        nomes.remove(0);
        System.out.println("LISTA APÓS REMOVER");
        for (String nome : nomes) {
            System.out.println(nome);
        }

    }
}
