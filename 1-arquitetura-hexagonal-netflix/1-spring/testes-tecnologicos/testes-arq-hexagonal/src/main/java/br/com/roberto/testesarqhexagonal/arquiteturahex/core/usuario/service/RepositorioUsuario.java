package br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service;

import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.model.Usuario;

import java.util.Optional;

//Na arquitetura Hexagonal essa interface é uma porta(Interface de Comunicação)
//A porta faz parte do core da sua aplicação
public interface RepositorioUsuario {
    boolean inserir(Usuario usuario);
    Optional<Usuario> buscarPorEmail(String email);
}
