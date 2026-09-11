package diversao12;

public class Moto extends Veiculo{
    private int cilindrada;

    public Moto(String marca, String ano, int cilindrada){
        super(marca, ano);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada(){
        return cilindrada;
    }

    public void setCilindrada(int cilindrada){
        this.cilindrada = cilindrada;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Cilindrada: "+ cilindrada);
    }
}
