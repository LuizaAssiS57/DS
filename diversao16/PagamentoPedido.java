package diversao16;

public interface PagamentoPedido {
    
    void realizarPagamento(double valor);

    void realizarPagamento(double valor, String chavePix);

    void realizarPagamento(double valor, int parcelas);
}
