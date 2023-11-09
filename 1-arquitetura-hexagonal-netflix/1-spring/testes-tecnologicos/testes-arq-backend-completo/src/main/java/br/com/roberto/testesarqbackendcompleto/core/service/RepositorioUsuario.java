package br.com.roberto.testesarqbackendcompleto.core.service;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;

import java.util.Optional;

public interface RepositorioUsuario {
    boolean inserir(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
}
