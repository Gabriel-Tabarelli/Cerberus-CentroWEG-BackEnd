package net.weg.cerberuscentrowegbackend.resposta.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.notificacao.service.NotificacaoService;
import net.weg.cerberuscentrowegbackend.pergunta.service.PerguntaService;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaDto;
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
    private final PessoaService pessoaService;
    private final NotificacaoService notificacaoService;

    @Transactional
    @MessageMapping("/{idPergunta}/responder/{idPessoa}") //Chegada da mensagem | Onde enviar a mensagem || ADMIN
    @SendTo("/topic/{idPessoa}") //Envio da mensagem | Onde inscrever-se para receber a mensagem || ADMIN USUARIO
    public NotificacaoProjection perguntar(
            @Valid @Payload RespostaDto respostaDto,
            @DestinationVariable Long idPergunta,
            @DestinationVariable Long idPessoa
    ) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        Resposta resposta = new Resposta(respostaDto, idPergunta, formattedDate);

        resposta.setPergunta(perguntaService.getOne(idPergunta));
        Notificacao notificacao = new Notificacao(resposta);
        service.save(resposta);
        Pessoa pessoa = pessoaService.findOne(idPessoa);
        pessoa.getNotificacoes().add(notificacao);
        NotificacaoProjection notificacaoProjection = notificacaoService.salvar(notificacao);
        pessoaService.update(pessoa);
        return notificacaoProjection;
    }

}
