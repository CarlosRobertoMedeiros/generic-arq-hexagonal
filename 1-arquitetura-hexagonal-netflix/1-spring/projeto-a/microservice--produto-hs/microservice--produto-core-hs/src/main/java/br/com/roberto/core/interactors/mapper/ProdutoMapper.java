package br.com.roberto.core.interactors.mapper;

import br.com.roberto.dominio.Produto;
import br.com.roberto.core.interactors.dto.input.ProdutoDtoInput;
import br.com.roberto.core.interactors.dto.output.ProdutoDtoOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper( ProdutoMapper.class );

    ProdutoDtoOutput produtoDtoInputToprodutoDtoOutPut(Produto produto);
    Produto produtoToProdutoDtoInput(ProdutoDtoInput produtoDtoInput);

    List<ProdutoDtoOutput> listProdutoDtoInputToListProdutoDtoOutPut(List<Produto> produtos);

}
