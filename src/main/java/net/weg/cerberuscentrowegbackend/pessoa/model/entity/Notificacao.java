package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import lombok.Data;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaRetornoDto;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaRetornoDto;

@Data
public class Notificacao {

    private PerguntaRetornoDto pergunta;
    private RespostaRetornoDto resposta;

    public Notificacao(PerguntaRetornoDto pergunta) {
        this.pergunta = pergunta;
    }

    public Notificacao(RespostaRetornoDto resposta) {
        this.resposta = resposta;
    }

}
