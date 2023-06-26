package net.weg.cerberuscentrowegbackend.controller.websocket;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.websocket.PerguntaDto;
import net.weg.cerberuscentrowegbackend.model.entity.websocket.Pergunta;
import net.weg.cerberuscentrowegbackend.service.websocket.PerguntaService;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/produto") //TESTAR
public class PerguntaController {

    private PerguntaService perguntaService;

    @MessageMapping("/{nomeProduto}/perguntar") //Chegada da mensagem
    @SendTo("/topic/{nomeProduto}") //Envio da mensagem
    public Pergunta perguntar(@Payload PerguntaDto perguntaDto) {
        Pergunta pergunta = new Pergunta();
        BeanUtils.copyProperties(perguntaDto, pergunta);
        return perguntaService.create(pergunta);
    }

    @GetMapping()
    public List<Pergunta> getPerguntas() {

    }
}
