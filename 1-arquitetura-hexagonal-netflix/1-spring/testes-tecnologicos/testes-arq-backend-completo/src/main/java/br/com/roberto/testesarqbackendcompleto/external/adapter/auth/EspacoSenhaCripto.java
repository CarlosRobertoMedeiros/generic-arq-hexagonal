package br.com.roberto.testesarqbackendcompleto.external.adapter.auth;

import br.com.roberto.testesarqbackendcompleto.core.service.ProvedorCriptografia;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//Na arquitetura Hexagonal essa classe é um adaptador (Adaptador implementação concreta)
//O Adaptador não faz parte do coreBussiness da sua aplicação
@Service
public class EspacoSenhaCripto implements ProvedorCriptografia {

    @Override
    public String criptografar(String texto) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            result.append(texto.charAt(i));
            if (i < texto.length() - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public Boolean comparar(String senha, String senhaCriptografada) {
        return this.criptografar(senha).equals(senhaCriptografada);
    }
}
