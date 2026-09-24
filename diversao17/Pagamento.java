package diversao17;

public interface  Pagamento {

    // dinheiro
    void fazerPagamento(double valor);

    // PIX
    void fazerPagamento(double valor, String chavePix);

    // cartão
    void fazerPagamento(double valor, int parcelas);
}
