package net.weg.cerberuscentrowegbackend.pergunta.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaRetornoDto;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.pergunta.service.PerguntaService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@AllArgsConstructor
@CrossOrigin
public class PerguntaController {

    private PerguntaService perguntaService;
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/{idProduto}/perguntar") //Chegada da mensagem | Onde enviar a mensagem  || USUARIO
    @SendTo("/topic/perguntas") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN
    public PerguntaRetornoDto perguntar(
            @Valid @Payload PerguntaDto perguntaDto,
            @DestinationVariable Long idProduto
    ) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = currentDate.format(formatter);
        Pergunta pergunta = new Pergunta(perguntaDto, idProduto, formattedDate);
        perguntaService.save(pergunta);
        return new PerguntaRetornoDto(pergunta);
    }

}
