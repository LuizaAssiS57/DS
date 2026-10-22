package controle;

import dao.UsuarioDAO;

public class LoginControle {
    
    private UsuarioDAO dao;

    public LoginControle() {
        this.dao = new UsuarioDAO();
    }

    public boolean autenticar(String usuario, String senha) {
        return dao.autenticar(usuario, senha);
    }
}
