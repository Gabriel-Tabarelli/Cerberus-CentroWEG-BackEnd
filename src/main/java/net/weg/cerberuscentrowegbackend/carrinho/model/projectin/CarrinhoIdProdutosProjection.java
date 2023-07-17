package net.weg.cerberuscentrowegbackend.carrinho.model.projectin;

import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;

import java.util.List;

public interface CarrinhoIdProdutosProjection {

    Long getId();

    List<ProdutoMinimizadoProjection> getProdutos();

}
