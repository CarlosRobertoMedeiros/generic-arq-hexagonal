package br.com.roberto.datasource;

import br.com.roberto.core.repository.ProdutoRepository;
import br.com.roberto.dominio.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoDataSource implements ProdutoRepository {

    @Override
    public List<Produto> getTodosProdutos() {
        return null;
    }

    @Override
    public Produto getProdutoById(Long id) {
        return null;
    }

    @Override
    public Produto criaProduto(Produto produto) {
        return null;
    }

    @Override
    public Produto atualizaProduto(Long id, Produto produto) {
        return null;
    }

    @Override
    public void deletaProduto(Long id) {

    }
}
