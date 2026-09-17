package classeabstrata;

public class Cachorro extends Animal{
    
    private String raca;

    public Cachorro(){}

    public Cachorro(String nome, int idade, String raca){
        super(nome, idade);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String exibirInfo(){
        return "Cachorro | Nome: " + getNome() + "| Idade: " + getIdade() + "| Raça: " + (raca == null ? "" :raca);
    }
}
