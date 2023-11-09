package br.com.roberto.testesarqbackendcompleto.core.shared;

public interface CasoDeUso<T> {
    void executar(T command);
}
