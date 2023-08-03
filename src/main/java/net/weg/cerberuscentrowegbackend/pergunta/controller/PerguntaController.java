package net.weg.cerberuscentrowegbackend.pergunta.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaRetornoDto;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.pergunta.service.PerguntaService;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class PerguntaController {

    private PerguntaService perguntaService;
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/{idProduto}/perguntar") //Chegada da mensagem | Onde enviar a mensagem  || USUARIO
    @SendTo("/topic/perguntas") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN
    public Notificacao perguntar(@Valid @Payload PerguntaDto perguntaDto,
                                                 @DestinationVariable Long idProduto) {

        Pergunta pergunta = new Pergunta(perguntaDto, idProduto);
        perguntaService.save(pergunta);
        Notificacao notificacao =  new Notificacao(new PerguntaRetornoDto(pergunta));
        System.out.println(notificacao.getPergunta());
        return notificacao;
    }

}
