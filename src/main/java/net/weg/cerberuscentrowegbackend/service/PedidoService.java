package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido findOne(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            return pedidoOptional.get();
        }
        throw new RuntimeException("Pedido não encontrado!");
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Boolean delete(Long id) {
        pedidoRepository.deleteById(id);
        return !pedidoRepository.existsById(id);
    }

}
