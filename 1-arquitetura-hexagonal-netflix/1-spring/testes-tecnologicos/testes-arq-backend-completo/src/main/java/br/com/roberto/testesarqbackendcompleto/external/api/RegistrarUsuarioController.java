package br.com.roberto.testesarqbackendcompleto.external.api;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.shared.CasoDeUso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class RegistrarUsuarioController {

    private static final Logger log = LoggerFactory.getLogger(RegistrarUsuarioController.class);
    private final CasoDeUso casoDeUso;

    public RegistrarUsuarioController(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    @PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registrarUsuario(@RequestBody Usuario usuario){
        log.info("[Api RegistrarUsuarioController] - Inserindo o Cliente . (usuario={})", usuario);
        try {
            casoDeUso.executar(usuario);
            return ResponseEntity.created(ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .build()
                            .toUri())
                    .build();
        }catch (Exception e){
            return ResponseEntity
                    .notFound()
                    .build();
        }


//        return consultaClienteUseCase.get(cpf)
//                .map(cliente -> ResponseEntity.ok(getClienteResponse(cliente)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}




