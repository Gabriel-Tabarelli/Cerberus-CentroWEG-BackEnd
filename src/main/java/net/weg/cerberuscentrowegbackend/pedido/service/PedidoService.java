package net.weg.cerberuscentrowegbackend.pedido.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pedido.model.dto.PedidoDto;
import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoListaProjection;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoProjection;
import net.weg.cerberuscentrowegbackend.pedido.repository.PedidoRepository;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository repository;
    private CarrinhoService carrinhoService;


    public void save(Long idCarrinho) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        repository.save(new Pedido(carrinho));
        carrinho.getProdutos().removeAll(carrinho.getProdutos());
        carrinhoService.save(carrinho);
    }

    public Page<PedidoListaProjection> findAll(Long pessoaId, Integer page, String ordem) {
        Sort sort = null;
        if (ordem.equals("asc")) {
            sort = Sort.by("id").ascending();
        } else {
            sort = Sort.by("id").descending();
        }
        return repository.findByPessoa_Id(pessoaId, PageRequest.of(page, 5, sort));
    }

    public PedidoProjection findOne(Long id) {
        return repository.findPedidoById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

}
