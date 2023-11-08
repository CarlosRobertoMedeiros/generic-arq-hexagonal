package br.com.roberto.application.transportlayer.Impl;

import br.com.roberto.core.interactors.ProdutoUseCase;
import br.com.roberto.core.interactors.dto.input.ProdutoDtoInput;
import br.com.roberto.core.interactors.dto.output.ProdutoDtoOutput;
import br.com.roberto.core.interactors.impl.ProdutoUseCaseImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProdutoControllerImpl {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoControllerImpl(ProdutoUseCase produtoUseCase) {
       this.produtoUseCase = produtoUseCase;
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoDtoOutput>> getProdutos(){
        List<ProdutoDtoOutput> todosProdutos = null;
        try {
            todosProdutos = produtoUseCase.getTodosProdutos();
        }catch (Exception e){
            System.out.println("Implementar ainda");
        }
        return ResponseEntity.ok(todosProdutos);
    }

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<ProdutoDtoOutput> getProdutoById(@PathVariable("id") Long id){
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            produtoDtoOutput = produtoUseCase.getProdutoById(id);
        }catch (Exception e){
            System.out.println("Implementar ainda");
        }
        return ResponseEntity.ok(produtoDtoOutput);
    }

    @PostMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDtoOutput> inserirProduto(@RequestBody ProdutoDtoInput produtoDtoInput){
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            produtoDtoOutput = produtoUseCase.criaProduto(produtoDtoInput);
        }catch (Exception e){
            System.out.println("Implementar ainda");
        }
        return ResponseEntity.ok(produtoDtoOutput);

    }

    @PutMapping(value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDtoOutput> inserirProduto(@PathVariable("id") Long id,
                                                           @RequestBody ProdutoDtoInput produtoDtoInput){
        ProdutoDtoOutput produtoDtoOutput = null;
        try {
            produtoDtoOutput = produtoUseCase.atualizaProduto(id, produtoDtoInput);
        }catch (Exception e){
            System.out.println("Implementar ainda");
        }
        return ResponseEntity.ok(produtoDtoOutput);

    }

    @DeleteMapping(value = "/produto/{id}")
    public void excluirProduto(@PathVariable("id") Long id){
        produtoUseCase.deletaProduto(id);
    }

}
