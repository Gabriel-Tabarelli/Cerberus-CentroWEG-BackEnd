package net.weg.cerberuscentrowegbackend.resposta.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaDto;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaRetornoDto;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.resposta.service.RespostaService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin
public class RespostaController {

    private final RespostaService respostaService;

    @MessageMapping("/{idPergunta}/responder") //Chegada da mensagem | Onde enviar a mensagem
    @SendTo("/topic/{idPessoa}") //Envio da mensagem | Onde inscrever-se para receber a mensagem
    public Notificacao perguntar(@Valid @Payload RespostaDto respostaDto,
                                 @DestinationVariable Long idPergunta) {
        Resposta resposta = new Resposta(respostaDto, idPergunta);
        respostaService.save(resposta);
        return new Notificacao(new RespostaRetornoDto(resposta));
    }

}
