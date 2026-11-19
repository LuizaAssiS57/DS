package br.com.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.produtos.model.UserModelo;


public interface UserRepositorio extends JpaRepository<UserModelo, Long>{
    
    UserModelo findByUsuario(String usuario);
}
