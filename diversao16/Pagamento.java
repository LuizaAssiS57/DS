package diversao16;

public interface Pagamento {
    
    double calcPagamento();

    // Sobrecarga do método
    double calcPagamento(double bonus);
}
