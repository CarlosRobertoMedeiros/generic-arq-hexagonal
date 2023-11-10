package br.com.roberto.testesarqbackendcompleto.core.shared.exceptions;

public class UsuarioInexistenteException extends RuntimeException{
    public UsuarioInexistenteException(String message) {
        super(message);
    }
}
