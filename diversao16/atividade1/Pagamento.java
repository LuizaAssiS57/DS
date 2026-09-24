package diversao16.atividade1;

public interface Pagamento {
    
    double calcPagamento();

    // Sobrecarga do método
    double calcPagamento(double bonus);
}
