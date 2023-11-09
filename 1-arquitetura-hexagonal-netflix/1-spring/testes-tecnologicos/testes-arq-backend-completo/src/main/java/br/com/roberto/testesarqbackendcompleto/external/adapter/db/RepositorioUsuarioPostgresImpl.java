package br.com.roberto.testesarqbackendcompleto.external.adapter.db;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.service.RepositorioUsuario;
import br.com.roberto.testesarqbackendcompleto.external.api.RegistrarUsuarioController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioUsuarioPostgresImpl implements RepositorioUsuario {

    private static final Logger log = LoggerFactory.getLogger(RepositorioUsuarioPostgresImpl.class);
    @Override
    public boolean inserir(Usuario usuario) {
        log.info("[Component RepositorioUsuarioPostgresImpl] - Inserindo o Cliente AINDA NÃO IMPLEMENTADO. (usuario={})", usuario);
        return false;
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        log.info("[Component RepositorioUsuarioPostgresImpl] - buscarPorEmail AINDA NÃO IMPLEMENTADO. (email-usuario={})", email);
        return Optional.empty();
    }
}
