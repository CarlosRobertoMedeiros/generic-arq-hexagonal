package br.com.roberto.testesarqbackendcompleto.external.adapter.auth;

import br.com.roberto.testesarqbackendcompleto.core.service.ProvedorCriptografia;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



//Na arquitetura Hexagonal essa classe é um adaptador (Adaptador implementação concreta)
//O Adaptador não faz parte do coreBussiness da sua aplicação
@Service
public class SenhaCripto implements ProvedorCriptografia {
    @Override
    public String criptografar(String texto) {
        String md5Hash;
        try {
            // Crie uma instância do MessageDigest com o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Converta a string em bytes
            byte[] inputBytes = texto.getBytes();

            // Calcule o hash MD5
            byte[] md5Bytes = md.digest(inputBytes);

            // Converta o hash em uma representação hexadecimal
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : md5Bytes) {
                String hex = String.format("%02x", b);
                hexStringBuilder.append(hex);
            }

            // A representação em hash MD5
            md5Hash = hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getCause() + " " + e.getMessage());
        }
        return md5Hash;
    }
}
