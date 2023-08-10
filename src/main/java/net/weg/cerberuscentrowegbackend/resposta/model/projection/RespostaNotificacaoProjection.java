package net.weg.cerberuscentrowegbackend.resposta.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;

public interface RespostaNotificacaoProjection {

    Long getId();

    String getResposta();

    PessoaNomeProjection getRespondedor();

}
