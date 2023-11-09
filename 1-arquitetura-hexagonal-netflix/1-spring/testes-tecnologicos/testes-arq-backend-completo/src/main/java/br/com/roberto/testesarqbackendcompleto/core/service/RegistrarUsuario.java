package br.com.roberto.testesarqbackendcompleto.core.service;

import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.shared.CasoDeUso;
import br.com.roberto.testesarqbackendcompleto.external.adapter.auth.SenhaCripto;
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
    public void executar(Usuario command) {
        var  senhaCripto = provedorCriptografia.criptografar(command.getSenha());
        var usuarioOptional =
                this.repositorioUsuario.buscarPorEmail(command.getEmail());

        if (usuarioOptional.isPresent()){
            throw new RuntimeException("Usuario Já Existente");
        }
        var novoUsuario = new Usuario(command.getNome(), command.getEmail(), senhaCripto);
        boolean usuarioInserido = this.repositorioUsuario.inserir(novoUsuario);

    }
}
