package diversao21;

public class Carro extends Veiculo{

    public Carro(String marca, String modelo, String ano) {
        super(marca, modelo, ano);
    }
    
    @Override
    public String exibirDetalhes(){
        return super.exibirDetalhes() + "TIPO: CARRO";
    }
}
