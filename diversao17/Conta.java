package diversao17;

public class Conta {
    
    private int numeroConta;
    private String titular;
    protected double saldo;
    private Agencia agencia;
    
	public Conta(int numeroConta, String titular, double saldo, Agencia agencia) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.agencia = agencia;
	}

	public int getNumero() {
		return numeroConta;
	}

	public void setNumero(int numeroConta) {
		this.numeroConta = numeroConta;
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

    public void depositarDinheiro(double valor) {
        if (valor > 0) {
            saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
            System.out.printf("Novo saldo: R$ %.2f%n", saldo);
        }else {
            System.out.println("Não é possivel depositar um valor menor ou igual a 0");
        }
    }

    public void consultarSaldo(){
		System.out.println("++++++ SALDO DISPONIVEL ++++++");
        System.out.printf("R$ %.2f%n", saldo);
		System.out.println("+++++++++++++++++++++++++");
    }

    public void mostrarDadosConta(){
        System.out.println("\n=== DADOS DA CONTA ===");
        agencia.mostrarDadosAgencia();
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("=========================");
    }
    
}