package diversao16.atividade5;

public class PedidoLocal extends Pedido{

	public PedidoLocal(int numeroPedido, String nomeCliente, double valorPedido) {
		super(numeroPedido, nomeCliente, valorPedido);
	}

	@Override
	public void realizarPagamento(double valor) {
        System.out.printf("Pagamento em dinheiro recebido. Valor pago: R$ %.2f\n", valor);
    }
    
	@Override
	public void realizarPagamento(double valor, String chavePix) {
        System.out.printf("Pagamento via PIX recebido. Chave: %s | Valor pago: R$ %.2f\n", chavePix, valor);
    }
    
	@Override
	public void realizarPagamento(double valor, int parcelas) {
        System.out.printf("Pagamento via cartão. Parcelado em %dx | Valor total: R$ %.2f\n", parcelas, valor);
    }
    
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nTipo: Pedido local\n";
    }
    
}
