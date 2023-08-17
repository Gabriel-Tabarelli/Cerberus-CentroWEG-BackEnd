package net.weg.cerberuscentrowegbackend.notificacao.model.projection;

import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaNotificacaoProjection;
import net.weg.cerberuscentrowegbackend.resposta.model.projection.RespostaProjection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NotificacaoProjection {

    Long getId();

    RespostaProjection getResposta();

    PerguntaNotificacaoProjection getPergunta();

    Boolean getVisualizada();

    LocalDateTime getData();

}
