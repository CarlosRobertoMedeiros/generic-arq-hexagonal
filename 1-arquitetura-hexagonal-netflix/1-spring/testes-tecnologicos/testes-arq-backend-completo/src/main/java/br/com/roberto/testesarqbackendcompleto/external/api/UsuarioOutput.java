package br.com.roberto.testesarqbackendcompleto.external.api;

public class UsuarioOutput {
    private String id;
    private String nome;
    private String email;
    private String senha;

    public UsuarioOutput(String id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
