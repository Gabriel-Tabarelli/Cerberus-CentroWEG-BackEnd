package net.weg.cerberuscentrowegbackend.pergunta.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;

public class PerguntaRetornoDto {

    @JsonProperty("perguntaId")
    private final Long id;

    @JsonProperty("pergunta")
    private final String pergunta;

    public PerguntaRetornoDto(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.pergunta = pergunta.getPergunta();
    }

}
