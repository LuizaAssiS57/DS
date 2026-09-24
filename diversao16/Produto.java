package diversao16;

public abstract class Produto implements Venda{
    
    private int codigo;
    private String nome;
    private double preco;
    
	public Produto(int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

    public String exibirDados(){
        return "Código: " + codigo + "\nNome: " + nome + "\nPreço unitário: R$ " + preco;
    }

    
}
