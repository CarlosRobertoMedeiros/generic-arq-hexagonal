package br.com.roberto.testesarqhexagonal.arquiteturahex.core.shared;

public interface CasoDeUso<T> {

    void executar(T entrada);

}
