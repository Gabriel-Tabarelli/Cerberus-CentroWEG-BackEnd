package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import lombok.Data;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Resposta;


@Data
public class Notificacao {

    private Pergunta pergunta;
    private Resposta resposta;

    public Notificacao(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Notificacao(Resposta resposta) {
        this.resposta = resposta;
    }

}
