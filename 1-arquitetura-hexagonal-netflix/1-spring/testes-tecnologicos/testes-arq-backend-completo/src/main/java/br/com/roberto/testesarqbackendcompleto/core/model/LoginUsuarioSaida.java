package br.com.roberto.testesarqbackendcompleto.core.model;

public class LoginUsuarioSaida {
    private Usuario usuario;
    private String token;


    public LoginUsuarioSaida(Usuario usuario, String token) {
        this.usuario = usuario;
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
