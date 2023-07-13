package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;

public interface RespostaProjection {

    Long getId();

    String getResposta();

    PessoaNomeProjection getPessoa();

}
