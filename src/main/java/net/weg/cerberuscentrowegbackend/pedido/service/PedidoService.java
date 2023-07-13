package net.weg.cerberuscentrowegbackend.pedido.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public void update(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    public Pedido findOne(Long id) {
        return pedidoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

}
