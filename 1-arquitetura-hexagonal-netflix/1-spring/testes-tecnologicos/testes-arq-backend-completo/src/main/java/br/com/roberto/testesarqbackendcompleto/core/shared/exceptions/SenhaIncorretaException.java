package br.com.roberto.testesarqbackendcompleto.core.shared.exceptions;

public class SenhaIncorretaException extends RuntimeException{
    public SenhaIncorretaException(String message) {
        super(message);
    }
}
