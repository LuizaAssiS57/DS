package diversao16.atividade2;

public abstract class Veiculo implements Aluguel{
    
    private String placa;
    private String modelo;
    private int ano;
    private double valorDiaria;
    
	public Veiculo(String placa, String modelo, int ano, double valorDiaria) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valorDiaria = valorDiaria;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

    public String exibirDados(){
        return "Placa: " + placa + "\nModelo: " + modelo + "\nAno: " + ano + "\nValor da diária: R$ " + valorDiaria;
    }

    
}
