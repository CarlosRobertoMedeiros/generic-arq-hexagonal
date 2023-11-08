package br.com.roberto.testesarqhexagonal.arquiteturahex.adapter.db;

import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.model.Usuario;
import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.*;

//Obs: Não implementei capturando os dados via Postgres, apenas para focar nas portas e adapters
@Component
public class RepositorioUsuarioPostgres implements RepositorioUsuario {

    private static List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
            new Usuario("Carlos","carlosmedeiroslima@gmail.com","123456"),
            new Usuario("Luciene","luciene@gmail.com","654321"),
            new Usuario("Matheus","matheus@gmail.com","abcdef")
    ));

    @Override
    public boolean inserir(Usuario usuario) {
       return false;
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
//        return usuarios.stream()
//                .filter(usuarioDto -> usuarioDto.getEmail().equals(email))
//                .findFirst();
        return Optional.empty();
    }
}
