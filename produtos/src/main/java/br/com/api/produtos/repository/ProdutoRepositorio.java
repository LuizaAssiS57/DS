package br.com.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.produtos.model.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long>{
    
}
