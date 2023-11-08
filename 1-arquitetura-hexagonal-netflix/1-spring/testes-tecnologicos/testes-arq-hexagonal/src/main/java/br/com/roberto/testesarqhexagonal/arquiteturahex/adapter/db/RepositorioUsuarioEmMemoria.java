package br.com.roberto.testesarqhexagonal.arquiteturahex.adapter.db;

import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.model.Usuario;
import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service.RepositorioUsuario;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Primary
public class RepositorioUsuarioEmMemoria implements RepositorioUsuario {

    private static List<Usuario> usuarios = new ArrayList<>(Arrays.asList(
            new Usuario("Carlos","carlosmedeiroslima@gmail.com","123456"),
            new Usuario("Luciene","luciene@gmail.com","654321"),
            new Usuario("Matheus","matheus@gmail.com","abcdef")
    ));

    @Override
    public boolean inserir(Usuario usuario) {
        if (Objects.isNull(usuario)) return false;
        Optional<Usuario> usuarioOptional = buscarPorEmail(usuario.getEmail());
        if (usuarioOptional.isPresent()) return false;

        try {
            Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
            return usuarios.add(novoUsuario);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex.getCause()+" "+ex.getMessage());
        }
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(usuarioDto -> usuarioDto.getEmail().equals(email))
                .findFirst();
    }
}
