package diversao16.atividade3;

public class ProdutoFisico extends Produto{
    
    private double frete;

	public ProdutoFisico(int codigo, String nome, double preco, double frete) {
		super(codigo, nome, preco);
		this.frete = frete;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}
    
	@Override
	public double realizarVenda(int quantidade) {
        return (getPreco() * quantidade) + frete;
	}
    
	@Override
	public double realizarVenda(int quantidade, double descontoPercetual) {
        double subtotal = getPreco() * quantidade;
        double valorDesconto = subtotal * (descontoPercetual / 100.0);
        return (subtotal - valorDesconto) + frete;
	}
    
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nTipo: Produto fisico\nFrete: R$ " + String.format("%.2f", frete) + "\n";
    }
    
}
