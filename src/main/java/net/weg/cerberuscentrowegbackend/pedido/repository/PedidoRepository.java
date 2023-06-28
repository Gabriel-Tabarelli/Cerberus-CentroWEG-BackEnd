package net.weg.cerberuscentrowegbackend.pedido.repository;

import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
