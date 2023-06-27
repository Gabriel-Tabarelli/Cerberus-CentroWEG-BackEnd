package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoNaoEncontradoException;
import net.weg.cerberuscentrowegbackend.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.repository.PedidoRepository;
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
                ObjetoNaoEncontradoException::new);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Boolean delete(Long id) {
        pedidoRepository.deleteById(id);
        return !pedidoRepository.existsById(id);
    }

}
