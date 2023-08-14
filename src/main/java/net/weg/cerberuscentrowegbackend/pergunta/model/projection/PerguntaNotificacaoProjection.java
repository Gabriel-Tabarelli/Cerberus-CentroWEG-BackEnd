package net.weg.cerberuscentrowegbackend.pergunta.model.projection;

import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNomeProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;

public interface PerguntaNotificacaoProjection {

    Long getId();

    String getPergunta();

    PessoaNomeProjection getPerguntador();

    String getData();

    ProdutoMinimizadoProjection getProduto();

}
