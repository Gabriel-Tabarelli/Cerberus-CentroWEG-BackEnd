package net.weg.cerberuscentrowegbackend.pergunta.model.dto;

import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;

public class PerguntaRetornoDto {

    private final Long id;

    private final String pergunta;

    public PerguntaRetornoDto(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.pergunta = pergunta.getPergunta();
    }

}
