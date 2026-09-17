package pooarraylist;

public class Cliente extends Pessoa implements Pagamento{

    public Cliente(String nome){
        super(nome);
    }
    
    //SOBRECARGA
    @Override
    public void pagar(double valor){
        System.out.println("Pagamneto realizado: R$ "+ valor);
    }

    public void comprar(String produto){
        System.out.println("Produto comprado: "+produto);
    }

    public void comprar(String produto, int quantidade){
        System.out.println("Produto comprado: "+produto);
        System.out.println("Quantidade: "+quantidade);
    }

    public void comprar(String produto, int quantidade, double valor){
        System.out.println("Produto comprado: "+produto);
        System.out.println("Quantidade: "+quantidade);
        System.out.println("Valor unitário: "+valor);
        System.out.println("Total: R$ "+(quantidade*valor));
    }
}
