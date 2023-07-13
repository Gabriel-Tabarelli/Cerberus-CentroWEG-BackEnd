package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import net.weg.cerberuscentrowegbackend.produto.service.PerguntaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PerguntaController {

    private PerguntaService perguntaService;
    private ProdutoService produtoService;

    @MessageMapping("/{idProduto}/perguntar") //Chegada da mensagem
    @SendTo("/topic/{idProduto}") //Envio da mensagem
    public Pergunta perguntar(@Valid @Payload PerguntaDto perguntaDto,
                              @DestinationVariable Long idProduto) {
        Pergunta pergunta = new Pergunta();
        BeanUtils.copyProperties(perguntaDto, pergunta);
        Produto produto = produtoService.findById(idProduto);
        produto.getPerguntas().add(pergunta);
        return perguntaService.save(pergunta);
    }

    @PostMapping("/api/pergunta")
    public ResponseEntity<Void> perguntar(@RequestBody @Valid PerguntaDto perguntaDto) {
        Pergunta pergunta = new Pergunta();
        BeanUtils.copyProperties(perguntaDto, pergunta);
        perguntaService.save(pergunta);
        return ResponseEntity.ok().build();
    }

}
