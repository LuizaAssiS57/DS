package diversao12;

public class Veiculo {
    private String marca;
    private String ano;

    public Veiculo(String marca, String ano){
        this.marca = marca;
        this.ano = ano;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getAno(){
        return ano;
    }

    public void setAno(String ano){
        this.ano = ano;
    }

    public void exibirDados(){
        System.out.println("Marca: "+ marca);
        System.out.println("Ano: "+ ano);
    }
}
