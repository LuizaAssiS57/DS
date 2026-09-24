package diversao16;

public class ProdutoDigital extends Produto{

	public ProdutoDigital(int codigo, String nome, double preco) {
		super(codigo, nome, preco);
	}

    
	@Override
	public double realizarVenda(int quantidade) {
        return getPreco() * quantidade;
	}
    
	@Override
	public double realizarVenda(int quantidade, double descontoPercetual) {
        double subtotal = getPreco() * quantidade;
        double valorDesconto = subtotal * (descontoPercetual / 100.0);
        return subtotal - valorDesconto;
	}
    
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nTipo: Produto digital (sem frete)\n";
    }
    
}
