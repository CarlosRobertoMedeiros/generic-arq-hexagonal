package br.com.roberto.testesarqhexagonal.dip;

public interface Notificador {
    boolean notificarMensagem(Pessoa pessoa, String mensagem);
}
