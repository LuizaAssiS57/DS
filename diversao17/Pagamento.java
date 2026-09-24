package diversao17;

public interface  Pagamento {

    // dinheiro
    void realizarPagamento(double valor);

    // PIX
    void realizarPagamento(double valor, String chavePix);

    // cartão
    void realizarPagamento(double valor, int parcelas);
}
