package net.weg.cerberuscentrowegbackend.resposta.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.controller.PerguntaController;
import net.weg.cerberuscentrowegbackend.pergunta.service.PerguntaService;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@AllArgsConstructor
@CrossOrigin
public class RespostaController {

    private final RespostaService service;
    private final PerguntaService perguntaService;

    @Transactional
    @MessageMapping("/{idPergunta}/responder/{idPessoa}") //Chegada da mensagem | Onde enviar a mensagem || ADMIN
    @SendTo("/topic/{idPessoa}") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN USUARIO
    public RespostaRetornoDto perguntar(
            @Valid @Payload RespostaDto respostaDto,
            @DestinationVariable Long idPergunta,
            @DestinationVariable Long idPessoa
    ) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        Resposta resposta = new Resposta(respostaDto, idPergunta, formattedDate);

        resposta.setPergunta(perguntaService.getOne(idPergunta));
        service.save(resposta);
        return new RespostaRetornoDto(resposta);
    }

}
