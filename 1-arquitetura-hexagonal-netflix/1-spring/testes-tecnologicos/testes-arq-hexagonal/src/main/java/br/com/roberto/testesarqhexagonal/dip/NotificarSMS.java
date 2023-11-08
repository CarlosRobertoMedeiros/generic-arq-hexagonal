package br.com.roberto.testesarqhexagonal.dip;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NotificarSMS implements Notificador{

    public  NotificarSMS(){
        System.out.println("Chamado o NotificarSMS");
    }
    @Override
    public boolean notificarMensagem(Pessoa pessoa, String mensagem) {
        if (Objects.isNull(pessoa))
            return  false;
        System.out.println("SMS: "+mensagem);
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "NotificarEmail{}";
    }
}
