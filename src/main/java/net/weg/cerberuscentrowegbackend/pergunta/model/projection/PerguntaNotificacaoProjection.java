package net.weg.cerberuscentrowegbackend.pergunta.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;

public interface PerguntaNotificacaoProjection {

    Long getId();

    String getPergunta();

    PessoaNomeProjection getPerguntador();

}
