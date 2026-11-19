package br.com.api.produtos.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.model.ProdutoModelo;
import br.com.api.produtos.model.RespostaModelo;
import br.com.api.produtos.repository.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    private final ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Iterable<ProdutoModelo> listar(){
        return repositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produto, String acao){
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return ResponseEntity.badRequest().body(criarResposta("O nome do produto é obrigatório"));
        }

        if (produto.getMarca() == null || produto.getMarca().isBlank()) {
            return ResponseEntity.badRequest().body(criarResposta("O nome da marca é obrigatório"));
        }

        ProdutoModelo produtoSalvo = repositorio.save(produto);

        if ("cadastrar".equals(acao)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
        }
        return ResponseEntity.ok(produtoSalvo);
    }

    public ResponseEntity<RespostaModelo> remover(long codigo){
        repositorio.deleteById(codigo);
        return ResponseEntity.ok(criarResposta("O produto foi removido"));
    }

    private RespostaModelo criarResposta(String mensagem){
        RespostaModelo resposta = new RespostaModelo();
        resposta.setMensagem(mensagem);
        return resposta;
    }
}
