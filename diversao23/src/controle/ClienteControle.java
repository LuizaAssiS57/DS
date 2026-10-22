package controle;

import java.util.ArrayList;

import dao.ClienteDao;
import modelo.Cliente;

public class ClienteControle {
    
    private ClienteDao dao;

    public ClienteControle(){
        dao = new ClienteDao();
    }

    public void cadastrar(int codigo, String nome, String telefone, String email){
        
        Cliente cliente = new Cliente(codigo, nome, telefone, email);
        dao.cadastrar(cliente);
    }

    public ArrayList<Cliente> listar(){
        return dao.listar();
    }

    public Cliente buscar(int codigo) {
        return dao.buscar(codigo);
    }

    public boolean alterar(int codigo, String nome, String telefone, String email){
        return dao.alterar(codigo, nome, telefone, email);
    }

    public boolean remover(int codigo){
        return dao.remover(codigo);
    }
}
