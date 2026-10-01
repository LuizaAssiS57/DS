package diversao19;

public class Conta {
    
    private String titular;
    private String numeroConta;
    private double saldo;
    
    public Conta(String titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return titular;
    }

    public void setNomeTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String mostrarDadosConta() {
        return "Número: " + numeroConta + " | Titular: " + titular + " | Saldo: R$ " + saldo;
    }

}
