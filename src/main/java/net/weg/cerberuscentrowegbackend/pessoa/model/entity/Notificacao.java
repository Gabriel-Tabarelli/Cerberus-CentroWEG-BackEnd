package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import lombok.Data;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;


@Data
public class Notificacao {

    private String notificacao;

    public Notificacao(Produto produto, String notificacao) {
        this.notificacao = "Nova pergunta sobre o produto " + produto.getNome() + ": " + notificacao;
    }

    public Notificacao(Pergunta pergunta, String notificacao) {
        this.notificacao = "Nova resposta sobre a pergunta " + pergunta.getPergunta() + ": " + notificacao;
    }

}
