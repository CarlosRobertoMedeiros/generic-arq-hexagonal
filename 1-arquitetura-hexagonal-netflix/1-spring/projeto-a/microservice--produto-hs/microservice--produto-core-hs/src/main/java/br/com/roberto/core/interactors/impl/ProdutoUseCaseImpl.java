package br.com.roberto.core.interactors.impl;

import br.com.roberto.core.interactors.ProdutoUseCase;
import br.com.roberto.core.interactors.dto.input.ProdutoDtoInput;
import br.com.roberto.core.interactors.dto.output.ProdutoDtoOutput;
import br.com.roberto.core.interactors.mapper.ProdutoMapper;
import br.com.roberto.core.repository.ProdutoRepository;
import br.com.roberto.dominio.Produto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoUseCaseImpl(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }


    @Override
    public List<ProdutoDtoOutput> getTodosProdutos() {
        List<ProdutoDtoOutput> produtoDtoOutputs = null;
        try {
            List<Produto> todosProdutos = produtoRepository.getTodosProdutos();
            produtoDtoOutputs = produtoMapper.listProdutoDtoInputToListProdutoDtoOutPut(todosProdutos);
        }catch (Exception ex){
            System.out.println("Ajustar o log depois");
        }
        return produtoDtoOutputs;
    }

    @Override
    public ProdutoDtoOutput getProdutoById(Long id) {
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            Produto produtoById = produtoRepository.getProdutoById(id);
            produtoDtoOutput = produtoMapper.produtoDtoInputToprodutoDtoOutPut(produtoById);
        }catch (Exception ex){
            System.out.println("Ajustar o log depois");
        }
        return produtoDtoOutput;
    }

    @Override
    public ProdutoDtoOutput criaProduto(ProdutoDtoInput produtoDtoInput) {
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            Produto produto = produtoMapper.produtoToProdutoDtoInput(produtoDtoInput);
            Produto produtoRetorno = produtoRepository.criaProduto(produto);
            produtoDtoOutput = produtoMapper.produtoDtoInputToprodutoDtoOutPut(produtoRetorno);
        }catch (Exception ex){
            System.out.println("Ajustar o log depois");
        }
        return produtoDtoOutput;
    }

    @Override
    public ProdutoDtoOutput atualizaProduto(Long id, ProdutoDtoInput produtoDtoInput) {
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            Produto produto = produtoMapper.produtoToProdutoDtoInput(produtoDtoInput);
            Produto produtoRetorno = produtoRepository.atualizaProduto(id, produto);
            produtoDtoOutput = produtoMapper.produtoDtoInputToprodutoDtoOutPut(produtoRetorno);
        }catch (Exception ex){
            System.out.println("Ajustar o log depois");
        }
        return produtoDtoOutput;
    }

    @Override
    public void deletaProduto(Long id) {
        produtoRepository.deletaProduto(id);
    }
}
