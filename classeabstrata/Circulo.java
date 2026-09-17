package classeabstrata;

public class Circulo extends FormaGeometrica{
    
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double CalcularArea(){
        return Math.PI * raio * raio;
    }
}
