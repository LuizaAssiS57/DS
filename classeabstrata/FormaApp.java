package classeabstrata;

public class FormaApp {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);
        Retangulo retangulo = new Retangulo(4, 6);
        System.out.println("Área do circulo: " + circulo.CalcularArea());
        System.out.println("Área do retangulo: " + retangulo.CalcularArea());
    }
}
