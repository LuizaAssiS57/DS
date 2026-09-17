package pooarraylist;

public class Calculadora {

    // Sobrecarga de método, criar metodos com o mesmo nome, porem com assisnaturas diferentes.
    public int somar(int n1, int n2){
        return n1 + n2;
    }

    public int somar(int n1, int n2, int n3){
        return n1 + n2 + n3;
    }

    public double somar(double n1, double n2){
        return n1 + n2;
    }
}
