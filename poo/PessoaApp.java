package poo;

public class PessoaApp {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(1, "Edivanicleide");
        // Pessoa p2 = new Pessoa(2, "Carla");

        //acessador
        System.out.println("Pessoa: "+ p1.getCodigo()+"| Nome: "+p1.getNome());

        // modificador
        p1.setNome("Vanessa");

        System.out.println("Pessoa: "+ p1.getCodigo()+"| Nome: "+p1.getNome());
        
    }
}
