package net.weg.cerberuscentrowegbackend.pessoa.model.projection;

import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;

import java.util.List;

public interface PessoaNotificacoesProjection {

    List<NotificacaoProjection> getNotificacoes();

}
