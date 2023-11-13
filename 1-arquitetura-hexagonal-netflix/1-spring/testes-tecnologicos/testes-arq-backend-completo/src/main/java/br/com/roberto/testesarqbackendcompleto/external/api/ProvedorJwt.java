package br.com.roberto.testesarqbackendcompleto.external.api;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProvedorJwt {
    private AuthenticationManager authenticationManager;
    private TokenProvider tokenProvider;

    public ProvedorJwt(AuthenticationManager authenticationManager, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }


}
