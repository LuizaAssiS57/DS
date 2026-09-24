package diversao16.atividade4;

public class CursoOnline extends Curso{
    
    private String enderecoPlataforma;
    private String codigoAcesso;

	public CursoOnline(int codigo, String nome, int cargaHoraria, double valor, String enderecoPlataforma, String codigoAcesso) {
		super(codigo, nome, cargaHoraria, valor);
		this.enderecoPlataforma = enderecoPlataforma;
		this.codigoAcesso = codigoAcesso;
	}

	public String getEnderecoPlataforma() {
		return enderecoPlataforma;
	}

	public void setEnderecoPlataforma(String enderecoPlataforma) {
		this.enderecoPlataforma = enderecoPlataforma;
	}

	public String getCodigoAcesso() {
		return codigoAcesso;
	}

	public void setCodigoAcesso(String codigoAcesso) {
		this.codigoAcesso = codigoAcesso;
	}

	@Override
	public double realizarMatricula() {
        return getValor();
	}
    
	@Override
	public double realizarMatricula(double descontoPercetual) {
        double valorDesconto = getValor() * (descontoPercetual / 100.0);
        return getValor() - valorDesconto;
	}
    
    @Override
    public String exibirDados() {
        return super.exibirDados() + "\nTipo: Online\nPlataforma: " + enderecoPlataforma + "\nCódigo de acesso: " + codigoAcesso + "\n";
    }

}
