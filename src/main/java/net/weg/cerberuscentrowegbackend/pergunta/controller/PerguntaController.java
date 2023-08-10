package net.weg.cerberuscentrowegbackend.pergunta.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.notificacao.service.NotificacaoService;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.pergunta.service.PerguntaService;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin
public class PerguntaController {

    private final PerguntaService service;
    private final NotificacaoService notificacaoService;
    private final PessoaService pessoaService;

    @Transactional
    @MessageMapping("/{idProduto}/perguntar") //Chegada da mensagem | Onde enviar a mensagem  || USUARIO
    @SendTo("/topic/perguntas") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN
    public NotificacaoProjection perguntar(
            @Valid @Payload PerguntaDto perguntaDto,
            @DestinationVariable Long idProduto
    ) {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = currentDate.format(formatter);
        Pergunta pergunta = new Pergunta(perguntaDto, idProduto, formattedDate);
        Notificacao notificacao = new Notificacao(pergunta);
        service.save(pergunta);
        List<Pessoa> admins = pessoaService.pegarAdmins();
        admins.forEach(admin -> admin.getNotificacoes().add(notificacao));
        NotificacaoProjection notificacaoProjection = notificacaoService.salvar(notificacao);
        admins.forEach(pessoaService::update);
        return notificacaoProjection;
    }

}
