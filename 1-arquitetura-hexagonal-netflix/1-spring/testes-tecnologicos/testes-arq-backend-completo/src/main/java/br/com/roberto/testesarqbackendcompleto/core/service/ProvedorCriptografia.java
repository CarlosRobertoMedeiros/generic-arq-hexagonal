package br.com.roberto.testesarqbackendcompleto.core.service;

public interface ProvedorCriptografia {
    String criptografar(String texto);
    Boolean comparar(String senha, String senhaCriptografada);
}
