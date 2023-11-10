package br.com.roberto.testesarqbackendcompleto.external.api;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.shared.CasoDeUsoLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class LoginUsuarioController {

    private static final Logger log = LoggerFactory.getLogger(LoginUsuarioController.class);
    private final CasoDeUsoLogin casoDeUso;

    public LoginUsuarioController(CasoDeUsoLogin casoDeUso) {
        this.casoDeUso = casoDeUso;
    }

    @PostMapping(value = "/usuario/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
        log.info("[Api LoginUsuarioController] - Realizando Login do Usuario . (usuario={})", usuario);
        try {
            casoDeUso.executar(usuario);
            return ResponseEntity.ok().body(usuario);

        }catch (Exception ex){
            return ResponseEntity
                    .notFound()
                    .build();
        }


//        return consultaClienteUseCase.get(cpf)
//                .map(cliente -> ResponseEntity.ok(getClienteResponse(cliente)))
//                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}




