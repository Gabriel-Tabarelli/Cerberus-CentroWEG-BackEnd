package net.weg.cerberuscentrowegbackend.pedido.model.projection;

import java.time.LocalDate;

public interface PedidoListaProjection {

    Long getId();

    String getStatus();

    LocalDate getDataPedido();

}
