package br.com.roberto.testesarqhexagonal.dip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class NotificarSMSTest {

    @InjectMocks
    private NotificarEmail notificadorEmail;
    Pessoa pessoa = null;

    @BeforeEach
    void setUp() {
        notificadorEmail = new NotificarEmail();
    }

    @Test
    @DisplayName("Nao Deve Notificar via Email sem informar o cliente")
    void NaodeveNotificarViaEmailSemInformarCliente(){
        notificadorEmail.notificarMensagem(pessoa,"Confirmacao de Reuniao");
        Assertions.assertNull(pessoa);

    }

    @Test
    @DisplayName("Deve Notificar via Email o cliente")
    void deveNotificarViaEmailCliente(){
        pessoa = new Pessoa(1L,"Pedro");
        notificadorEmail.notificarMensagem(pessoa,"Confirmacao de Reuniao");
        Assertions.assertNotEquals(0,pessoa.getId());

    }



}