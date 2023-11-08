package br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service;

//Na arquitetura Hexagonal essa interface é uma porta(Interface de Comunicação)
//A porta faz parte do core da sua aplicação
public interface ProvedorCriptografia {

    String criptografar(String texto);


}
