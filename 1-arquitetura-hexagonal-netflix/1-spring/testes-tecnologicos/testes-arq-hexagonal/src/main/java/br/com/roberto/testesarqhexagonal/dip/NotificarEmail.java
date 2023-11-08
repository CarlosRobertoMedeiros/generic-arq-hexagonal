package br.com.roberto.testesarqhexagonal.dip;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Primary
@Service
public class NotificarEmail implements Notificador{

    public  NotificarEmail(){
        System.out.println("Chamado o NotificarEmail");
    }
    @Override
    public boolean notificarMensagem(Pessoa pessoa, String mensagem) {
        if (Objects.isNull(pessoa))
            return  false;
        System.out.println("Email: "+mensagem);
        return true;
    }


}
