package poo;

public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(String nome, String endereco, String cpf){
        super(nome, endereco);
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("CPF: "+cpf);
    }
}
