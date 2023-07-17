package net.weg.cerberuscentrowegbackend.pergunta.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;
import net.weg.cerberuscentrowegbackend.resposta.model.projection.RespostaProjection;

import java.util.List;

public interface PerguntaProjection {

    Long getId();

    List<RespostaProjection> getListaRespostas();

    String getPergunta();

    PessoaNomeProjection getPessoa();

}
