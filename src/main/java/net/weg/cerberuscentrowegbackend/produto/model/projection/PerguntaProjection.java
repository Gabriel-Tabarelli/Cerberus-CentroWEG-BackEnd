package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;

import java.util.List;

public interface PerguntaProjection {

    Long getId();

    List<RespostaProjection> getListaRespostas();

    String getPergunta();

    PessoaNomeProjection getPessoa();

}
