package dao;

import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioDAO {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAO(){
        usuarios.add(new Usuario("admin", "admin123"));
    }

    public boolean autenticar(String usuario, String senha){
        for(Usuario u : usuarios){
            if(u.getUsuario().equals(usuario) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
