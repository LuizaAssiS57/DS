package diversao14;

public class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void getIdade(int idade){
        this.idade = idade;
    }

    public void exibirInfo(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ idade);
    }
}
