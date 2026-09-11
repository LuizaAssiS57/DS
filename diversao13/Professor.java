package diversao13;

public class Professor extends Funcionario{
    private String disciplina;

    public Professor(String nome, double salario, String disciplina){
        super(nome, salario);
        this.disciplina = disciplina;
    }

    public String getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Disciplina: "+ disciplina);
    }
}
