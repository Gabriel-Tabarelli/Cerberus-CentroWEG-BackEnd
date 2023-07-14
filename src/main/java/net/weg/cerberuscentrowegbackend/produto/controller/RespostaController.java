package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.produto.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.produto.model.dto.RespostaDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.produto.service.PerguntaService;
import net.weg.cerberuscentrowegbackend.produto.service.RespostaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/resposta")
public class RespostaController {

    private final RespostaService respostaService;

    @MessageMapping("/{idPergunta}/responder") //Chegada da mensagem | Onde enviar a mensagem
    @SendTo("/topic/pergunta/{idPergunta}") //Envio da mensagem | Onde inscrever-se para receber a mensagem
    public Notificacao perguntar(@Valid @Payload RespostaDto respostaDto,
                                 @DestinationVariable Long idPergunta) {
        Resposta resposta = new Resposta(respostaDto, idPergunta);
        respostaService.save(resposta);
        return new Notificacao(resposta);
    }

}
