package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaProjection;

import java.util.List;

public interface ProdutoPerguntasProjection {

    List<PerguntaProjection> getPerguntas();

}
