package diversao14;

public class Gato extends Animal{
    private String cor;

    public Gato(String nome, int idade, String cor){
        super(nome, idade);
        this.cor = cor;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Cor: ");
    }

    public void emitirSom(){
        System.out.println("Miau!");
    }
}
