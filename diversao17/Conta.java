package diversao17;

public class Conta {
    
    private int numero;
    private String titular;
    private double saldo;
    private Agencia agencia;
    
	public Conta(int numero, String titular, double saldo, Agencia agencia) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito realizado com sucesso! Novo saldo: R$ %.2f\n", saldo);
        }else {
            System.out.println("Não é possivel depositar um valor menor ou igual a 0");
        }
    }

    public void consultarSaldo(){
        System.out.printf("Saldo disponivel: R$ %.2f", saldo);
    }

    public void mostrarDadosConta(){
        System.out.println("\n=== DADOS DA CONTA ===");
        agencia.mostrarDadosAgencia();
        System.out.println("Conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
        System.out.println("=========================");
    }
    
}
