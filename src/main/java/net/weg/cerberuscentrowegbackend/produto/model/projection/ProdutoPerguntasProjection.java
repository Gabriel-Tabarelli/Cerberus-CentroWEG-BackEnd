package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;

import java.util.List;

public interface ProdutoPerguntasProjection {

    List<Pergunta> getPerguntas();

}
