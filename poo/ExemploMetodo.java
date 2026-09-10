package poo;

public class ExemploMetodo {

    //sem parâmetro e sem retorno
    public static void mensagem() {
        System.out.println("Seja bem vindo");
    }

    //com parâmetro e sem retorno
    public static void mostrarNome(String nome) {
        System.out.println("Nome: "+ nome);
    }

    //sem parâmetro e com retorno
    public static int obterNumero() {
        return 10;
    }

    //com parâmetro e com retorno
    public static int somar(int n1, int n2) {
        return n1 + n2;
    }

    public static void main(String[] args) {
        mensagem();
        mostrarNome("carlos");
        int numero = obterNumero();
        System.out.println("Número: "+ numero);
        int resultado = somar(10, 5);
        System.out.println("Soma: "+ resultado);
    }
}
