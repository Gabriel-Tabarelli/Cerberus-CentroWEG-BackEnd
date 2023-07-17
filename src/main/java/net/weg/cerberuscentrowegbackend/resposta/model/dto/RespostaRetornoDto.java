package net.weg.cerberuscentrowegbackend.resposta.model.dto;

import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaRetornoDto;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

public class RespostaRetornoDto {

    private final Long id;

    private final String resposta;

    private final PerguntaRetornoDto pergunta;

    public RespostaRetornoDto(Resposta resposta) {
        this.id = resposta.getId();
        this.resposta = resposta.getResposta();
        this.pergunta = new PerguntaRetornoDto(resposta.getPergunta());
    }

}
