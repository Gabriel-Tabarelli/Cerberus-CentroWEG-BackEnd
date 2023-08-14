package net.weg.cerberuscentrowegbackend.resposta.model.projection;

import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaNotificacaoProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;

public interface RespostaProjection {

    Long getId();

    String getResposta();

    PerguntaNotificacaoProjection getPergunta();

    PessoaNomeProjection getRespondedor();

    String getData();

}
