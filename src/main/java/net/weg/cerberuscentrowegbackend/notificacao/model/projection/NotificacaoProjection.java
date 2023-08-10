package net.weg.cerberuscentrowegbackend.notificacao.model.projection;

import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaNotificacaoProjection;
import net.weg.cerberuscentrowegbackend.resposta.model.projection.RespostaNotificacaoProjection;

public interface NotificacaoProjection {

    Long getId();

    RespostaNotificacaoProjection getReposta();

    PerguntaNotificacaoProjection getPergunta();

}
