package net.weg.cerberuscentrowegbackend.produto.model.projection;

import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;

public interface ProdutoMinimizadoProjection {

    Long getId();
    String getNome();
    String getUrlImagem();
    Categoria getCategoria();

}
