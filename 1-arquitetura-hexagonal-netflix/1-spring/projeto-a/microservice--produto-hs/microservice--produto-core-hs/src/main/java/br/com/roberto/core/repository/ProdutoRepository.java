package br.com.roberto.core.repository;

import br.com.roberto.dominio.Produto;

import java.util.List;

public interface ProdutoRepository {

    List<Produto> getTodosProdutos();
    Produto getProdutoById(Long id);
    Produto criaProduto(Produto produto);
    Produto atualizaProduto(Long id, Produto produto);
    void deletaProduto(Long id);
}
