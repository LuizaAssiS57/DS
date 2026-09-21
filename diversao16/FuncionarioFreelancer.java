package diversao16;

public class FuncionarioFreelancer extends Funcionario {

    private double valorHora;
    private int horasTrabalho;
    
    public FuncionarioFreelancer(String nome, String cpf, double valorHora, int horasTrabalho){
        super(nome, cpf);
        this.valorHora = valorHora;
        this.horasTrabalho = horasTrabalho;
        
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    @Override
    public double calcPagamento() {
        return valorHora * horasTrabalho;
    }

    @Override
    public double calcPagamento(double bonus) {
        return (valorHora * horasTrabalho) + bonus;
    }

    @Override
    public String exibirDados(){
        return super.exibirDados() + "\n" + "Tipo: Freelancer" + "\n" + "Horas trabalhadas: " + horasTrabalho + "\n" + "Valor por hora: " + valorHora + "\n" + "";
    }
}
