package br.com.roberto.testesarqbackendcompleto.external.adapter.db;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.service.RepositorioUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioUsuarioPostgresImpl implements RepositorioUsuario {

    private static final Logger log = LoggerFactory.getLogger(RepositorioUsuarioPostgresImpl.class);
    private PostgresClientRepository postgresClientRepository;

    public RepositorioUsuarioPostgresImpl(PostgresClientRepository postgresClientRepository) {
        this.postgresClientRepository = postgresClientRepository;
    }

    @Override
    public boolean inserir(Usuario usuario) {
        log.info("[Component RepositorioUsuarioPostgresImpl] - Inserindo o Cliente. (usuario={})", usuario);
        Usuario usuarioSalvo =  this.postgresClientRepository.save(usuario);
        if (usuarioSalvo==null) return false;
        return true;
    }

    @Override
    public Optional<Usuario> buscarPorEmail(Usuario usuario) {
        log.info("[Component RepositorioUsuarioPostgresImpl] - buscar cliente por email. (email-usuario={})", usuario.getEmail());
        Usuario usuarioSalvo =  this.postgresClientRepository.findByEmail(usuario.getEmail());
        return Optional.ofNullable(usuarioSalvo);
    }
}
