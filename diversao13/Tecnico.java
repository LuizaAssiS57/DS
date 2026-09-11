package diversao13;

public class Tecnico extends Funcionario{
    private String setor;

    public Tecnico(String nome, double salario, String setor){
        super(nome, salario);
        this.setor = setor;
    }

    public String getSetor(){
        return setor;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Setor: "+ setor);
    }
}
