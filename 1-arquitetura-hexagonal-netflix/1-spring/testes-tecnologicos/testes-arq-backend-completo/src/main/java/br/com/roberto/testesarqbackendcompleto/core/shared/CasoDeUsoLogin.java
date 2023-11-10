package br.com.roberto.testesarqbackendcompleto.core.shared;

import br.com.roberto.testesarqbackendcompleto.core.model.LoginUsuarioSaida;

public interface CasoDeUsoLogin<T> {
    LoginUsuarioSaida executar(T command);
}
