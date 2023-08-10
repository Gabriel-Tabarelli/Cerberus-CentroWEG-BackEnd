package net.weg.cerberuscentrowegbackend.pergunta.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;

public class PerguntaRetornoDto {

    @JsonProperty("perguntaId")
    private final Long id;

    @JsonProperty("pergunta")
    private final String pergunta;

    @JsonProperty("produtoId")
    private final Long produtoId;

    @JsonProperty("data")
    private final String data;

    public PerguntaRetornoDto(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.pergunta = pergunta.getPergunta();
        this.produtoId = pergunta.getProduto().getId();
        this.data = pergunta.getData();
    }

}
