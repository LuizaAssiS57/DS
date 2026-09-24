package diversao16;

public class PedidoDelivery extends Pedido{
    
    private String endereco;
    private double taxaEntrega;

	public PedidoDelivery(int numeroPedido, String nomeCliente, double valorPedido, String endereco, double taxaEntrega) {
		super(numeroPedido, nomeCliente, valorPedido);
		this.endereco = endereco;
		this.taxaEntrega = taxaEntrega;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
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
    public String exiirDados() {
        return super.exiirDados() + "\nTipo: Delivery\nEndereço: " + endereco +
        "\nTaxa de entrega: R$ " + String.format("%.2f", taxaEntrega) +
        "\nValor total: R$ " + String.format("%.2f", (getValorPedido() + taxaEntrega)) + "\n";
    }
    
}
