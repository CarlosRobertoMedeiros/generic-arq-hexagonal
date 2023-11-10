package br.com.roberto.testesarqbackendcompleto.core.service;

import br.com.roberto.testesarqbackendcompleto.core.model.LoginUsuarioSaida;
import br.com.roberto.testesarqbackendcompleto.core.model.Usuario;
import br.com.roberto.testesarqbackendcompleto.core.shared.CasoDeUsoLogin;
import br.com.roberto.testesarqbackendcompleto.core.shared.exceptions.SenhaIncorretaException;
import br.com.roberto.testesarqbackendcompleto.core.shared.exceptions.UsuarioInexistenteException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUsuario implements CasoDeUsoLogin<Usuario> {

    private RepositorioUsuario repositorioUsuario;
    private ProvedorCriptografia provedorCriptografia;

    public LoginUsuario(RepositorioUsuario repositorioUsuario,
                        ProvedorCriptografia provedorCriptografia) {
        this.repositorioUsuario = repositorioUsuario;
        this.provedorCriptografia = provedorCriptografia;
    }

    @Override
    public LoginUsuarioSaida executar(Usuario command) {
        Optional<Usuario> usuarioOptional = repositorioUsuario.buscarPorEmail(command);

        if (!usuarioOptional.isPresent()){
            throw new UsuarioInexistenteException("Usuario Inexistente");
        }

        var mesmaSenha = this.provedorCriptografia.comparar(command.getSenha(), usuarioOptional.get().getSenha());

        if (!mesmaSenha){
            throw new SenhaIncorretaException("Senha Incorreta");
        }
        return new LoginUsuarioSaida(usuarioOptional.get(),"token");
    }
}
