package diversao16;

public class FuncionarioCLT extends Funcionario{

    private double salarioMensal;
    
    public FuncionarioCLT(String nome, String cpf, double salarioMensal){
        super(nome, cpf);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcPagamento() {
        return salarioMensal;
    }

    @Override
    public double calcPagamento(double bonus) {
        return salarioMensal + bonus;
    }
    
    @Override
    public String exibirDados(){
        return super.exibirDados() + "\n" + "Tipo: CLT" + "\n" + "Salário: " + salarioMensal + "\n" + "Bônus: "  + calcPagamento(salarioMensal);
    }
}
