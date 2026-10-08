package diversao21;

public class Veiculo {
    
    private String marca;
    private String modelo;
    private String ano;
    
    public Veiculo(String marca, String modelo, String ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String exibirDetalhes(){
        return "INFORMAÇÕES DO VEICULO:" + "\n" + "MARCA: " + marca + "\n" + "MODELO: " + modelo + "\n" + "ANO: " + ano + "\n";
    }

}
