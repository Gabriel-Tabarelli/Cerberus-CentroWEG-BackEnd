package net.weg.cerberuscentrowegbackend.pedido.repository;

import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoListaProjection;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<PedidoListaProjection> findByPessoa_Id(Long carrinho_pessoa_id, Pageable pageable);

    Optional<PedidoProjection> findPedidoById(Long id);

}
