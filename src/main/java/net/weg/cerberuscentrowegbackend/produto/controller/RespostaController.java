package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.RespostaDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.produto.service.PerguntaService;
import net.weg.cerberuscentrowegbackend.produto.service.RespostaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/resposta")
public class RespostaController {

    private final RespostaService respostaService;
    private final PerguntaService perguntaService;

    @PostMapping("/{idPergunta}")
    public ResponseEntity<Void> save(@Valid @RequestParam("resposta") RespostaDto respostaDto,
                                     @PathVariable Long idPergunta) {
        Resposta resposta = new Resposta();
        BeanUtils.copyProperties(respostaDto, resposta);
        Pergunta pergunta = perguntaService.getOne(idPergunta);
        respostaService.save(resposta, pergunta);
        return ResponseEntity.ok().build();
    }

}
