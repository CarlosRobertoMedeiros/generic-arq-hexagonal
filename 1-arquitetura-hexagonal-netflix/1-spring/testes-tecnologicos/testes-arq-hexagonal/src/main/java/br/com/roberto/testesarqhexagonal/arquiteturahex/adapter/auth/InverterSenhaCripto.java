package br.com.roberto.testesarqhexagonal.arquiteturahex.adapter.auth;

import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service.ProvedorCriptografia;
import org.springframework.stereotype.Service;

//Na arquitetura Hexagonal essa classe é um adaptador (Adaptador implementação concreta)
//O Adaptador não faz parte do coreBussiness da sua aplicação
@Service
public class InverterSenhaCripto implements ProvedorCriptografia {
    @Override
    public String criptografar(String texto) {
        StringBuilder reversed = new StringBuilder(texto).reverse();
        return reversed.toString();
    }
}
