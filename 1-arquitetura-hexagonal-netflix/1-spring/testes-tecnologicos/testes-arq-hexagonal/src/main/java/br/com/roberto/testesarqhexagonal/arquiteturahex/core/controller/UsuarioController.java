package br.com.roberto.testesarqhexagonal.arquiteturahex.core.controller;

import br.com.roberto.testesarqhexagonal.arquiteturahex.core.shared.CasoDeUso;
import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private CasoDeUso casoDeUso;

    public UsuarioController(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    @PostMapping("/")
    public void enviarMensagem(@RequestBody Usuario usuario){
        casoDeUso.executar(usuario);
    }
}
