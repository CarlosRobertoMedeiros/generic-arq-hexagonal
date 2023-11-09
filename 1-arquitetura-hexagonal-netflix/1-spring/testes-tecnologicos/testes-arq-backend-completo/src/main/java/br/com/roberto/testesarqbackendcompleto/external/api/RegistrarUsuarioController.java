package br.com.roberto.testesarqbackendcompleto.external.api;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.shared.CasoDeUso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegistrarUsuarioController {

    private static final Logger log = LoggerFactory.getLogger(RegistrarUsuarioController.class);
    private final CasoDeUso casoDeUso;

    public RegistrarUsuarioController(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    @PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public /*ResponseEntity<UsuarioOutput>*/ void registrarUsuario(@RequestBody Usuario usuario){
        log.info("[Api RegistrarUsuarioController] - Inserindo o Cliente . (usuario={})", usuario);
        casoDeUso.executar(usuario);

//        return consultaClienteUseCase.get(cpf)
//                .map(cliente -> ResponseEntity.ok(getClienteResponse(cliente)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
