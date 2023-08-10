package net.weg.cerberuscentrowegbackend.resposta.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaRetornoDto;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

public class RespostaRetornoDto {

    @JsonProperty("respostaId")
    private final Long id;

    @JsonProperty("resposta")
    private final String resposta;

    @JsonProperty("pergunta")
    private final PerguntaRetornoDto pergunta;

    @JsonProperty("data")
    private final String data;

    public RespostaRetornoDto(Resposta resposta) {
        this.id = resposta.getId();
        this.resposta = resposta.getResposta();
        this.pergunta = new PerguntaRetornoDto(resposta.getPergunta());
        this.data = resposta.getData();
    }

}
