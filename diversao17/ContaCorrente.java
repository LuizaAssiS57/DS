package diversao17;

public class ContaCorrente extends Conta implements Pagamento{

	public ContaCorrente(int numero, String titular, double saldo, Agencia agencia) {
		super(numero, titular, saldo, agencia);
	}

    // Pagamento em dinheiro
	@Override
	public void realizarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do pagamento deve ser maior que 0");
            return;
        }

        if (getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        setSaldo(getSaldo() - valor);
        System.out.printf("Pagamento em dinheiro realizado! Novo saldo: R$ %.2f\n", getSaldo());
	}

    // Pagamento via PIX
	@Override
	public void realizarPagamento(double valor, String chavePix) {
        if (valor <= 0) {
            System.out.println("O valor do pagamento deve ser maior que 0");
            return;
        }

        if (getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        setSaldo(getSaldo() - valor);
        System.out.printf("Pagamento via PIX (chave: %s) realizado! Novo saldo: R$ %.2f\n", getSaldo());
	}

    // Pagamento via cartão
	@Override
	public void realizarPagamento(double valor, int parcelas) {

        if (valor <= 0) {
            System.out.println("O valor do pagamento deve ser maior que 0");
            return;
        }

        if (parcelas <= 0) {
            System.out.println("A quantidade de parcelas deve ser maior que 0");
            return;
        }

        if (getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        double valorParcela = valor / parcelas;
        setSaldo(getSaldo() - valor);

        System.out.printf("Pagamento no cartão aprovado!\nValor total: R$ %.2f | %dx de R$ %.2f\n", valor, parcelas, valorParcela);
        System.out.printf("Novo saldo: R$ %.2f\n", getSaldo());
	}
    
    
}
