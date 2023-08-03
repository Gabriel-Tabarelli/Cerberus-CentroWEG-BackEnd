package net.weg.cerberuscentrowegbackend.resposta.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaDto;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaRetornoDto;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.resposta.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin
public class RespostaController {

    private final RespostaService respostaService;

    private final SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/{idPergunta}/responder/{idPessoa}") //Chegada da mensagem | Onde enviar a mensagem || ADMIN
    @SendTo("/topic/{idPessoa}") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN USUARIO
    public Notificacao perguntar(@Valid @Payload RespostaDto respostaDto,
                                 @DestinationVariable Long idPergunta,
                                 @DestinationVariable Long idPessoa) {
        System.out.println(respostaDto);
        Resposta resposta = new Resposta(respostaDto, idPergunta);
        respostaService.save(resposta);
        return new Notificacao(new RespostaRetornoDto(resposta));
    }

}
