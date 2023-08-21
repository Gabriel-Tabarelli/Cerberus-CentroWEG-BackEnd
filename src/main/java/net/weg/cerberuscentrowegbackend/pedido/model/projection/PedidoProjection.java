package net.weg.cerberuscentrowegbackend.pedido.model.projection;

import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;

import java.util.List;

public interface PedidoProjection {

    Long getId();

    String getStatus();

    String getDataPedido();

    List<ProdutoMinimizadoProjection> getProdutos();

}
