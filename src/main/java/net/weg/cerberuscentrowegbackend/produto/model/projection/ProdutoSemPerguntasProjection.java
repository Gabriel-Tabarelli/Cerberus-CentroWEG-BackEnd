package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;

import java.util.List;

public interface ProdutoSemPerguntasProjection {

    Long getId();

    String getNome();

    String getUrlImagem();

    String getDescricao();

    Categoria getCategoria();

    List<EspecificacaoProduto> getEspecificacoes();

}
