package controle;

import java.util.ArrayList;
import dao.ProdutoDAO;
import modelo.Produto;

public class ProdutoControle {
    
    private ProdutoDAO dao;

    public ProdutoControle(){
        dao = new ProdutoDAO();
    }

    public void cadastrar(int id, String nome, String categoria, double preco, int quantidade){
        Produto produto = new Produto(id, nome, categoria, preco, quantidade);
        dao.cadastrar(produto);
    }

    public ArrayList<Produto> listar(){
        return dao.listar();
    }

    public Produto buscar(int id){
        return dao.buscar(id);
    }

    public boolean alterar(int id, String nome, String categoria, double preco, int quantidade){
        return dao.alterar(id, nome, categoria, preco, quantidade);
    }

    public boolean remover(int id){
        return dao.remover(id);
    }
}
