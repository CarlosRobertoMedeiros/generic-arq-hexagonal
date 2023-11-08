package br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.service;

import br.com.roberto.testesarqhexagonal.arquiteturahex.adapter.auth.SenhaCripto;
import br.com.roberto.testesarqhexagonal.arquiteturahex.core.shared.CasoDeUso;
import br.com.roberto.testesarqhexagonal.arquiteturahex.core.usuario.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class RegistrarUsuario implements CasoDeUso<Usuario> {

    private final RepositorioUsuario repositorioUsuario;
    private final ProvedorCriptografia provedorCriptografia;
    public RegistrarUsuario(RepositorioUsuario repositorioUsuario,
                            ProvedorCriptografia provedorCriptografia) {
        this.repositorioUsuario = repositorioUsuario;
        this.provedorCriptografia = new SenhaCripto();
    }

    @Override
    public void executar(Usuario usuario) {
        var  senhaCripto = provedorCriptografia.criptografar(usuario.getSenha());
        var usuarioOptional =
                this.repositorioUsuario.buscarPorEmail(usuario.getEmail());

        if (usuarioOptional.isPresent()){
            throw new RuntimeException("Usuario Já Existente");
        }
        var novoUsuario = new Usuario(usuario.getNome(), usuario.getEmail(), senhaCripto);
        boolean usuarioInserido = this.repositorioUsuario.inserir(novoUsuario);
    }
}
