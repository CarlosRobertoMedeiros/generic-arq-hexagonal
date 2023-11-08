package br.com.roberto.testesarqhexagonal.dip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotificacaoController {

    private Notificador notificador;

    public NotificacaoController(Notificador notificador) {
        this.notificador = notificador;
    }

    @GetMapping(value = "/{tipoMensagem}")
    public void enviarMensagem(@PathVariable("tipoMensagem") TipoMensagem tipoMensagem){

        switch (tipoMensagem){
            case EMAIL -> {
                notificador = new NotificarEmail();
                notificador.notificarMensagem(new Pessoa(1l,"Carlos"),"Ganhei");
            }
            case SMS -> {
                notificador = new NotificarSMS();
                notificador.notificarMensagem(new Pessoa(1l,"Carlos"),"Ganhei");
            }
            default -> {
                System.out.println("Não encontrado !");
            }
        }
    }
}
