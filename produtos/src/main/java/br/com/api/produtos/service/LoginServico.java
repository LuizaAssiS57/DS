package br.com.api.produtos.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.model.RespostaModelo;
import br.com.api.produtos.model.UserModelo;
import br.com.api.produtos.repository.UserRepositorio;

@Service
public class LoginServico {
    
    private final UserRepositorio userRepo;

    public LoginServico(UserRepositorio userRepo){
        this.userRepo = userRepo;
    }

    public ResponseEntity<RespostaModelo> login(UserModelo usuarioReq){
        RespostaModelo resposta = new RespostaModelo();

        String usuario = usuarioReq.getUsuario();
        String senha = usuarioReq.getSenha();

        if (usuario == null || usuario.isBlank() || senha == null || senha.isBlank()) {
            resposta.setMensagem("informe o usuário e senha");
            return ResponseEntity.badRequest().body(resposta);
        }

        UserModelo user = userRepo.findByUsuario(usuario);

        if (user == null) {
            resposta.setMensagem("usuário não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
        }

        if (!senha.equals(user.getSenha())) {
            resposta.setMensagem("senha incorreta.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resposta);
        }

        resposta.setMensagem("Loginrealizado com sucesso!");
        return ResponseEntity.ok(resposta);
    }
}
