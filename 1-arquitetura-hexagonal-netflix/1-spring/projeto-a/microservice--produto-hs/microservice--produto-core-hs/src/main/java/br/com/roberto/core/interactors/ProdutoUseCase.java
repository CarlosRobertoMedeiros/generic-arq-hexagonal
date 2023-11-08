package br.com.roberto.core.interactors;

import br.com.roberto.core.interactors.dto.input.ProdutoDtoInput;
import br.com.roberto.core.interactors.dto.output.ProdutoDtoOutput;

import java.util.List;

public interface ProdutoUseCase {

    List<ProdutoDtoOutput> getTodosProdutos();
    ProdutoDtoOutput getProdutoById(Long id);
    ProdutoDtoOutput criaProduto(ProdutoDtoInput produtoDtoInput);
    ProdutoDtoOutput atualizaProduto(Long id, ProdutoDtoInput produtoDtoInput);
    void deletaProduto(Long id);
}
