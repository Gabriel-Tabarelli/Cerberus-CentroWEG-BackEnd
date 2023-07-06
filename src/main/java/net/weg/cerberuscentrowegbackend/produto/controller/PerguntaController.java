package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import net.weg.cerberuscentrowegbackend.produto.service.PerguntaService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/produto")
public class PerguntaController {

    private PerguntaService perguntaService;
    private ProdutoService produtoService;

    @MessageMapping("/{nomeProduto}/perguntar") //Chegada da mensagem
    @SendTo("/topic/{nomeProduto}") //Envio da mensagem
    public Pergunta perguntar(@Valid @Payload PerguntaDto perguntaDto,
                              @DestinationVariable String nomeProduto) {
        Pergunta pergunta = new Pergunta();
        BeanUtils.copyProperties(perguntaDto, pergunta);
        Produto produto = produtoService.findByNome(nomeProduto);
        produto.getPerguntas().add(pergunta);
        return perguntaService.save(pergunta);
    }

}
