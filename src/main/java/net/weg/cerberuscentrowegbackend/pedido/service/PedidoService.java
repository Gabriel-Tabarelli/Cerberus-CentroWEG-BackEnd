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

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido findOne(Long id) {
        return pedidoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Boolean delete(Long id) {
        pedidoRepository.deleteById(id);
        return !pedidoRepository.existsById(id);
    }

}
